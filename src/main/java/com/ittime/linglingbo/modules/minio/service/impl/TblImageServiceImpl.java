package com.ittime.linglingbo.modules.minio.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.minio.MinioConfig;
import com.ittime.linglingbo.modules.minio.MinioUtils;
import com.ittime.linglingbo.modules.minio.mapper.TblImageMapper;
import com.ittime.linglingbo.modules.minio.model.TblImage;
import com.ittime.linglingbo.modules.minio.service.TblImageService;
import io.minio.ObjectWriteResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * <p>
 * 图片信息表 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Service
public class TblImageServiceImpl extends ServiceImpl<TblImageMapper, TblImage> implements TblImageService {

    /**
     * 默认存储桶
     */
    @Value("${minio.bucketName}")
    private String bucketName;

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private MinioConfig minioConfig;



    @Override
    public String upload(MultipartFile file, Long imageId) {
        try {
            //文件名
            String fileName = file.getOriginalFilename();
            String newFileName = System.currentTimeMillis() + RandomUtil.randomStringUpper(10) + "." + StringUtils.substringAfterLast(fileName, ".");
            //类型
            String contentType = file.getContentType();
            ObjectWriteResponse objectWriteResponse = minioUtils.uploadFile(minioConfig.getBucketName(), file, newFileName, contentType);
            TblImage image = new TblImage()
                    .setImageName(newFileName)
                    .setBucketName(minioConfig.getBucketName())
                    .setImageUrl(getPresignedObjectUrl(newFileName))
                    .setImageId(imageId);
            baseMapper.insert(image);
            return objectWriteResponse.object();
        } catch (Exception e) {
            log.error("上传失败");
            return e.getMessage();
        }
    }

    @Override
    public void delete(String fileName) {
        minioUtils.removeFile(minioConfig.getBucketName(), fileName);
    }

    @Override
    public String getFileStatusInfo(String fileName) {
        return minioUtils.getFileStatusInfo(minioConfig.getBucketName(), fileName);
    }

    @Override
    public String getPresignedObjectUrl(String fileName) {
        return minioUtils.getPresignedObjectUrl(minioConfig.getBucketName(), fileName);
    }

    @Override
    public void download(String fileName, HttpServletResponse response) {

        try {
            InputStream fileInputStream = minioUtils.getObject(minioConfig.getBucketName(), fileName);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/force-download");
            response.setCharacterEncoding("UTF-8");
            IOUtils.copy(fileInputStream, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载失败");
        }

    }
}

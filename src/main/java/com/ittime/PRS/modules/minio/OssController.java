package com.ittime.PRS.modules.minio;

import cn.hutool.core.util.RandomUtil;
import com.ittime.PRS.common.api.CommonResult;
import com.ittime.PRS.modules.minio.model.TblImage;
import com.ittime.PRS.modules.minio.service.TblImageService;
import io.minio.ObjectWriteResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dujianghui
 */
@Slf4j
@RestController
@RequestMapping("/oss")
@Api(tags = "OssController")
@Tag(name = "OssController", description = "图片接口")
public class OssController {

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private TblImageService imageService;

    @PostMapping(value = "/upload", consumes = "multipart/*")
    @ApiOperation(value = "文件上传")
    public CommonResult upload(@ApiParam(value = "上传的文件", required = true) @RequestPart("file") MultipartFile file, @ApiParam(value = "图片id", required = true) Long imageId) {
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
            imageService.save(image);
            return CommonResult.success(objectWriteResponse.object());
        } catch (Exception e) {
            log.error("上传失败");
            return CommonResult.failed(e.getMessage());
        }
    }


    @DeleteMapping("/")
    @ApiOperation(value = "删除")
    public void delete(@RequestParam("fileName") String fileName) {
        minioUtils.removeFile(minioConfig.getBucketName(), fileName);
    }


    @GetMapping("/info")
    @ApiOperation(value = "获取文件信息")
    public String getFileStatusInfo(@RequestParam("fileName") String fileName) {
        return minioUtils.getFileStatusInfo(minioConfig.getBucketName(), fileName);
    }

    @GetMapping("/infos")
    @ApiOperation(value = "获取【多个】文件信息")
    public List<String> getFileStatusInfos(@RequestParam(value = "图片id") Long imageId) {
        List<String> res = new ArrayList<>();
        final List<String> collect = imageService.lambdaQuery().eq(TblImage::getImageId, imageId).list()
                .stream().map(TblImage::getImageName).collect(Collectors.toList());
        for (String imageName : collect) {
            final String fileStatusInfo = minioUtils.getFileStatusInfo(minioConfig.getBucketName(), imageName);
            res.add(fileStatusInfo);
        }
        return res;
    }

    @GetMapping("/url")
    @ApiOperation(value = "获取文件外链")
    public String getPresignedObjectUrl(@RequestParam("fileName") String fileName) {
        return minioUtils.getPresignedObjectUrl(minioConfig.getBucketName(), fileName);
    }

    @GetMapping("/urls")
    @ApiOperation(value = "获取【多个】文件外链")
    public List<String> getPresignedObjectUrls(@RequestParam(value = "图片id") Long imageId) {
        List<String> res = new ArrayList<>();
        final List<String> collect = imageService.lambdaQuery().eq(TblImage::getImageId, imageId).list()
                .stream().map(TblImage::getImageName).collect(Collectors.toList());
        for (String fileName : collect) {
            final String presignedObjectUrl = minioUtils.getPresignedObjectUrl(minioConfig.getBucketName(), fileName);
            res.add(presignedObjectUrl);
        }
        return res;
    }


    @GetMapping("/download")
    @ApiOperation(value = "文件下载")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
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

    @GetMapping("/downloads")
    @ApiOperation(value = "【多个】文件下载")
    public void downloads(@RequestParam(value = "图片id") Long imageId, HttpServletResponse response) {
        final List<String> collect = imageService.lambdaQuery().eq(TblImage::getImageId, imageId).list()
                .stream().map(TblImage::getImageName).collect(Collectors.toList());
        try {
            for (String fileName : collect) {
                InputStream fileInputStream = minioUtils.getObject(minioConfig.getBucketName(), fileName);
                response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
                response.setContentType("application/force-download");
                response.setCharacterEncoding("UTF-8");
                IOUtils.copy(fileInputStream, response.getOutputStream());
            }
        } catch (Exception e) {
            log.error("下载失败");
        }
    }

}
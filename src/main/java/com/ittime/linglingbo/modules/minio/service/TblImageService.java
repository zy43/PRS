package com.ittime.linglingbo.modules.minio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.minio.model.TblImage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 图片信息表 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */

public interface TblImageService extends IService<TblImage> {


    String upload(MultipartFile file,Long imageId);

    void delete(String fileName);

    String getFileStatusInfo(String fileName);

    String getPresignedObjectUrl(String fileName);

    void download(String fileName, HttpServletResponse response);


}

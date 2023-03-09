package com.ittime.PRS.modules.minio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.PRS.modules.minio.model.TblImage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 图片信息表 服务类
 * </p>

 */

public interface TblImageService extends IService<TblImage> {


    String upload(MultipartFile file,Long imageId);

    void delete(String fileName);

    String getFileStatusInfo(String fileName);

    String getPresignedObjectUrl(String fileName);

    void download(String fileName, HttpServletResponse response);


}

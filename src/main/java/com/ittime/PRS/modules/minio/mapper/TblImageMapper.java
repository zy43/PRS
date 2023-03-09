package com.ittime.PRS.modules.minio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittime.PRS.modules.minio.model.TblImage;

/**
 * <p>
 * 图片信息表 Mapper 接口
 * </p>
 */
public interface TblImageMapper extends BaseMapper<TblImage> {


    String getImageUrlById(Long imageId);
}

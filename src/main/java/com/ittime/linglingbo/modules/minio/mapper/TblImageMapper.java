package com.ittime.linglingbo.modules.minio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittime.linglingbo.modules.minio.model.TblImage;

/**
 * <p>
 * 图片信息表 Mapper 接口
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
public interface TblImageMapper extends BaseMapper<TblImage> {


    String getImageUrlById(Long imageId);
}

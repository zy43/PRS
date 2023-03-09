package com.ittime.PRS.modules.minio.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.PRS.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 图片信息表
 * </p>
 *
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_image")
@ApiModel(value = "TblImage对象", description = "图片信息表")
public class TblImage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("图片id")
    private Long imageId;

    @ApiModelProperty("图片名称")
    private String imageName;

    @ApiModelProperty("图片相对路径")
    private String imageUrl;

    @ApiModelProperty("minio桶名称")
    private String bucketName;


}

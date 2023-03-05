package com.ittime.linglingbo.modules.video.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_video_classification")
@ApiModel(value = "TblVideoClassification对象", description = "")
public class TblVideoClassification extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编号")
    private Long id;

    @ApiModelProperty("视频ID")
    private Long videoId;

    @ApiModelProperty("标签名称")
    private String tag;


}

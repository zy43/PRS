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
@TableName("tbl_video_hotwords")
@ApiModel(value = "TblVideoHotwords对象", description = "")
public class TblVideoHotwords extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编号（UUID）自动生成")
    private Long id;

    @ApiModelProperty("视频ID")
    private Long videoId;

    @ApiModelProperty("视频热词")
    private String videoHotwords;

    @ApiModelProperty("热词频率")
    private Double heatDegree;


}

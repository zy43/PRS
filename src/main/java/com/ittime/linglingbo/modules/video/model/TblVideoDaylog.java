package com.ittime.linglingbo.modules.video.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
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
@TableName("tbl_video_daylog")
@ApiModel(value = "TblVideoDaylog对象", description = "")
public class TblVideoDaylog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("日期")
    private Date logDate;

    @ApiModelProperty("视频id")
    private Long videoId;

    private Long videoDayLikes;

    private Long videoDayComments;

    private Long videoDayShares;


}

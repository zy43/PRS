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
@TableName("tbl_video_info")
@ApiModel(value = "TblVideoInfo对象", description = "")
public class TblVideoInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编号（UUID自动生成）")
    private Long id;

    @ApiModelProperty("视频ID")
    private Long videoId;

    @ApiModelProperty("视频名称")
    private String videoName;

    @ApiModelProperty("视频时长")
    private Integer videoDuration;

    @ApiModelProperty("视频链接")
    private String videoUrl;

    private String videoImg;

    private String videoIndustry;

    private Double videoHeat;

    @ApiModelProperty("博主ID")
    private Long streamerId;

    @ApiModelProperty("点赞数")
    private Long likes;

    @ApiModelProperty("评论数")
    private Long comments;

    @ApiModelProperty("分享数")
    private Long shares;

    private String musicName;

    @ApiModelProperty("视频背景音乐图片地址")
    private String musicImgUrl;

    private Long musicUsed;

    private String videoImageUrl;

    @ApiModelProperty("发布时间")
    private Date releaseTime;

    private Long playbackVolume;

    private Integer isRelatedGoods;

    private Long goodsId;

    private Double goodsInfluence;


}

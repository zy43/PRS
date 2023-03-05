package com.ittime.linglingbo.modules.video.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@Data
public class VideoAnalysisVo {
    @ApiModelProperty("唯一编号（UUID自动生成）")
    private Long id;

    @ApiModelProperty("视频ID")
    private Long videoId;

    @ApiModelProperty("视频名称")
    private String videoName;

    @ApiModelProperty("视频时长")
    private Integer videoDuration;

    private String videoImg;

    @ApiModelProperty("博主ID")
    private Long streamerId;

    @ApiModelProperty("点赞数")
    private Long likes;

    @ApiModelProperty("评论数")
    private Long comments;

    @ApiModelProperty("分享数")
    private Long shares;

    @ApiModelProperty("发布时间")
    private Date releaseTime;

    @ApiModelProperty("带货影响力")
    private Double goodsInfluence;

    @ApiModelProperty(value = "诊断时间")
    private String diagnoseTime;

    @ApiModelProperty("头像地址")
    private String imageUrl;

    @ApiModelProperty("主播名称")
    private String name;
}

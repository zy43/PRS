package com.ittime.linglingbo.modules.video.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/22
 **/
@Data
public class VideoInfoVo {

    @ApiModelProperty("唯一编号（UUID自动生成）")
    private Long id;

    @ApiModelProperty("视频ID")
    private Long videoId;

    @ApiModelProperty("视频名称")
    private String videoName;

    @ApiModelProperty("视频热词")
    private List<String> hotWords;

    @ApiModelProperty("视频时长")
    private Integer videoDuration;

    private String videoImg;

    @ApiModelProperty("博主ID")
    private Long streamerId;

    @ApiModelProperty("播主名称")
    private String streamerName;

    @ApiModelProperty("粉丝数量")
    private Long totalFans;

    @ApiModelProperty("点赞数")
    private Long likes;

    @ApiModelProperty("评论数")
    private Long comments;

    @ApiModelProperty("发布时间")
    private Date releaseTime;


}

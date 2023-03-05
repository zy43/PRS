package com.ittime.linglingbo.modules.video.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class HotVideoVO {

    @ApiModelProperty("视频名称")
    private String videoName;

    @ApiModelProperty("视频时长")
    private Integer videoDuration;

    @ApiModelProperty("播主姓名")
    private String streamerName;

    @ApiModelProperty("发布时间")
    private Date releaseTime;

    @ApiModelProperty("点赞数")
    private Long likes;

}

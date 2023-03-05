package com.ittime.linglingbo.modules.video.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class VideoRankVO {

    @ApiModelProperty("视频ID")
    private Long videoId;

    @ApiModelProperty("视频名称")
    private String videoName;

    @ApiModelProperty("视频图片")
    private String videoImg;

    @ApiModelProperty("播主名字")
    private String streamerName;

    @ApiModelProperty("视频点赞增量")
    private Long likes_add = Long.valueOf(0);

    @ApiModelProperty("关联商品名")
    private String goodsName;

}

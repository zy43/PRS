package com.ittime.linglingbo.modules.ums.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: dzy
 * @date: 2022/12/19 21:53
 * @email: 3323939959@qq.com
 */
@Data
public class UmsVideoDetailVO {

    @ApiModelProperty("视频标题")
    private String videoName;

    @ApiModelProperty("发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime releaseTime;

    @ApiModelProperty("点赞数量")
    private Long likes;

    @ApiModelProperty("评论数量")
    private Long comments;

    @ApiModelProperty("分享数")
    private Long shares;

    @ApiModelProperty("视频热度")
    private Double videoHeat;

    @ApiModelProperty("图片url")
    private String videoImg;
}

package com.ittime.linglingbo.modules.video.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@Data
public class VideoReviewVo {

    @ApiModelProperty("评论用户头像 20200720 sanrenhe")
    private String commentUserImg;

    @ApiModelProperty("评论用户")
    private String commentUser;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("被点赞数")
    private Long liked;

    @ApiModelProperty("评论时间")
    private Date commentTime;
}

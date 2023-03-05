package com.ittime.linglingbo.modules.ums.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: dzy
 * @date: 2022/12/15 22:09
 * @email: 3323939959@qq.com
 */
@Data
public class UmsGeneralVO {

    @ApiModelProperty(value = "最新作品数")
    private Long newProduct;

    @ApiModelProperty(value = "粉丝增量")
    private Long fansAdd;

    @ApiModelProperty(value = "新增点赞")
    private Long likesAdd;

    @ApiModelProperty(value = "新增评论")
    private Long commentsAdd;

    @ApiModelProperty(value = "新增转发")
    private Long sharesAdd;

    @ApiModelProperty(value = "粉丝趋势7天")
    private List<Long> fansAddList;

    @ApiModelProperty(value = "点赞趋势")
    private List<Long> likesAddList;

    @ApiModelProperty(value = "评论趋势")
    private List<Long> commentsAddList;

    @ApiModelProperty(value = "10个作品点赞趋势")
    private List<Long> lastTenVideoLikesList;

    @ApiModelProperty(value = "10个作品点赞趋势")
    private List<Long> lastTenVideoCommentsList;

    @ApiModelProperty(value = "近10个作品发布日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private List<Date> lastTenVideoDateList;
}

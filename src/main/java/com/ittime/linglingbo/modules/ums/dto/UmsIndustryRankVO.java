package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: dzy
 * @date: 2022/12/22 19:10
 * @email: 3323939959@qq.com
 */
@Data
public class UmsIndustryRankVO {

    @ApiModelProperty("播主id")
    private Long streamerId;

    @ApiModelProperty("播主")
    private String streamerName;

    @ApiModelProperty("粉丝数")
    private Long totalFans;

    @ApiModelProperty("平均点赞")
    private Long avgLikes;

    @ApiModelProperty("平均评论")
    private Long avgComments;

    @ApiModelProperty("平均分享")
    private Long avgShares;

    @ApiModelProperty("播主头像")
    private String imageUrl;

    @ApiModelProperty("排名提升")
    private Long fansRankRise;

    @ApiModelProperty("排名")
    private Long tRank;
}

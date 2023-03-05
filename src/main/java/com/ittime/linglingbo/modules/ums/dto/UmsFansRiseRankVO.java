package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: dzy
 * @date: 2022/12/23 22:45
 * @email: 3323939959@qq.com
 */
@Data
public class UmsFansRiseRankVO {

    @ApiModelProperty("播主id")
    private Long streamerId;

    @ApiModelProperty("播主")
    private String streamerName;

    @ApiModelProperty("粉丝增量")
    private Long fansRise;

    @ApiModelProperty("播主头像")
    private String imageUrl;

    @ApiModelProperty("排名提升")
    private Long fansRankRise;

    @ApiModelProperty("粉丝总量")
    private Long totalFans;

    @ApiModelProperty("排名")
    private Long fansRank;
}

package com.ittime.linglingbo.modules.owner.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Josh-ZJUT
 * @date 2022/12/29 14:47
 * @email dujianghui537885@163.com
 */
@Data
public class OwnerDetailVo {
    @ApiModelProperty("品牌商ID")
    private Long ownerId;

    @ApiModelProperty("品牌商名称")
    private String ownerName;

    @ApiModelProperty("品牌分类")
    private String industry;

    @ApiModelProperty("关联视频数")
    private Long relateVideos;

    @ApiModelProperty("关联直播场次")
    private Long relateLives;

    @ApiModelProperty("关联播主数")
    private Long relateStreamers;

    @ApiModelProperty("关联直播播主数")
    private Long relateLiveStreamers;


    @ApiModelProperty("抖音商品数")
    private Long relateGoodsDouyin;
}

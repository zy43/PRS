package com.ittime.linglingbo.modules.goods.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsRankVO {

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品图片")
    private String goodsImg;

    @ApiModelProperty("关联视频数")
    private Long relatedVideo;

    @ApiModelProperty("抖音浏览量增量")
    private Long increaseDayPlayback;

    @ApiModelProperty("销量")
    private Long goodsSales;

    @ApiModelProperty("售价")
    private Long price;

}

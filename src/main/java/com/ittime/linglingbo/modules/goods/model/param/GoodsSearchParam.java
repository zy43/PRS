package com.ittime.linglingbo.modules.goods.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Josh-ZJUT
 * @date 2022/12/19 16:00
 * @email dujianghui537885@163.com
 */
@Data
public class GoodsSearchParam {
    @ApiModelProperty("最近几天的数据")
    private Integer day;

    @ApiModelProperty("商品分类")
    private String goodsTag;

    @ApiModelProperty("售价左边界，默认为0")
    private int priceFrom;

    @ApiModelProperty("售价右边界")
    private Integer priceTo;

    @ApiModelProperty("销量左边界，默认为0")
    private int goodsSalesFrom;

    @ApiModelProperty("销量右边界")
    private Integer goodsSalesTo;

    @ApiModelProperty("关联博主数左边界，默认为0")
    private long relatedStreamerFrom;

    @ApiModelProperty("关联博主数右边界")
    private Long relatedStreamerTo;

    @ApiModelProperty("关联视频数左边界，默认为0")
    private long relatedVideoFrom;

    @ApiModelProperty("关联视频数右边界")
    private Long relatedVideoTo;
}

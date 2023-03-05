package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: dzy
 * @date: 2022/12/20 22:54
 * @email: 3323939959@qq.com
 */
@Data
public class UmsGoodsVO {

    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("点赞总量")
    private Integer likes;

    @ApiModelProperty("关联视频数")
    private Integer videoNum;

    @ApiModelProperty("全网销量总量")
    private Integer sales;

    @ApiModelProperty("商品价格")
    private BigDecimal goodsPrice;
}

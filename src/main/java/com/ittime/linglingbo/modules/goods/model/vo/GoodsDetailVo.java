package com.ittime.linglingbo.modules.goods.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhl129
 * @date 2022/10/26 10:51
 * @email 1293384775@qq.com
 */
@Data
public class GoodsDetailVo {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品数量")
    private Integer goodsNum;

    @ApiModelProperty("商品售价")
    private BigDecimal goodsPrice;

    @ApiModelProperty("图片id")
    private Long imageId;

    @ApiModelProperty("商品品牌")
    private String goodsBrand;

    @ApiModelProperty("商品所属分类")
    private Long categoryId;

    @ApiModelProperty("商品描述")
    private String goodsDesc;

    @ApiModelProperty("商品规格")
    private String goodsSpec;
}

package com.ittime.linglingbo.modules.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_goods")
@ApiModel(value = "TblGoods对象", description = "商品表")
public class TblGoods extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("品牌商id，对应owner的id属性")
    private Long ownerId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品数量")
    private Integer goodsNum;

    @ApiModelProperty("商品售价")
    private BigDecimal goodsPrice;

    @ApiModelProperty("是否上架 1: 已上架 2: 已下架")
    private Integer isShelf;

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

package com.ittime.linglingbo.modules.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_goods_audience")
@ApiModel(value = "TblGoodsAudience对象", description = "")
public class TblGoodsAudience extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编号（UUID自动生成）")
    private Long id;

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品用户男性占比")
    private Double pMale;

    @ApiModelProperty("商品用户女性占比")
    private Double pFemale;

    @ApiModelProperty("用户年龄段（6-17岁）占比")
    @JsonProperty("p_age6_17")
    private Double pAge617;

    @ApiModelProperty("用户年龄段（18-24岁）占比")
    @JsonProperty("p_age18_24")
    private Double pAge1824;

    @ApiModelProperty("用户年龄段（25-30岁）占比")
    @JsonProperty("p_age25_30")
    private Double pAge2530;

    @ApiModelProperty("用户年龄段（31-35岁）占比")
    @JsonProperty("p_age31_35")
    private Double pAge3135;

    @ApiModelProperty("用户年龄段（36-40岁）占比")
    @JsonProperty("p_age36_40")
    private Double pAge3640;

    @ApiModelProperty("用户年龄段（41岁以上）占比")
    @JsonProperty("p_age41")
    private Double pAge41;

    @ApiModelProperty("商品用户所在省份")
    private String pProvince;

    @ApiModelProperty("商品用户所在城市")
    private String pCity;

    @ApiModelProperty("占比")
    private Double pProportion;


}

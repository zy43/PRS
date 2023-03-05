package com.ittime.linglingbo.modules.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
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
@TableName("tbl_goods_hotwords")
@ApiModel(value = "TblGoodsHotwords对象", description = "")
public class TblGoodsHotwords extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long goodsId;

    private String goodsHotwords;

    private Double heatDegree;


}

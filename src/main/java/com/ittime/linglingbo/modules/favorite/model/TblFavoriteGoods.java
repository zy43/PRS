package com.ittime.linglingbo.modules.favorite.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品收藏表
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_favorite_goods")
@ApiModel(value = "TblFavoriteGoods对象", description = "商品收藏表")
public class TblFavoriteGoods extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("用户ID")
    private Long adminId;

    @ApiModelProperty("商品ID")
    private Long goodsId;


}
package com.ittime.linglingbo.modules.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 带货商品分类表
 * </p>
 *
 * @author Zhl
 * @since 2022-10-24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_category_goods")
@ApiModel(value = "TblCategoryGoods对象", description = "带货商品分类表")
public class TblCategoryGoods extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("带货商品分类名")
    private String categoryName;

    @ApiModelProperty("商品分类描述")
    private String categoryDesc;


}

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
 *
 * </p>
 *
 * @author Zhl
 * @since 2022-10-24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_cate_goods_relation")
@ApiModel(value = "TblCateGoodsRelation对象", description = "商品分类关系表")
public class TblCateGoodsRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("业务对象id（task，streamer，owner）")
    private Long objectId;

    @ApiModelProperty("商品分类id")
    private Long cateGoodsId;

    @ApiModelProperty("id 类型(streamer,owner,task)")
    private String clientType;

    public TblCateGoodsRelation() {

    }

    public TblCateGoodsRelation(Long objectId, Long cateGoodsId, String clientType) {
        this.objectId = objectId;
        this.cateGoodsId = cateGoodsId;
        this.clientType = clientType;
    }

}

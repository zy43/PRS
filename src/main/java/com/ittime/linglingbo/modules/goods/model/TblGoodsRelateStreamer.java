package com.ittime.linglingbo.modules.goods.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author Josh
 * @since 2022-12-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_goods_relate_streamer")
@ApiModel(value = "TblGoodsRelateStreamer对象", description = "")
public class TblGoodsRelateStreamer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键 20200721 sanrenhe")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品id 20200721 sanrnehe")
    private Long goodsId;

    @ApiModelProperty("播主id 20200721 sanrenhe")
    private Long streamerId;

    @ApiModelProperty("播主分类 20200721 sanrenhe")
    private String streamerCategory;


}

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
@TableName("tbl_goods_relate_video")
@ApiModel(value = "TblGoodsRelateVideo对象", description = "")
public class TblGoodsRelateVideo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键 20200721 sanrenhe")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品id 20200721 sanrnehe")
    private Long goodsId;

    @ApiModelProperty("视频id 20200721 sanrnehe")
    private Long videoId;

    @ApiModelProperty("关联主播id 20200723 sanrenhe")
    private Long streamerId;

    @ApiModelProperty("销量")
    private Long sales;

    @ApiModelProperty("视频类型 20200721 sanrnehe")
    private String videoCategory;

    @ApiModelProperty("点赞量 20200721 sanrnehe")
    private Long diggCount;


}

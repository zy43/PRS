package com.ittime.linglingbo.modules.goods.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/22
 **/
@Data
public class GoodsAppendVo {

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品品牌")
    private String goodsBrand;

    @ApiModelProperty("商品图片")
    private String goodsImg;

    @ApiModelProperty("店铺图片")
    private String shopImg;

    @ApiModelProperty("商品总播放（浏览）量")
    private Long playbackVolume;

    @ApiModelProperty("关联视频数")
    private Long relatedVideo;

    @ApiModelProperty("售价")
    private Integer price;

    @ApiModelProperty("销量")
    private Integer goodsSales;


}

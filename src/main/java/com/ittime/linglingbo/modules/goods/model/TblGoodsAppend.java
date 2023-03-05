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
 * @author Josh
 * @since 2022-12-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_goods_append")
@ApiModel(value = "TblGoodsAppend对象", description = "")
public class TblGoodsAppend extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品分类")
    private String goodsTag;

    @ApiModelProperty("商品品牌")
    private String goodsBrand;

    @ApiModelProperty("商品图片")
    private String goodsImg;

    @ApiModelProperty("店铺图片")
    private String shopImg;

    @ApiModelProperty("店铺")
    private String shop;

    @ApiModelProperty("售价")
    private Integer price;

    @ApiModelProperty("原价 20170719 sanrenhe")
    private Integer originalPrice;

    @ApiModelProperty("销量")
    private Integer goodsSales;

    @ApiModelProperty("商品总播放（浏览）量")
    private Long playbackVolume;

    @ApiModelProperty("关联视频数")
    private Long relatedVideo;

    @ApiModelProperty("商品关联视频点赞总数 2020719新增字段")
    private Long relatedVideoDiggCount;

    @ApiModelProperty("关联博主数")
    private Long relatedStreamer;

    @ApiModelProperty("商品日浏览量增量")
    private Long increaseDayPlayback;

    @ApiModelProperty("日销量增量")
    private Long increaseDaySales;

    @ApiModelProperty("每日增长关联视频数")
    private Long increaseDayRevideo;

    @ApiModelProperty("每日增长关联博主数")
    private Long increaseDayRelabro;

    @ApiModelProperty("热度")
    private Long hotDegree;

    @ApiModelProperty("排行榜上升趋势")
    private Integer rankTrend;

    @ApiModelProperty("浏览量趋势")
    private Double playbackTrend;

    @ApiModelProperty("店铺排行榜上升趋势")
    private Integer shopTrend;


}

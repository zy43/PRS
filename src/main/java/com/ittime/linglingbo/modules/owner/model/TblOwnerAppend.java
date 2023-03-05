package com.ittime.linglingbo.modules.owner.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * @since 2022-12-29
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_owner_append")
@ApiModel(value = "TblOwnerAppend对象", description = "")
public class TblOwnerAppend extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("品牌商ID")
    private Long ownerId;

    @ApiModelProperty("品牌商名称")
    private String ownerName;

    @ApiModelProperty("品牌分类")
    private String industry;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("品牌商简介")
    private String introduction;

    @ApiModelProperty("商品来源")
    private String comeFrom;

    private Integer blueV;

    @ApiModelProperty("总粉丝数")
    private Long totalFans;

    @ApiModelProperty("总视频数")
    private Long totalVideos;

    @ApiModelProperty("总点赞数")
    private Long totalLikes;

    @ApiModelProperty("总分享数")
    private Long totalShares;

    @ApiModelProperty("总评论数")
    private Long totalComments;

    private BigDecimal starIndex;

    @ApiModelProperty("男生比例, 10.50 表示 10.5%")
    private BigDecimal percentMan;

    @ApiModelProperty("蓝V排行上升 正为上升 负为下降 20200719 sanrenhe")
    private Long blueVRankRise;

    @ApiModelProperty("地区排行上升 正为上升 负为下降 20200719 sanrenhe")
    private Long regionRankRise;

    @ApiModelProperty("涨粉排行上升 正为上升 负为下降 20200719 sanrenhe")
    private Long fansRankRise;

    @ApiModelProperty("行业排行上升 正为上升 负为下降 20200719 sanrenhe")
    private Long industryRankRise;

    @ApiModelProperty("近30天点赞增量 正为上升 负为下降 20200719 sanrenhe")
    private Long monthDiggRankRise;

    @ApiModelProperty("近30天作品数  20200722 sanrenhe")
    private Long monthWorks;

    @ApiModelProperty("近30天粉丝增量 正为上升 负为下降 20200722 sanrenhe")
    private Long monthFansRankRise;

    @ApiModelProperty("粉丝画像主要地域（省级行政区） 20200720 sanrenhe")
    private String portraitProvince;

    @ApiModelProperty("粉丝画像主要地域（地级市） 20200720 sanrenhe ")
    private String portraitCity;

    @ApiModelProperty("粉丝画像主要年龄 20200720 sanrenhe")
    private Integer portraitAge;

    @ApiModelProperty("粉丝画像主要性别 （1-男、2-女） 20200720 sanrenhe")
    private Integer portraitSex;

    @ApiModelProperty("直播销量")
    private Long liveSales;

    private Integer frequency;

    @ApiModelProperty("品牌热词，用英文逗号分隔")
    private String hotWords;

    @ApiModelProperty("热度")
    private Integer heat;

    @ApiModelProperty("热度涨幅")
    private BigDecimal heatRise;

    @ApiModelProperty("关联视频数")
    private Long relateVideos;

    @ApiModelProperty("关联直播场次")
    private Long relateLives;

    @ApiModelProperty("关联播主数")
    private Long relateStreamers;

    @ApiModelProperty("关联直播播主数")
    private Long relateLiveStreamers;

    @ApiModelProperty("关联人数峰值")
    private Long relateFansTop;

    @ApiModelProperty("抖音商品数")
    private Long relateGoodsDouyin;


}

package com.ittime.linglingbo.modules.ums.dto;

import com.ittime.linglingbo.modules.fans.model.TblFansRegion;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import java.util.List;
import java.util.Set;


/**
 * @author zhl129
 * @date 2022/12/29 9:46
 * @email 1293384775@qq.com
 */
@Data
public class StreamerCompareDetailVo {

    @ApiModelProperty("主播ID")
    private Long streamerId;

    @ApiModelProperty("播主")
    private String streamerName;

    @ApiModelProperty("头像")
    private String imageUrl;

    @ApiModelProperty("分类")
    private String industry;

    @ApiModelProperty("总粉丝数")
    private Long totalFans;

    @ApiModelProperty("行业周榜单")
    private String industryRank;

    @ApiModelProperty("近30天粉丝增量 正为上升 负为下降")
    private Long monthFansRankRise;

    @ApiModelProperty("近30天点赞增量 正为上升 负为下降")
    private Long monthDiggRankRise;

    @ApiModelProperty("集均点赞")
    private Long averageLikes;

    @ApiModelProperty("集均评论")
    private Long averageComments;

    @ApiModelProperty("集均分享")
    private Long averageShares;

    @ApiModelProperty("近30天作品数 ")
    private Long monthWorks;

    @ApiModelProperty("男性比例")
    private Double maleProportion;

    @ApiModelProperty("女性比例")
    private Double femaleProportion;

    @ApiModelProperty("粉丝年龄段6-17占比")
    private Double group617;

    @ApiModelProperty("粉丝年龄段18-24占比")
    private Double group1824;

    @ApiModelProperty("粉丝年龄段25-30占比")
    private Double group2530;

    @ApiModelProperty("粉丝地域分布")
    private List<TblFansRegion> fansRegions;

    @ApiModelProperty("粉丝评论热词")
    private Set<String> fansHotWords;

    @ApiModelProperty("购物车开通情况")
    private String ShoppingCartOpen;

    @ApiModelProperty("电商橱窗商品数")
    private Integer goodsNum;

    @ApiModelProperty("达人销售榜")
    private String saleRank;

    @ApiModelProperty("电商视频数")
    private Integer videoNum;

    @ApiModelProperty("电商集均点赞")
    private Long elecAverageLikes;

    @ApiModelProperty("电商集均评论")
    private Long elecAverageComments;

    @ApiModelProperty("电商集均分享")
    private Long elecAverageShares;

    @ApiModelProperty("主推商品分类")
    private String recommendIndustry;

    @ApiModelProperty("合作品牌")
    private String cooperateBrand;
}

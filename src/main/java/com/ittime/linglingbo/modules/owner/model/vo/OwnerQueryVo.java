package com.ittime.linglingbo.modules.owner.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Josh-ZJUT
 * @date 2022/12/29 14:47
 * @email dujianghui537885@163.com
 */
@Data
public class OwnerQueryVo {
    @ApiModelProperty("品牌商ID")
    private Long ownerId;

    @ApiModelProperty("品牌商名称")
    private String ownerName;

    @ApiModelProperty("品牌商简介")
    private String introduction;

    @ApiModelProperty("抖音商品数")
    private Long relateGoodsDouyin;

    @ApiModelProperty("总视频数")
    private Long totalVideos;

    @ApiModelProperty("总点赞数")
    private Long totalLikes;

    @ApiModelProperty("总分享数")
    private Long totalShares;

    @ApiModelProperty("总评论数")
    private Long totalComments;

    @ApiModelProperty("品牌热词，用英文逗号分隔")
    private String hotWords;

    @ApiModelProperty("品牌热词，用英文逗号分隔")
    private String[] hotWordsArray;

    @ApiModelProperty("男生比例, 10.50 表示 10.5%")
    private BigDecimal percentMan;

    @ApiModelProperty("女生比例, 10.50 表示 10.5%")
    private BigDecimal percentWoman;
}

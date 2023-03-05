package com.ittime.linglingbo.modules.client.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AccurateSearchListVO {


    @ApiModelProperty("主播名字")
    private String streamerName;

//    @ApiModelProperty("抖音号ID")
//    private String ownerName;

    @ApiModelProperty("主播简介")
    private String introduction;

    @ApiModelProperty("私人联系方式")
    private String contactInformation;

    @ApiModelProperty("合作")
    private String cooperation;

    @ApiModelProperty("微博")
    private String blog;

    @ApiModelProperty("分类")
    private String industry;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("粉丝总量")
    private Long totalFans;

    @ApiModelProperty("作品总量")
    private Long totalVideos;

    @ApiModelProperty("点赞总量")
    private Long totalLikes;

    @ApiModelProperty("近三十天粉丝增量")
    private Long monthFansRankRise;

    @ApiModelProperty("近三十天作品数")
    private Long monthWorks;

    @ApiModelProperty("近三十天点赞增量")
    private Long monthDiggRankRise;


}

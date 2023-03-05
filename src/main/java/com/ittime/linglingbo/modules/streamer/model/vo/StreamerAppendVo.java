package com.ittime.linglingbo.modules.streamer.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：收藏主播Vo类
 * @Author zy-zjut
 * @Date 2022/12/21
 **/
@Data
public class StreamerAppendVo {

    @ApiModelProperty("主播ID")
    private Long streamerId;

    @ApiModelProperty("播主名称")
    private String streamerName;

    @ApiModelProperty("头像地址")
    private String imageUrl;

    @ApiModelProperty("分类")
    private String industry;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("博主简介")
    private String introduction;

    @ApiModelProperty("私人联系方式")
    private String contactInformation;

    @ApiModelProperty("合作")
    private String cooperation;

    @ApiModelProperty("围脖")
    private String blog;

    private Long totalFans;

    private Long totalVideos;

    private Long totalLikes;

    @ApiModelProperty("近30天点赞增量 正为上升 负为下降 20200719 sanrenhe")
    private Long monthDiggRankRise;

    @ApiModelProperty("近30天作品数  20200722 sanrenhe")
    private Long monthWorks;

    @ApiModelProperty("近30天粉丝增量 正为上升 负为下降 20200722 sanrenhe")
    private Long monthFansRankRise;
}

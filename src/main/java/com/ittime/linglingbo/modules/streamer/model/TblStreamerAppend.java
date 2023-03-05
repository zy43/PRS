package com.ittime.linglingbo.modules.streamer.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@TableName("tbl_streamer_append")
@ApiModel(value = "TblStreamerAppend对象", description = "")
public class TblStreamerAppend extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "streamer_id")
    private Long streamerId;

    @ApiModelProperty("播主")
    private String streamerName;

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

    @ApiModelProperty("账号类型（1-个人、2-企业、3-电商）")
    private Integer accountType;

    private Integer blueV;

    private Long totalFans;

    private Long totalVideos;

    private Long totalLikes;

    private Long totalShares;

    private Long totalComments;

    private BigDecimal starIndex;

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

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("授权信息")
    private Long authorize;

    @ApiModelProperty("授权时间")
    private String authorizeTime;

    @ApiModelProperty("mcn机构名称")
    private String mcnName;

    @ApiModelProperty("mcn所属企业")
    private String company;

    @ApiModelProperty("官网网址")
    private String website;

    @ApiModelProperty("联系人")
    private String contact;

    @ApiModelProperty("电话")
    private String tel;

    @ApiModelProperty("微信")
    private String wechat;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("签约达人数")
    private Integer signNum;

}

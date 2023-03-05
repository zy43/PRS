package com.ittime.linglingbo.modules.client.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 播主/MCN 表
 *
 * @author Josh
 * @since 2022-09-28
 */
@Getter
@Setter
@TableName("ums_admin_streamer")
@ApiModel(value = "UmsAdminStreamer对象", description = "播主/MCN 表")
@Accessors(chain = true)
public class UmsAdminStreamer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("主播名称")
    private String hostName;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("认证状态（审核中、已认证、未认证）")
    private String certification;

    @ApiModelProperty("图片id")
    private Long imageId;

    @ApiModelProperty("账户余额")
    private BigDecimal accountBalance;

    @ApiModelProperty("所属行业")
    private String industry;

    @ApiModelProperty("播主所属MCN，若为-1则为MCN机构，不是-1就是主播内容为所属MCNid")
    private String belongTo;

    @ApiModelProperty("所属平台")
    private String platform;

    @ApiModelProperty("主播描述")
    private String streamerDesc;


}

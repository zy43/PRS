package com.ittime.linglingbo.modules.client.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 品牌商/政府机构表
 * </p>
 *
 * @author Josh
 * @since 2022-09-28
 */
@Getter
@Setter
@TableName("ums_admin_owner")
@ApiModel(value = "UmsAdminOwner对象", description = "品牌商/政府机构表")
public class UmsAdminOwner extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("品牌商/政府机构名称")
    private String ownerName;

    @ApiModelProperty("法人姓名")
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

    @ApiModelProperty("联系人姓名")
    private String contactName;

    @ApiModelProperty("联系人手机号")
    private String contactTel;

    @ApiModelProperty("所属企业名称")
    private String companyName;

    @ApiModelProperty("保证金缴纳状态（未缴费、已缴费、余额不足）")
    private String depositStatus;

    @ApiModelProperty("品牌商描述")
    private String ownerDesc;

}

package com.ittime.linglingbo.modules.task.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 主播/品牌商提现表
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_client_withdraw_cash")
@ApiModel(value = "TblClientWithdrawCash对象", description = "主播/品牌商提现表")
public class TblClientWithdrawCash extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("主播/品牌商id")
    private Long clientId;

    @ApiModelProperty("所属企业名称(主播可不填，也可以填主播账号名称)")
    private String companyName;

    @ApiModelProperty("提现金额")
    private BigDecimal withdrawAmount;

    @ApiModelProperty("提现卡号")
    private String cardNum;

    @ApiModelProperty("开户行")
    private String bank;

    @ApiModelProperty("提现人姓名")
    private String personName;

    @ApiModelProperty("备注描述")
    private String remark;

    @ApiModelProperty("状态 1: 审核中2: 已完成 3: 提现失败")
    private Integer withdrawStatus;

    @ApiModelProperty("审核人id(管理员)")
    private Long auditorAdminId;

    @ApiModelProperty("角色id")
    private Long roleId;


}

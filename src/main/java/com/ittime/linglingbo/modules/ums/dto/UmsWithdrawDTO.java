package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: dzy
 * @date: 2022/12/1 14:40
 * @email: 3323939959@qq.com
 */
@Data
public class UmsWithdrawDTO {

    @ApiModelProperty("品牌商或播主id")
    private Long clientId;

    @ApiModelProperty("所属公司名称")
    private String companyName;

    @ApiModelProperty("提现金额")
    private BigDecimal withdrawAmount;

    @ApiModelProperty("提现卡号")
    private String cardNum;

    @ApiModelProperty("开户银行")
    private String bank;

    @ApiModelProperty("提现人姓名")
    private String personName;

    @ApiModelProperty("提现状态")
    private Integer withdrawStatus;

    @ApiModelProperty("审核人id")
    private Long auditorAdminId;

    @ApiModelProperty("角色id")
    private Integer roleId;

}

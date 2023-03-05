package com.ittime.linglingbo.modules.ums.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: dzy
 * @date: 2022/11/23 11:06
 * @email: 3323939959@qq.com
 */
@Data
public class UmsWithdrawRecordVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("所属企业名称")
    private String companyName;

    @ApiModelProperty("提现卡号")
    private String cardNum;

    @ApiModelProperty("提现人姓名")
    private String personName;

    @ApiModelProperty("提现金额")
    private BigDecimal withdrawAmount;

    @ApiModelProperty("账户余额")
    private BigDecimal accountBalance;

    @ApiModelProperty("状态")
    private Integer withdrawStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}

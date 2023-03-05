package com.ittime.linglingbo.modules.workbench.vo.owner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhl129
 * @date 2022/12/22 20:19
 * @email 1293384775@qq.com
 */
@Data
public class OwnerAccountVo {

    @ApiModelProperty("品牌商id")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("电话")
    private String tel;

    @ApiModelProperty("认证状态")
    private String certification;

    @ApiModelProperty("账户余额")
    private BigDecimal accountBalance;

    @ApiModelProperty("任务消耗 -- 所有状态为履约中的任务保证金")
    private BigDecimal taskConsume;

    @ApiModelProperty("账户结算 -- 品牌商发出的所有任务的结算金额")
    private BigDecimal accountSettle;
}

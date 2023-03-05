package com.ittime.linglingbo.modules.workbench.vo.owner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhl129
 * @date 2022/12/22 20:38
 * @email 1293384775@qq.com
 */
@Data
public class OwnerSettleDataVo {


    @ApiModelProperty("预算总额")
    private BigDecimal budgetCount;

    @ApiModelProperty("结算总额")
    private BigDecimal settleCount;

    @ApiModelProperty("销售总量")
    private Integer saleCount;

    @ApiModelProperty("收入产值")
    private BigDecimal incomeCount;
}

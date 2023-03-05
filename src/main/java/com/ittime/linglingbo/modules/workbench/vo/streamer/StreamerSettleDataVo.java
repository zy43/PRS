package com.ittime.linglingbo.modules.workbench.vo.streamer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhl129
 * @date 2022/12/22 14:56
 * @email 1293384775@qq.com
 */

@Data
public class StreamerSettleDataVo {

    @ApiModelProperty("收益总额")
    private BigDecimal incomeCount;

    @ApiModelProperty("结算总额")
    private BigDecimal settleCount;

    @ApiModelProperty("销售总额")
    private Integer saleCount;

    @ApiModelProperty("提现总额")
    private BigDecimal withdrawCount;

}

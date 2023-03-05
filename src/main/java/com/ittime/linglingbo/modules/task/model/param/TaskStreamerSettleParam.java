package com.ittime.linglingbo.modules.task.model.param;

import com.ittime.linglingbo.modules.task.model.TblTaskSettle;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Josh-ZJUT
 * @date 2022/11/22 11:42
 * @email dujianghui537885@163.com
 */
@Data
public class TaskStreamerSettleParam {


    @ApiModelProperty("任务id")
    private Long taskId;

    @ApiModelProperty("结算金额")
    private BigDecimal settleMoney;

    @ApiModelProperty("结算备注")
    private String settleRemark;

    @ApiModelProperty("播主完成量")
    private Integer completeNum;

    @ApiModelProperty("平台佣金金额")
    private BigDecimal platformCommission;

    @ApiModelProperty("商品结算明细")
    private List<TblTaskSettle> goodsSettles;
}

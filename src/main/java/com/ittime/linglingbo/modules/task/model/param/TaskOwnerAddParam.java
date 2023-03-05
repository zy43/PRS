package com.ittime.linglingbo.modules.task.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Josh-ZJUT
 * @date 2022/10/21 12:59
 * @email dujianghui537885@163.com
 */
@Data
public class TaskOwnerAddParam {
    @ApiModelProperty("选中商品id列表")
    List<Long> goodsIds;
//    List<TaskGoodsParam> taskGoodsParams;

    @ApiModelProperty("任务id")
    private Long taskId;
    @ApiModelProperty("任务名称")
    private String taskName;
    @ApiModelProperty("合作模式： 1: 纯佣金模式 2: 佣金加坑位费")
    private Integer cooperationModel;
    @ApiModelProperty("佣金比例")
    private BigDecimal commissionPercent;
    @ApiModelProperty("预算金额")
    private BigDecimal budget;
    @ApiModelProperty("任务描述")
    private String taskDesc;
    @ApiModelProperty("保证金额度")
    private BigDecimal earnestMoney;
}

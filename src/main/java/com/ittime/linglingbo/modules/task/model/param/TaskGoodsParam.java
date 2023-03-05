package com.ittime.linglingbo.modules.task.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Josh-ZJUT
 * @date 2022/10/21 13:27
 * @email dujianghui537885@163.com
 */
@Data
public class TaskGoodsParam {


    @ApiModelProperty("任务id")
    private Long taskId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品数量")
    private Integer goodsNum;

    @ApiModelProperty("商品售价")
    private BigDecimal goodsPrice;

    @ApiModelProperty("商品规格")
    private String goodsSpec;

    @ApiModelProperty("商品id")
    private Long goodsId;

}

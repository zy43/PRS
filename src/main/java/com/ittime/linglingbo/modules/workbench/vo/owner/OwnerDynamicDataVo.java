package com.ittime.linglingbo.modules.workbench.vo.owner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhl129
 * @date 2022/12/22 20:37
 * @email 1293384775@qq.com
 */
@Data
public class OwnerDynamicDataVo {

    @ApiModelProperty("品牌总量")
    private Integer brandCount;

    @ApiModelProperty("播主总量")
    private Integer streamerCount;

    @ApiModelProperty("商品总量")
    private Integer goodsCount;

    @ApiModelProperty("销售总量")
    private Integer saleCount;

    @ApiModelProperty("任务总量")
    private Integer taskCount;

    @ApiModelProperty("发布任务量（为现存成功发布任务量）")
    private Integer waitUndertakeTaskCount;

    @ApiModelProperty("结算任务量（为累计成功完成任务量）")
    private Integer settleTaskCount;

    @ApiModelProperty("待处理任务量（为现存待处理任务量）")
    private Integer waitHandleTaskCount;


}

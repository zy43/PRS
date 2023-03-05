package com.ittime.linglingbo.modules.task.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Josh-ZJUT
 * @date 2022/11/22 11:42
 * @email dujianghui537885@163.com
 */
@Data
public class TaskStreamerUndertakeParam {


    @ApiModelProperty("承接审核人id(品牌商)【前端不传】")
    private Long auditorOwnerId;

    @ApiModelProperty("主播的用户id【前端不传】")
    private Long streamerId;

    @ApiModelProperty("播主的用户名【前端不传】")
    private String streamerName;

    @ApiModelProperty("任务id")
    private Long taskId;

    @ApiModelProperty("播主佣金比例")
    private BigDecimal commissionPercent;

    @ApiModelProperty("播主坑位费金额")
    private BigDecimal fee;

    @ApiModelProperty("播主运营信息")
    private String operateInfo;

    @ApiModelProperty("备注")
    private String remark;
}

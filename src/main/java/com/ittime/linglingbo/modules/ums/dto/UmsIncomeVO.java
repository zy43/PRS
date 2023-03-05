package com.ittime.linglingbo.modules.ums.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: dzy
 * @date: 2022/11/22 15:36
 * @email: 3323939959@qq.com
 */
@Data
public class UmsIncomeVO {

    @ApiModelProperty(value = "品牌商名称", required = true)
    private String ownerName;

    @ApiModelProperty(value = "所属公司名称")
    private String companyName;

    @ApiModelProperty(value = "任务名称")
    private String taskName;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "播主名称")
    private String hostName;

    @ApiModelProperty(value = "佣金比例")
    private BigDecimal commissionPercent;

    @ApiModelProperty(value = "结算金额")
    private BigDecimal settleMoney;

    @ApiModelProperty(value = "状态")
    private Integer taskDetailStatus;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}

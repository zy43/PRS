package com.ittime.linglingbo.modules.task.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Josh-ZJUT
 * @date 2022/10/20 12:15
 * @email dujianghui537885@163.com
 */
@Data
public class TaskListOwnerVo {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("所属企业名称")
    private String companyName;

    @ApiModelProperty("任务名称")
    private String taskName;

    @ApiModelProperty("合作模式： 1: 纯佣金模式 2: 佣金加坑位费")
    private Integer cooperationModel;

    @ApiModelProperty("佣金比例")
    private BigDecimal commissionPercent;

    @ApiModelProperty("预算金额")
    private BigDecimal budget;

//    @ApiModelProperty("任务描述")
//    private String taskDesc;

//    @ApiModelProperty("保证金额度")
//    private BigDecimal earnestMoney;

    @ApiModelProperty("任务状态 1: 发布中 2: 待承接 3:发布失败4: 履约中 5: 已完成 ")
    private Integer taskStatus;

    @ApiModelProperty("创建时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("关联商品数")
    private Long relatedGoodsCount;

    @ApiModelProperty("播主的用户名")
    private String streamerName;
}

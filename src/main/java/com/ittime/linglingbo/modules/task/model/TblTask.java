package com.ittime.linglingbo.modules.task.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 任务表
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_task")
@ApiModel(value = "TblTask对象", description = "任务表")
public class TblTask extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("品牌商id")
    private Long ownerId;

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

    @ApiModelProperty("任务状态 1: 发布中 2: 待承接 3:发布失败4: 履约中 5: 已完成 ")
    private Integer taskStatus;

    @ApiModelProperty("审核人id(管理员)")
    private Long auditorAdminId;


}

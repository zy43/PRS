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
 * 任务承接结算表
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_task_streamer")
@ApiModel(value = "TblTaskStreamer对象", description = "任务承接结算表")
public class TblTaskStreamer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("任务id，对应tbl_task的id属性")
    private Long taskId;

    @ApiModelProperty("承接审核人id(品牌商)")
    private Long auditorOwnerId;

    @ApiModelProperty("主播的用户id")
    private Long streamerId;

    @ApiModelProperty("播主的用户名")
    private String streamerName;

    @ApiModelProperty("播主佣金比例")
    private BigDecimal commissionPercent;

    @ApiModelProperty("播主坑位费金额")
    private BigDecimal fee;

    @ApiModelProperty("播主运营信息")
    private String operateInfo;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("结算金额")
    private BigDecimal settleMoney;

    @ApiModelProperty("结算备注")
    private String settleRemark;

    @ApiModelProperty("播主完成量")
    private Integer completeNum;

    @ApiModelProperty("平台佣金金额")
    private BigDecimal platformCommission;

    @ApiModelProperty("任务详细状态：1.待承接 2.承接审核中 3.承接审核失败 4.履约中 5. 结算审核中 6. 结算审核失败 7. 已完成")
    private Integer taskDetailStatus;


}

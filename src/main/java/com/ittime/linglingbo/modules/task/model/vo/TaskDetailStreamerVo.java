package com.ittime.linglingbo.modules.task.model.vo;

import com.ittime.linglingbo.modules.task.model.TblTaskGoods;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @author Josh-ZJUT
 * @date 2022/10/20 21:00
 * @email dujianghui537885@163.com
 */
@Data
public class TaskDetailStreamerVo {
    @ApiModelProperty("选中商品列表")
    List<TblTaskGoods> taskGoodsList;

    //    @ApiModelProperty("品牌商id")
//    private Long ownerId;
    @ApiModelProperty("选中品牌列表")
    String brandSet;
    @ApiModelProperty("选中商品分类列表")
    String goodsCategorySet;
    @ApiModelProperty("主键")
    private Long id;
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

//    @ApiModelProperty("任务状态 1: 发布中 2: 待承接 3:发布失败4: 履约中 5: 已完成 ")
//    private Integer taskStatus;
//
//    @ApiModelProperty("审核人id(管理员)")
//    private Long auditorAdminId;



}

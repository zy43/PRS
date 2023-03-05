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
 * 任务商品表
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_task_goods")
@ApiModel(value = "TblTaskGoods对象", description = "任务商品表")
public class TblTaskGoods extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

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

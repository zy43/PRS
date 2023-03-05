package com.ittime.linglingbo.modules.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_goods_daylog")
@ApiModel(value = "TblGoodsDaylog对象", description = "")
public class TblGoodsDaylog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("日期")
    private Date logDate;

    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("商品日浏览量增量")
    private Long increaseDayPlayback;

    @ApiModelProperty("日销量增量")
    private Long increaseDaySales;

    @ApiModelProperty("每日增长关联视频数")
    private Long increaseDayRevideo;

    @ApiModelProperty("每日增长关联博主数")
    private Long increaseDayRelabro;


}

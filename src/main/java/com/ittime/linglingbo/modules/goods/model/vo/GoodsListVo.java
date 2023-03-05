package com.ittime.linglingbo.modules.goods.model.vo;

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
 * @author zhl129
 * @date 2022/10/25 20:28
 * @email 1293384775@qq.com
 */
@Data
public class GoodsListVo {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("关联任务数量")
    private Long relatedTaskCount;

    @ApiModelProperty("关联主播数量")
    private Long relatedStreamerCount;

    @ApiModelProperty("商品数量")
    private Integer goodsNum;

    @ApiModelProperty("商品规格")
    private String goodsSpec;

    @ApiModelProperty("商品售价")
    private BigDecimal goodsPrice;

    @ApiModelProperty("是否上架 1: 已上架 2: 已下架")
    private Integer isShelf;

    @ApiModelProperty("创建时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}

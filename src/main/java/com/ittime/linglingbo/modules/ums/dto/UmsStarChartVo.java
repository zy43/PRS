package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhl129
 * @date 2022/12/28 16:28
 * @email 1293384775@qq.com
 */
@Data
public class UmsStarChartVo {

    @ApiModelProperty("主播昵称")
    private String streamerName;

    @ApiModelProperty("主播分类")
    private String industry;

    @ApiModelProperty("粉丝数")
    private Long totalFans;

    @ApiModelProperty("星图指数")
    private BigDecimal starIndex;
}

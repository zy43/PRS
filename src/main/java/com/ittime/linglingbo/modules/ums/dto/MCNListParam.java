package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

/**
 * @author zhl129
 * @date 2022/12/30 10:14
 * @email 1293384775@qq.com
 */
@Data
public class MCNListParam {

    @ApiModelProperty("粉丝数量下限")
    private Long fansBottom;

    @ApiModelProperty("粉丝数量上限")
    private Long fansTop;

    @ApiModelProperty("签约达人下限")
    private Integer signBottom;

    @ApiModelProperty("签约达人上限")
    private Integer signTop;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

}

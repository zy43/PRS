package com.ittime.PRS.modules.policy.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhl129
 * @date 2023/4/11 18:45
 * @email 1293384775@qq.com
 */

@Data
public class CountVo {

    @ApiModelProperty("总政策个数")
    private Integer policyCount;

    @ApiModelProperty("国家级政策个数")
    private Integer countryGradeCount;

    @ApiModelProperty("省政策个数")
    private Integer provinceGradeCount;

    @ApiModelProperty("政策类型个数")
    private Integer policyTypeCount;

}

package com.ittime.PRS.modules.policy.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhl129
 * @date 2023/4/14 15:14
 * @email 1293384775@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicySimilarity {

    @ApiModelProperty("源政策id")
    private Long policy1;

    @ApiModelProperty("目标政策id")
    private Long policy2;

    @ApiModelProperty("type")
    private String type;

    @ApiModelProperty("similarity")
    private Float similarity;

}

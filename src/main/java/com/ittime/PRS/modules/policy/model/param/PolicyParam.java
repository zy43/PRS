package com.ittime.PRS.modules.policy.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2023/03/10
 **/
@Data
public class PolicyParam {

    @ApiModelProperty("政策类型")
    private String policyType;
}

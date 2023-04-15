package com.ittime.PRS.modules.collection.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2023/04/15
 **/
@Data
public class CollectParam {
    @ApiModelProperty("政策id")
    private Long policyId;

    @ApiModelProperty("是否收藏")
    private Integer flag;
}

package com.ittime.PRS.modules.policy.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2023/03/11
 **/
@Data
public class ProvinceListVo {

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("政策数量")
    private Integer sum;
}

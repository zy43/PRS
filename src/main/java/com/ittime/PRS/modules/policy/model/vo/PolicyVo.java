package com.ittime.PRS.modules.policy.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2023/03/10
 **/
@Data
public class PolicyVo {
    @ApiModelProperty("政策ID")
    private Long policyId;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("标题")
    private String policyTitle;

    @ApiModelProperty("信息来源")
    private String policySource;

    @ApiModelProperty("更新时间")
    private LocalDate updateDate;
}

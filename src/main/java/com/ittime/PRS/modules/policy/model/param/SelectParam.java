package com.ittime.PRS.modules.policy.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2023/03/11
 **/
@Data
public class SelectParam {

    @ApiModelProperty("政策类型")
    private String policyType;

    @ApiModelProperty("等级")
    private String grade;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("信息来源")
    private String source;

    @ApiModelProperty("关键词")
    private String keyWord;
}

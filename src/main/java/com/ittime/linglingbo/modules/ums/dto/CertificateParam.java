package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CertificateParam {

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("审核对象身份（1代表品牌商 2代表主播）")
    private int identity;

    @ApiModelProperty("审核状态(0代表不通过 1代表通过）")
    private int status;

}

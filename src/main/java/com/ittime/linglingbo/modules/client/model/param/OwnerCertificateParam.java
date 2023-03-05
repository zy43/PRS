package com.ittime.linglingbo.modules.client.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OwnerCertificateParam {

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("身份证号")
    private String idCard;

//    @ApiModelProperty("图片")
//    private String pic;

}

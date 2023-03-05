package com.ittime.linglingbo.modules.client.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;



@Data
public class OwnerListVO {

    @ApiModelProperty("序号")
    private Long id;

    @ApiModelProperty("品牌商/政府机构名称")
    private String ownerName;

    @ApiModelProperty("所属企业名称")
    private String companyName;

    @ApiModelProperty("认证状态（审核中、已认证、未认证）")
    private String certification;

    @ApiModelProperty("创建时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

}

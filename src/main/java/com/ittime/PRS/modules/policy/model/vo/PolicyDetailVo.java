package com.ittime.PRS.modules.policy.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2023/04/04
 **/
@Data
public class PolicyDetailVo {
    @ApiModelProperty("政策ID")
    private Long policyId;

    @ApiModelProperty("政策标题")
    private String policyTitle;

    @ApiModelProperty("级别")
    private String policyGrade;

    @ApiModelProperty("发布机构-id")
    private String pubAgencyId;

    @ApiModelProperty("发布机构")
    private String pubAgency;

    @ApiModelProperty("发布机构标准名称（全称）")
    private String pubAgencyFullname;

    @ApiModelProperty("发文字号")
    private String pubNumber;

    @ApiModelProperty("发布时间")
    private LocalDate pubTime;

    @ApiModelProperty("政策种类")
    private String policyType;

    @ApiModelProperty("政策正文")
    private String policyBody;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("政策来源")
    private String policySource;

    @ApiModelProperty("更新时间")
    private LocalDate updateDate;
}

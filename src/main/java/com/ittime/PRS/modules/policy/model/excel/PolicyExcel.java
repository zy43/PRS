package com.ittime.PRS.modules.policy.model.excel;

import cn.hutool.core.date.DateTime;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhl129
 * @date 2023/3/9 15:59
 * @email 1293384775@qq.com
 */
@Data
public class PolicyExcel {

    @ExcelProperty("POLICY_ID")
    private Long policyId;

    @ExcelProperty("POLICY_TITLE")
    private String policyTitle;

    @ExcelProperty("POLICY_GRADE")
    private String policyGrade;

    @ExcelProperty("PUB_AGENCY_ID")
    private String pubAgencyId;

    @ExcelProperty("PUB_AGENCY")
    private String pubAgency;

    @ExcelProperty("PUB_AGENCY_FULLNAME")
    private String pubAgencyFullname;

    @ExcelProperty("PUB_NUMBER")
    private String pubNumber;

    @ExcelProperty("PUB_TIME")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private LocalDate PubTime;

    @ExcelProperty("POLICY_TYPE")
    private String policyType;

    @ExcelProperty("POLICY_BODY")
    private String policyBody;

    @ExcelProperty("PROVINCE")
    private String province;

    @ExcelProperty("CITY")
    private String city;

    @ExcelProperty("POLICY_SOURCE")
    private String policySource;

    @ExcelProperty("UPDATE_DATE")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private LocalDate updateDate;



}

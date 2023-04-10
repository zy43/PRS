package com.ittime.PRS.modules.collection.model.vo;

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
 * @author zhl129
 * @date 2023/4/4 19:12
 * @email 1293384775@qq.com
 */
@Data
public class CollectionVo {

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
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate updateDate;

    @ApiModelProperty("用户id")
    private Long userId;
}

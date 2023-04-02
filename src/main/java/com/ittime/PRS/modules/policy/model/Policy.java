package com.ittime.PRS.modules.policy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ittime.PRS.common.entity.BaseEntity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhl
 * @since 2023-03-09
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("policy")
@ApiModel(value = "Policy对象", description = "")
public class Policy extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private LocalDate updateDate;

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", policyTitle='" + policyTitle + '\'' +
                ", policyGrade='" + policyGrade + '\'' +
                ", pubAgencyId='" + pubAgencyId + '\'' +
                ", pubAgency='" + pubAgency + '\'' +
                ", pubAgencyFullname='" + pubAgencyFullname + '\'' +
                ", pubNumber='" + pubNumber + '\'' +
                ", pubTime=" + pubTime +
                ", policyType='" + policyType + '\'' +
                ", policyBody='" + policyBody + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", policySource='" + policySource + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}

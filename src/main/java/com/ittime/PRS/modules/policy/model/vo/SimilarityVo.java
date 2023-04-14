package com.ittime.PRS.modules.policy.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author zhl129
 * @date 2023/4/14 14:09
 * @email 1293384775@qq.com
 */

@Data
public class SimilarityVo {

    @ApiModelProperty("政策ID")
    private Long policyId;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("标题")
    private String policyTitle;

    @ApiModelProperty("发布机构标准名称（全称）")
    private String pubAgencyFullname;

    @ApiModelProperty("更新时间")
    private LocalDate updateDate;

    @ApiModelProperty("级别")
    private String policyGrade;

    @ApiModelProperty("发文字号")
    private String pubNumber;


}

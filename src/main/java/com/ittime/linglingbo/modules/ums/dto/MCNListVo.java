package com.ittime.linglingbo.modules.ums.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhl129
 * @date 2022/12/30 10:05
 * @email 1293384775@qq.com
 */
@Data
public class MCNListVo {

    @ApiModelProperty("mcnId")
    @JsonProperty("mcnId")
    private Long streamerId;

    @ApiModelProperty("mcn机构名称")
    private String mcnName;

    @ApiModelProperty("mcn所属企业")
    private String company;

    @ApiModelProperty("签约达人数")
    private Integer signNum;

    @ApiModelProperty("头像")
    private String imageUrl;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("粉丝量级")
    private Long totalFans;
}

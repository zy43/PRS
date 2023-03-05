package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhl129
 * @date 2022/12/28 17:56
 * @email 1293384775@qq.com
 */
@Data
public class StreamerCompareSearchVo {

    @ApiModelProperty("主播ID")
    private Long streamerId;

    @ApiModelProperty("播主")
    private String streamerName;

    @ApiModelProperty("头像")
    private String imageUrl;

    @ApiModelProperty("博主简介")
    private String introduction;
}

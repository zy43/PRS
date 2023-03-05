package com.ittime.linglingbo.modules.monitor.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhl129
 * @date 2022/12/30 8:39
 * @email 1293384775@qq.com
 */
@Data
public class AuthorizeVo {

    @ApiModelProperty("播主")
    private String streamerName;

    @ApiModelProperty("播主id")
    private Long streamerId;

    @ApiModelProperty("头像")
    private String imageUrl;

    @ApiModelProperty("授权时间")
    private String authorizeTime;

    @ApiModelProperty("授权信息")
    private String authorize;
}

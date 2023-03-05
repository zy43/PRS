package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhl129
 * @date 2022/12/30 11:25
 * @email 1293384775@qq.com
 */
@Data
public class MCNSignVo {

    @ApiModelProperty("播主")
    private String streamerName;

    @ApiModelProperty("头像")
    private String imageUrl;

    @ApiModelProperty("分类")
    private String industry;

    @ApiModelProperty("总粉丝数")
    private Long totalFans;
}

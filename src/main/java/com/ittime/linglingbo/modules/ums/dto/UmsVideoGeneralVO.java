package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: dzy
 * @date: 2022/12/19 20:20
 * @email: 3323939959@qq.com
 */
@Data
public class UmsVideoGeneralVO {

    @ApiModelProperty("作品数")
    private Long videoNum;

    @ApiModelProperty("平均点赞")
    private Long avgLikes;

    @ApiModelProperty("平均评论")
    private Long avgComments;

    @ApiModelProperty("平均分享")
    private Long avgShares;

}

package com.ittime.linglingbo.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhl129
 * @date 2022/12/30 11:06
 * @email 1293384775@qq.com
 */
@Data
public class MCNInfoVo {

    @ApiModelProperty("mcn机构名称")
    private String mcnName;

    @ApiModelProperty("mcn所属企业")
    private String company;

    @ApiModelProperty("头像")
    private String imageUrl;

    @ApiModelProperty("简介")
    private String introduction;

    @ApiModelProperty("官网网址")
    private String website;

    @ApiModelProperty("联系人")
    private String contact;

    @ApiModelProperty("电话")
    private String tel;

    @ApiModelProperty("微信")
    private String wechat;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("签约达人数")
    private Integer signNum;

    @ApiModelProperty("粉丝量级")
    private Long totalFans;
}

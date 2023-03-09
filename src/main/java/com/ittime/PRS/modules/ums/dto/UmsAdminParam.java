package com.ittime.PRS.modules.ums.dto;

import com.ittime.PRS.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 *
 * @author 33293
 */
@Getter
@Setter
public class UmsAdminParam extends BaseEntity {

    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    //    @ApiModelProperty(value = "用户头像")
    //    private String icon;

    @ApiModelProperty(value = "手机号")
    private String tel;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "所属企业id")
    private String companyId;

    @ApiModelProperty(value = "角色（streamer/owner/root）")
    private String role;

}

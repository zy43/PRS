package com.ittime.PRS.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum RoleEnum {

    // 为防止魔法值

    ROOT(5, "超级管理员"),
    USER(6, "用户");

    @EnumValue
    private final long roleId;
    private final String roleName;

    RoleEnum(long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getValue() {
        return roleId;
    }

    public String getName() {
        return roleName;
    }
}

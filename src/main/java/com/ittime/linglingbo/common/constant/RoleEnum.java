package com.ittime.linglingbo.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author Josh-ZJUT
 * @date 2022/10/9 21:32
 * @email dujianghui537885@163.com
 */
public enum RoleEnum {

    // 为防止魔法值

    ROOT(5, "超级管理员"),
    OPERATOR(8, "运营人员"),
    STREAMER(9, "播主"),
    OWNER(10, "品牌方");

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

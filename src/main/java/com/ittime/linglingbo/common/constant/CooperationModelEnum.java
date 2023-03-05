package com.ittime.linglingbo.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author zhl129
 * @date 2022/10/9 22:12
 * @email 1293384775@qq.com
 */
public enum CooperationModelEnum implements BaseEnum {
    //合作模式 1. 纯佣金模式 2. 佣金加坑位费
    PURE(1, "纯佣金模式"),
    FEE(2, "佣金加坑位费");


    @EnumValue
    private final int cooperationStatus;
    private final String desc;

    CooperationModelEnum(int cooperationStatus, String desc) {
        this.cooperationStatus = cooperationStatus;
        this.desc = desc;
    }


    @Override
    public Integer getValue() {
        return cooperationStatus;
    }

    @Override
    public String getName() {
        return desc;
    }
}

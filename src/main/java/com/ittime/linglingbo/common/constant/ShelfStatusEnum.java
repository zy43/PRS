package com.ittime.linglingbo.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author Josh-ZJUT
 * @date 2022/10/9 21:32
 * @email dujianghui537885@163.com
 */
public enum ShelfStatusEnum implements BaseEnum {

    //是否上架 1: 已上架 2: 已下架

    ON(1, "已上架"),
    OFF(2, "已下架");

    @EnumValue
    private final int shelfStatus;
    private final String desc;

    ShelfStatusEnum(int shelfStatus, String desc) {
        this.shelfStatus = shelfStatus;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return shelfStatus;
    }

    @Override
    public String getName() {
        return desc;
    }
}

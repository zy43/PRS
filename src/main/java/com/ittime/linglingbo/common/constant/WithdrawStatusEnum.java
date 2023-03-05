package com.ittime.linglingbo.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author Josh-ZJUT
 * @date 2022/10/9 21:32
 * @email dujianghui537885@163.com
 */
public enum WithdrawStatusEnum implements BaseEnum {

    //状态 1: 审核中2: 已完成 3: 提现失败

    AUDIT(1, "审核中"),
    DONE(2, "已完成"),
    FAIL(3, "提现失败");

    @EnumValue
    private final int withdrawStatus;
    private final String desc;

    WithdrawStatusEnum(int withdrawStatus, String desc) {
        this.withdrawStatus = withdrawStatus;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return withdrawStatus;
    }

    @Override
    public String getName() {
        return desc;
    }
}

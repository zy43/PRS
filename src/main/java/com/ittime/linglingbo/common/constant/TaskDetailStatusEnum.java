package com.ittime.linglingbo.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author Josh-ZJUT
 * @date 2022/10/9 21:32
 * @email dujianghui537885@163.com
 */
public enum TaskDetailStatusEnum implements BaseEnum {

    //任务状态：1.待承接 2.承接审核中 3.承接审核失败 4.履约中 5. 结算审核中 6. 结算审核失败 7. 已完成

    UNDERTAKE_WAIT(1, "待承接"),
    UNDERTAKE_AUDIT(2, "承接审核中"),
    UNDERTAKE_FAIL(3, "承接审核失败"),
    DOING(4, "履约中"),
    SETTLE_AUDIT(5, "结算审核中"),
    SETTLE_FAIL(6, "结算审核失败"),
    DONE(7, "已完成");

    @EnumValue
    private final int taskStatus;
    private final String desc;

    TaskDetailStatusEnum(int taskStatus, String desc) {
        this.taskStatus = taskStatus;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return taskStatus;
    }

    @Override
    public String getName() {
        return desc;
    }
}

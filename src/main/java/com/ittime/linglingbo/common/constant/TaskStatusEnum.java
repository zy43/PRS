package com.ittime.linglingbo.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author zhl129
 * @date 2022/10/9 22:08
 * @email 1293384775@qq.com
 */

public enum TaskStatusEnum implements BaseEnum {
    //任务状态： 1. 发布中 2. 待承接 3. 发布失败 4. 履约中 5. 已完成
    PUBLISH_WAIT(1, "发布中"),
    UNDERTAKE_WAIT(2, "待承接"),
    PUBLISH_FAIL(3, "发布失败"),
    DOING(4, "履约中"),
    DONE(5, "已完成");


    @EnumValue
    private final int taskStatus;
    private final String desc;

    TaskStatusEnum(int taskStatus, String desc) {
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

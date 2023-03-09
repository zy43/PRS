package com.ittime.PRS.common.constant;

public final class EnumUtils {

    /**
     * 判断枚举值是否存在于指定枚举数组中
     *
     * @param enums 枚举数组
     * @param value 枚举值
     * @return
     */
    public static boolean isExist(BaseEnum[] enums, Integer value) {
        if (value == null) {
            return false;
        }
        for (BaseEnum e : enums) {
            if (value.equals(e.getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据枚举值获取其对应的名字
     *
     * @param enums
     * @param value
     * @return
     */
    public static String getNameByValue(BaseEnum[] enums, Integer value) {
        if (value == null) {
            return "";
        }
        for (BaseEnum e : enums) {
            if (value.equals(e.getValue())) {
                return e.getName();
            }
        }
        return "";
    }
}
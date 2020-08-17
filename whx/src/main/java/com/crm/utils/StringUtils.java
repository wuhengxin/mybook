package com.crm.utils;

public class StringUtils {

    /**
     * 方法功能描述 判断非空
     */
    public static boolean hasLength(String str) {
        return str != null && !"".equals(str.trim());
    }
}

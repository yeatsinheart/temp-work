package com.max.core.utils;

/**
 * Created by ken on 2018/7/25.
 * 平台游戏订单前缀定义
 */
public enum OrderPrefix {
    ZZ("ZZ"),
    CZ("CZ"),
    YJ("YJ");

    private String code;

    OrderPrefix(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

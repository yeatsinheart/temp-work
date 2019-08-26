package com.max.core.utils;

public enum ShareWalletCode {
    BET(0, "下注"),
    RESULT(1, "成绩"),
    REFUND_BET(2, "退款"),
    BET_MULTIPLE(3, "同时下注多次")
    ;

    private int code;
    private String description;

    ShareWalletCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

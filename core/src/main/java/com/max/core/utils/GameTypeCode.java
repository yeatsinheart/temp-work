package com.max.core.utils;

public enum GameTypeCode {
    LOTT(0, "彩票"),
    /* 想用自己想名字
    XXX(1, "真人"),
    XXX(2, "体育"),
    XXX(3, "老虎机"),
    XXX(4, "捕鱼"),
    XXX(5, "电竞"),
    XXX(6, "棋牌")
    */
    ;

    private int code;
    private String description;

    GameTypeCode(int code, String description) {
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

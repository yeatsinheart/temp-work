package com.max.core.utils;

/**
 * Created by ken on 2018/7/25.
 * 平台游戏订单前缀定义
 */
public enum GameOrderPrefix {
    GAME_AG(1, "AG"),
    GAME_EBET(2, "EBET"),
    GAME_BBIN(3, "BBIN"),
    GAME_PT(4, "PT"),
    GAME_MG(5, "MG"),
    GAME_GG(6, "GG"),
    GAME_188(7, "XJ"),
    GAME_ZZ(8, "ZZ"),
    GAME_CZ(9, "CZ"),
    GAME_YJ(10, "YJ"),
    GAME_KY(9, "KY"),
    GAME_LB(8, "LB"),
    GAME_HLQP(10, "QP"),
    GAME_GMQP(11, "GM"),
    GAME_188_LIVE(13, "XJLV"),
    GAME_IM_PP(17, "PP"),
    GAME_IM_ESPORT(18, "ES"),
    GAME_IM_SW(19, "SW"),
    GAME_5GM_LTY(12, "LTY"),
    GAME_MW(23, "MW"),
    GAME_XYQP(24, "XYQP"),
    GAME_VIRTUAL_SPORT(16, "XNTY");

    private int channel;
    private String code;

    GameOrderPrefix(int channel, String code) {
        this.channel = channel;
        this.code = code;
    }

    public int getChannel() {
        return channel;
    }

    public String getCode() {
        return code;
    }

}

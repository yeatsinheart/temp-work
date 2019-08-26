package com.max.core.utils;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ken on 2018/7/25.
 */
public enum GameChannelCode {

    GAME_AG(1, "AG游戏",true),
    GAME_EBET(2, "EBET游戏",true),
    GAME_BBIN(3, "BBIN游戏",false),
    GAME_PT(4, "PT游戏",true),
    GAME_MG(5, "MG游戏",false),
    GAME_GG(6, "GG游戏",false),
    GAME_188(7, "贝博体育",true),
    GAME_LB(8, "LB彩票",true),
    GAME_KY(9, "开元棋牌",false),
    GAME_HLQP(10, "欢乐棋牌",true),
    GAME_GMQP(11, "GM棋牌",true),
    GAME_188_LIVE(13, "小金真人",true),
    GAME_5GM_LTY(12, "5GM彩票",true),
    GAME_VIRTUAL_SPORT(16, "虚拟体育",false),
    GAME_IM_PP(17, "PP电子",true),
    GAME_IM_ESPORT(18, "IM电竞",true),
    GAME_IM_SW(19, "双赢彩票",true),
    GAME_VR(20, "VR竞速娱乐",false),
    GAME_MW(23, "MW游戏",true),
    GAME_XYQP(24, "幸运棋牌",false),
    ;

    public static final int CHANNEL_AG = 1;
    public static final int CHANNEL_EBET = 2;
    public static final int CHANNEL_BBIN = 3;
    public static final int CHANNEL_PT = 4;
    public static final int CHANNEL_MG = 5;
    public static final int CHANNEL_GG = 6;
    public static final int CHANNEL_188 = 7;
    public static final int CHANNEL_LB = 8;
    public static final int CHANNEL_KY = 9;
    public static final int CHANNEL_HLQP = 10;
    public static final int CHANNEL_GMQP = 11;
    public static final int CHANNEL_5GM_LTY = 12;
    public static final int CHANNEL_188_LIVE = 13;
    public static final int CHANNEL_VR = 20;
    public static final int CHANNEL_SELF = 0;
    public static final int CHANNEL_XYQP = 24;

    public static final int CHANNEL_MW_FISH = 15;
    public static final int CHANNEL_VIRTUAL_SPORT = 16;
    public static final int CHANNEL_IM_PP = 17;
    public static final int CHANNEL_IM_ESPORT = 18;
    public static final int CHANNEL_IM_SW = 19;
    public static final int CHANNEL_GAME_MW = 23;

    public static final int AG_REAL = 1;
    public static final int AG_FISH = 2;
    public static final int XJ_188 = 3;
    public static final int PT = 4;
    public static final int EBET_REAL = 5;
    public static final int KY_QP = 6;
    public static final int LB_CP = 8;
    public static final int VR_CP = 20;
    public static final int HLQP = 10;
    public static final int GMQP = 11;
    public static final int FIVE_GM_LTY = 12;
    public static final int XJ_188_LIVE = 13;
    public static final int XJ_VIRTUAL_SPORT = 16;

    public static final int max = 22; // 游戏ID的最大值
    public static final int min = 0; // 游戏ID的最小值

    private int channel;
    private String code;
    private boolean isOpen;

    GameChannelCode(int channel, String code,boolean isOpen) {
        this.channel = channel;
        this.code = code;
        this.isOpen = isOpen;
    }

    public int getChannel() {
        return channel;
    }

    public String getCode() {
        return code;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public static String convertChannelName(Integer channel) {
        if (channel == 0) {
            return "中心";
        } else if (channel == 513) {
            return "EBET";
        } else if (channel == 514) {
            return "贝博体育";
        } else if (channel == 515) {
            return "PT";
        } else if (channel == GameChannelCode.GAME_AG.getChannel()) {
            return "AG";
        } else if (channel == GameChannelCode.GAME_EBET.getChannel()) {
            return "EBET";
        } else if (channel == GameChannelCode.GAME_BBIN.getChannel()) {
            return "BBIN";
        } else if (channel == GameChannelCode.GAME_PT.getChannel()) {
            return "PT";
        } else if (channel == GameChannelCode.GAME_MG.getChannel()) {
            return "MG";
        } else if (channel == GameChannelCode.GAME_GG.getChannel()) {
            return "GG";
        } else if (channel == GameChannelCode.GAME_188.getChannel()) {
            return "贝博体育";
        } else if (channel == GameChannelCode.GAME_KY.getChannel()) {
            return "开元棋牌";
        } else if (channel == GameChannelCode.GAME_LB.getChannel()) {
            return "LB彩票";
        } else if (channel == GameChannelCode.GAME_HLQP.getChannel()) {
            return "欢乐棋牌";
        } else if (channel == GameChannelCode.GAME_GMQP.getChannel()) {
            return "GM棋牌";
        } else if (channel == GameChannelCode.GAME_5GM_LTY.getChannel()) {
            return "5GM彩票";
        } else if (channel == GameChannelCode.GAME_188_LIVE.getChannel()) {
            return "小金真人";
        }else if (channel == GameChannelCode.GAME_VIRTUAL_SPORT.getChannel()) {
            return "虚拟体育";
        } else if (channel == GameChannelCode.GAME_IM_PP.getChannel()) {
            return "PP电子";
        }else if (channel == GameChannelCode.GAME_IM_ESPORT.getChannel()) {
            return "IM电竞";
        }else if (channel == GameChannelCode.GAME_IM_SW.getChannel()) {
            return "双赢彩票";
        }else if (channel == GameChannelCode.GAME_VR.getChannel()) {
            return "VR竞速娱乐";
        }else if (channel == GameChannelCode.GAME_MW.getChannel()) {
            return "MW游戏";
        }else if (channel == GameChannelCode.GAME_XYQP.getChannel()) {
            return "幸运棋牌";
        }
        return "";
    }

    public static List<GameChannelCode> getGameChannelCodeList(){
        return new ArrayList<GameChannelCode>(Arrays.asList(GameChannelCode.values()));
    }

    public static List<Integer> getCheckBalanceGameChannel() {
        return Lists.newArrayList(
                GameChannelCode.CHANNEL_PT,
                GameChannelCode.CHANNEL_AG,
                GameChannelCode.CHANNEL_IM_SW,
                GameChannelCode.CHANNEL_XYQP,
                GameChannelCode.CHANNEL_IM_PP,
                GameChannelCode.FIVE_GM_LTY,
                GameChannelCode.CHANNEL_IM_ESPORT
        );
    }

}

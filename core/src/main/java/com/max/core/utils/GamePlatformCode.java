package com.max.core.utils;

public enum GamePlatformCode {

    //原5种根据gameid查询的返水任务（根据gameid聚合）
    GAME_AG_REAL(1001 , "AG真人"),
    GAME_AG_FISH(1004 , "AG捕鱼"),
    GAME_EBET_REAL(2001, "EBET真人"),
    GAME_XJ_188(7002 , "贝博体育"),
    GAME_LB_CP(8000 , "LB彩票"),
    //PT电子，原独立返水任务（根据gameid聚合）
    GAME_PT(4003  , "PT电子"),
    //新的（根据gamePlatformId聚合返水）
    GAME_AG_TIGER(1003, "AG电子"),
    GAME_EBET_TIGER(2003, "EBET游戏"),
    GAME_188_LIVE(13001, "小金真人"),
    GAME_IM_ESPORT(18005, "IM电竞"),
    GAME_XYQP(	24006, "幸运棋牌"),
    GAME_IM_SW(19000, "双赢彩票"),
    GAME_IM_PP(17003, "PP电子"),
    GAME_MW_TIGER(23003, "MW老虎机"),
    GAME_MW_FISH(23004, "MW捕鱼"),
    GAME_5GM(12000, "5GM彩票")
    ;

    private Integer gamePlatformCode;
    private String desc;

    GamePlatformCode(int code, String desc) {
        this.gamePlatformCode = code;
        this.desc = desc;
    }

    public int getGamePlatformCode() {
        return gamePlatformCode;
    }

    public String getDesc() {
        return desc;
    }

    /**
     *  根据 gamePlatformCode 获取gameName
     * @param gamePlatformCode
     * @return
     */
    public static String convertCodeToDesc(Integer gamePlatformCode) {
        String gameName = "";
        for (GamePlatformCode game : GamePlatformCode.values()) {
            if (game.getGamePlatformCode() == gamePlatformCode) {
                gameName = game.getDesc();
                break;
            }
        }
        return gameName;
    }

}

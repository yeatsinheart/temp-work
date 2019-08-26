package com.max.core.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GameDetail {
    private static Map<Integer, String> ebetGameTypeMap = new HashMap<>();


    private static Map<Integer, String> ebetNiuNiuResultMap = new HashMap<>();

    private static Map<String, String> ebetTigerGameNameMap = new HashMap<>();
    static {
        ebetTigerGameNameMap.put("1","夜戏貂蝉");
        ebetTigerGameNameMap.put("2","宝石侠");
        ebetTigerGameNameMap.put("3","横财来啦");
        ebetTigerGameNameMap.put("4","国王的召唤");
        ebetTigerGameNameMap.put("6","美杜莎 2");
        ebetTigerGameNameMap.put("7","美杜莎 1");
        ebetTigerGameNameMap.put("8","豌豆精灵");
        ebetTigerGameNameMap.put("10","小丑翻翻乐");
        ebetTigerGameNameMap.put("11","美式二十一点");
        ebetTigerGameNameMap.put("12","欧式二十一点");
        ebetTigerGameNameMap.put("17","巫师之书");
        ebetTigerGameNameMap.put("18","逆袭的小红帽");
        ebetTigerGameNameMap.put("19","蒸汽朋克");
        ebetTigerGameNameMap.put("24","旺旺旺");
        ebetTigerGameNameMap.put("25","抓抓乐");
        ebetTigerGameNameMap.put("26","摇钱树");
        ebetTigerGameNameMap.put("27","网红餐厅");
        ebetTigerGameNameMap.put("28","麻辣火锅");
        ebetTigerGameNameMap.put("29","鱼跃龙门");
        ebetTigerGameNameMap.put("31","至尊百家乐");
        ebetTigerGameNameMap.put("33","嘻哈熊猫");
        ebetTigerGameNameMap.put("34","后羿射日");
        ebetTigerGameNameMap.put("35","万胜狂欢夜");
        ebetTigerGameNameMap.put("36","舞狮进宝");
        ebetTigerGameNameMap.put("37","圣诞欢乐送");
        ebetTigerGameNameMap.put("38","宝石侠-大宝剑");
        ebetTigerGameNameMap.put("39","金猪报财");
        ebetTigerGameNameMap.put("40","水果丛林");
        ebetTigerGameNameMap.put("41","埃及寻宝");
        ebetTigerGameNameMap.put("42","象财神");
        ebetTigerGameNameMap.put("43","三只猴子");
        ebetTigerGameNameMap.put("44","皇上吉祥");
        ebetTigerGameNameMap.put("45","摸金校尉");
    }

    static {
        //游戏类型
        ebetGameTypeMap.put(1, "百家乐");
        ebetGameTypeMap.put(2, "龙虎");
        ebetGameTypeMap.put(3, "骰宝");
        ebetGameTypeMap.put(4, "轮盘");
        ebetGameTypeMap.put(5, "老虎机");
        ebetGameTypeMap.put(8, "牛牛");
        //百家乐结果
        ebetGameTypeMap.put(60, "闲");
        ebetGameTypeMap.put(61, "闲龙宝");
        ebetGameTypeMap.put(62, "闲单");
        ebetGameTypeMap.put(63, "闲双");
        ebetGameTypeMap.put(66, "闲对");
        ebetGameTypeMap.put(68, "和");
        ebetGameTypeMap.put(70, "大");
        ebetGameTypeMap.put(71, "小");
        ebetGameTypeMap.put(80, "庄");
        ebetGameTypeMap.put(81, "庄龙宝");
        ebetGameTypeMap.put(82, "庄单");
        ebetGameTypeMap.put(83, "庄双");
        ebetGameTypeMap.put(86, "幸运六");
        ebetGameTypeMap.put(88, "庄对");
        //龙虎结果
        ebetGameTypeMap.put(10, "龙");
        ebetGameTypeMap.put(11, "虎");
//        ebetGameTypeMap.put(68, "和骰宝");
        ebetGameTypeMap.put(100, "单");
        ebetGameTypeMap.put(101, "双");
        ebetGameTypeMap.put(102, "大");
        ebetGameTypeMap.put(104, "对子 1");
        ebetGameTypeMap.put(105, "对子 2");
        ebetGameTypeMap.put(106, "对子 3");
        ebetGameTypeMap.put(107, "对子 4");
        ebetGameTypeMap.put(108, "对子 5");
        ebetGameTypeMap.put(109, "对子 6");
        ebetGameTypeMap.put(110, "围骰 1");
        ebetGameTypeMap.put(111, "围骰 2");
        ebetGameTypeMap.put(112, "围骰 3");
        ebetGameTypeMap.put(113, "围骰 4");
        ebetGameTypeMap.put(114, "围骰 5");
        ebetGameTypeMap.put(116, "全围");
        ebetGameTypeMap.put(117, "4 点");
        ebetGameTypeMap.put(118, "5 点");
        ebetGameTypeMap.put(119, "6 点");
        ebetGameTypeMap.put(120, "7 点");
        ebetGameTypeMap.put(121, "8 点");
        ebetGameTypeMap.put(125, "9 点");
        ebetGameTypeMap.put(126, "10 点");
        ebetGameTypeMap.put(127, "11 点");
        ebetGameTypeMap.put(128, "12 点");
        ebetGameTypeMap.put(129, "13 点");
        ebetGameTypeMap.put(130, "14 点");
        ebetGameTypeMap.put(131, "15 点");
        ebetGameTypeMap.put(132, "16 点");
        ebetGameTypeMap.put(133, "17 点");
        ebetGameTypeMap.put(134, "单点数");
        ebetGameTypeMap.put(135, "单点数 2");
        ebetGameTypeMap.put(136, "单点数 3");
        ebetGameTypeMap.put(137, "单点数 4");
        ebetGameTypeMap.put(138, "单点数 5");
        ebetGameTypeMap.put(139, "单点数 6");
        ebetGameTypeMap.put(140, "组合 1-2");
        ebetGameTypeMap.put(141, "组合 1-3");
        ebetGameTypeMap.put(142, "组合 1-4");
        ebetGameTypeMap.put(143, "组合 1-5");
        ebetGameTypeMap.put(144, "组合 1-6");
        ebetGameTypeMap.put(145, "组合 2-3");
        ebetGameTypeMap.put(146, "组合 2-4");
        ebetGameTypeMap.put(147, "组合 2-5");
        ebetGameTypeMap.put(148, "组合 2-6");
        ebetGameTypeMap.put(149, "组合 3-4");
        ebetGameTypeMap.put(150, "组合 3-5");
        ebetGameTypeMap.put(151, "组合 3-6");
        ebetGameTypeMap.put(152, "组合 4-5");
        ebetGameTypeMap.put(153, "组合 4-6");
        ebetGameTypeMap.put(154, "组合 5-6");
        ebetGameTypeMap.put(155, "二同号");
        ebetGameTypeMap.put(156, "三不号");
        //轮盘结果
        ebetGameTypeMap.put(200, "直接注");
        ebetGameTypeMap.put(201, "分注");
        ebetGameTypeMap.put(202, "街注");
        ebetGameTypeMap.put(203, "角注");
        ebetGameTypeMap.put(204, "三数");
        ebetGameTypeMap.put(205, "四个号码");
        ebetGameTypeMap.put(206, "线注");
        ebetGameTypeMap.put(207, "列注");
        ebetGameTypeMap.put(208, "打注");
        ebetGameTypeMap.put(209, "红");
        ebetGameTypeMap.put(210, "黑");
        ebetGameTypeMap.put(211, "单");
        ebetGameTypeMap.put(212, "双");
        ebetGameTypeMap.put(213, "大");
        ebetGameTypeMap.put(214, "小");

        ebetGameTypeMap.put(301, "闲1平倍");
        ebetGameTypeMap.put(302, "闲1翻倍");
        ebetGameTypeMap.put(303, "闲2平倍");
        ebetGameTypeMap.put(304, "闲2翻倍");
        ebetGameTypeMap.put(305, "闲3平倍");
        ebetGameTypeMap.put(306, "闲3翻倍");

        ebetNiuNiuResultMap.put(0, "炸弹");
        ebetNiuNiuResultMap.put(1, "五花牛");
        ebetNiuNiuResultMap.put(3, "无牛");
        ebetNiuNiuResultMap.put(20, "牛牛");
        ebetNiuNiuResultMap.put(19, "牛9");
        ebetNiuNiuResultMap.put(18, "牛8");
        ebetNiuNiuResultMap.put(17, "牛7");
        ebetNiuNiuResultMap.put(16, "牛6");
        ebetNiuNiuResultMap.put(15, "牛5");
        ebetNiuNiuResultMap.put(14, "牛4");
        ebetNiuNiuResultMap.put(13, "牛3");
        ebetNiuNiuResultMap.put(12, "牛2");
        ebetNiuNiuResultMap.put(11, "牛1");
    }

    private static Map<String, String> sportNameMap = new HashMap<>();

    static {
        sportNameMap.put("Badminton", "羽毛球");
        sportNameMap.put("Baseball", "棒球");
        sportNameMap.put("Basketball", "篮球");
        sportNameMap.put("Beach Soccer", "沙滩足球");
        sportNameMap.put("Beach Volleyball", "沙滩排球");
        sportNameMap.put("Beauty Pageant", "选美大赛");
        sportNameMap.put("Boxing / Fighting", "拳击/格斗");
        sportNameMap.put("Cricket", "板球");
        sportNameMap.put("Cycling", "自行车");
        sportNameMap.put("Darts", "飞镖");
        sportNameMap.put("E-Sports", "电子竞技");
        sportNameMap.put("Field Hockey", "曲棍球");
        sportNameMap.put("Financial Bets", "金融投注");
        sportNameMap.put("Football", "足球");
        sportNameMap.put("Futsal", "室内足球");
        sportNameMap.put("Golf", "高尔夫球");
        sportNameMap.put("Gymnastics", "体操");
        sportNameMap.put("Handball", "手球");
        sportNameMap.put("Ice Hockey", "冰球");
        sportNameMap.put("Lottery", "彩票");
        sportNameMap.put("More Sports", "更多运动");
        sportNameMap.put("Motor Racing", "赛车");
        sportNameMap.put("Rugby", "橄榄球");
        sportNameMap.put("Snooker / Pool", "斯诺克/台球");
        sportNameMap.put("Soft Ball", "垒球");
        sportNameMap.put("Special Events", "特别项目");
        sportNameMap.put("Swimming", "游泳");
        sportNameMap.put("Table Tennis", "乒乓球");
        sportNameMap.put("Tennis", "网球");
        sportNameMap.put("Track and Field", "田徑");
        sportNameMap.put("Volleyball", "排球");
        sportNameMap.put("Winter Sports", "冬季运动");
    }

    private static Map<String, String> sportBetTypeMap = new HashMap<>();

    static {
        sportBetTypeMap.put("1x2", "1 X 2");
        sportBetTypeMap.put("Asian Handicap", "让球");
        sportBetTypeMap.put("Correct Score", "波胆");
        sportBetTypeMap.put("First Player to Score", "首位进球球员");
        sportBetTypeMap.put("First Team to Score", "最先进球球队");
        sportBetTypeMap.put("Half Time / Full Time", "半全场");
        sportBetTypeMap.put("Half Time Total Number of Goals", "总进球数");
        sportBetTypeMap.put("In-Play 1x2", "滚球1 X 2");
        sportBetTypeMap.put("In-Play Asian Handicap", "滚球让球");
        sportBetTypeMap.put("In-Play Correct Score", "滚球波胆");
        sportBetTypeMap.put("In-Play Half Time / Full Time", "滚球半全场");
        sportBetTypeMap.put("In-Play Half Time Total Number of Goals", "滚球总进球数");
        sportBetTypeMap.put("In-Play Money Line", "滚球独赢");
        sportBetTypeMap.put("In-Play Odd / Even", "滚球单/双");
        sportBetTypeMap.put("In-Play Over / Under", "滚球大小");
        sportBetTypeMap.put("In-Play Penalty Kick - Asian Handicap", "滚球点球让球盘");
        sportBetTypeMap.put("In-Play Penalty Kick - Over / Under", "滚球点球大小盘");
        sportBetTypeMap.put("In-Play Total Number of Goals", "滚球总进球数");
        sportBetTypeMap.put("Last Player to Score", "最后进球球员");
        sportBetTypeMap.put("Last Team to Score", "最后进球球队");
        sportBetTypeMap.put("Money Line", "独赢");
        sportBetTypeMap.put("Odd / Even", "单/双");
        sportBetTypeMap.put("Outright", "冠军投注");
        sportBetTypeMap.put("Over / Under", "大小");
        sportBetTypeMap.put("Penalty Kick - Asian Handicap", "点球让球盘");
        sportBetTypeMap.put("Penalty Kick - Over / Under", "点球大小盘");
        sportBetTypeMap.put("Player(s) Total Points", "球员总进球数");
        sportBetTypeMap.put("Set Betting", "盘数波胆");
        sportBetTypeMap.put("SPECIAL PROP. W/O. SPREAD", "特别投注");
        sportBetTypeMap.put("SPECIAL PROP. W/O. SPREAD IP", "滚球特别投注");
        sportBetTypeMap.put("Team(s) Total Points", "球队总进球数");
        sportBetTypeMap.put("Total Number of Booking(s) - Asian Handicap", "得卡总数让球盘");
        sportBetTypeMap.put("Total Number of Booking(s) - In-Play Asian Handicap", "滚球得卡总数让球盘");
        sportBetTypeMap.put("Total Number of Booking(s) - In-Play Over / Under", "滚球得卡总数大小盘");
        sportBetTypeMap.put("Total Number of Booking(s) - Over / Under", "得卡总数大小盘");
        sportBetTypeMap.put("Total Number of Corner - Asian Handicap", "角球让球盘");
        sportBetTypeMap.put("Total Number of Corner - In-Play Asian Handicap", "滚球角球让球盘");
        sportBetTypeMap.put("Total Number of Corner - In-Play Over / Under", "滚球角球大小盘");
        sportBetTypeMap.put("Total Number of Corner - Over / Under", "角球大小盘");
        sportBetTypeMap.put("Total Number of Goals", "总进球数");
        sportBetTypeMap.put("Total Number of Offside - Asian Handicap", "越位让球盘");
        sportBetTypeMap.put("Total Number of Offside - In-Play Asian Handicap", "滚球越位让球盘");
        sportBetTypeMap.put("Total Number of Offside - In-Play Over / Under", "滚球越位大小盘");
        sportBetTypeMap.put("Total Number of Offside - Over / Under", "越位大小盘");
        sportBetTypeMap.put("Total Number of Sent Off(s) - Asian Handicap", "红卡让球盘");
        sportBetTypeMap.put("Total Number of Sent Off(s) - In-Play Asian Handicap", "滚球红卡让球盘");
        sportBetTypeMap.put("Total Number of Sent Off(s) - In-Play Over / Under", "滚球红卡大小盘");
        sportBetTypeMap.put("Total Number of Sent Off(s) - Over / Under", "红卡大小盘");
        sportBetTypeMap.put("Which Team to Kick Off", "先开球球队");
    }

    private static Map<String, String> sportPeriodNameMap = new HashMap<>();

    static {
        sportPeriodNameMap.put("1st 5 Innings", "前五局");
        sportPeriodNameMap.put("1st Extra Time", "第一次加时赛");
        sportPeriodNameMap.put("1st Period", "第一节");
        sportPeriodNameMap.put("2nd Extra Time", "第二次加时赛");
        sportPeriodNameMap.put("2nd Period", "第二节");
        sportPeriodNameMap.put("3rd Extra Time", "第三次加时赛");
        sportPeriodNameMap.put("3rd Period", "第三节");
        sportPeriodNameMap.put("4th Extra Time", "第四次加时赛");
        sportPeriodNameMap.put("Fifth Set", "第五盘");
        sportPeriodNameMap.put("First Quarter", "第一节");
        sportPeriodNameMap.put("First Set", "第一盘");
        sportPeriodNameMap.put("Fourth Quarter", "第四节");
        sportPeriodNameMap.put("Fourth Set", "第四盘");
        sportPeriodNameMap.put("Full Time", "全场");
        sportPeriodNameMap.put("Full Time Game", "全场分数投注");
        sportPeriodNameMap.put("Half Time", "上半场");
        sportPeriodNameMap.put("Incl. OT & Pens", "包括加时赛与点球");
        sportPeriodNameMap.put("Point", "分");
        sportPeriodNameMap.put("Second Half Time", "下半场");
        sportPeriodNameMap.put("Second Quarter", "第二节");
        sportPeriodNameMap.put("Second Set", "第二盘");
        sportPeriodNameMap.put("Seventh Set", "第七盘");
        sportPeriodNameMap.put("Sixth Set", "第六盘");
        sportPeriodNameMap.put("Third Quarter", "第三节");
        sportPeriodNameMap.put("Third Set", "第三盘");
    }

    private static Map<String, String> sportSelectionNameMap = new HashMap<>();

    static {
        sportSelectionNameMap.put("H4A1", "4 - 1");
        sportSelectionNameMap.put("H4A2", "4 - 2");
        sportSelectionNameMap.put("H4A3", "4 - 3");
        sportSelectionNameMap.put("H4A4", "4 - 4");
        sportSelectionNameMap.put("HA", "主客");
        sportSelectionNameMap.put("HD", "主和");
        sportSelectionNameMap.put("HH", "主主");
        sportSelectionNameMap.put("Home", "主队");
        sportSelectionNameMap.put("HUP5", "主队 -净胜5球或以上");
        sportSelectionNameMap.put("No Goal", "无进球");
        sportSelectionNameMap.put("Odd", "单");
        sportSelectionNameMap.put("Others", "其它");
        sportSelectionNameMap.put("Over", "大");
        sportSelectionNameMap.put("TG0", "0");
        sportSelectionNameMap.put("TG01", "0 - 1");
        sportSelectionNameMap.put("TG1", "1");
        sportSelectionNameMap.put("TG2", "2");
        sportSelectionNameMap.put("TG23", "2 - 3");
        sportSelectionNameMap.put("TG3UP", "3或以上");
        sportSelectionNameMap.put("TG46", "4 - 6");
        sportSelectionNameMap.put("TG7UP", "7或以上");
        sportSelectionNameMap.put("Under", "小");
    }
    //扑克牌
    private static Map<Integer, String> hlqpColorNoMap = new HashMap<>();
    static {
        hlqpColorNoMap.put(1, "黑桃");
        hlqpColorNoMap.put(2, "红桃");
        hlqpColorNoMap.put(3, "梅花");
        hlqpColorNoMap.put(4, "方块");
    }
    private static Map<Integer, String> hlqpColorCardNoMap = new HashMap<>();
    static {
        hlqpColorCardNoMap.put(1, "A");
        hlqpColorCardNoMap.put(2, "2");
        hlqpColorCardNoMap.put(3, "3");
        hlqpColorCardNoMap.put(4, "4");
        hlqpColorCardNoMap.put(5, "5");
        hlqpColorCardNoMap.put(6, "6");
        hlqpColorCardNoMap.put(7, "7");
        hlqpColorCardNoMap.put(8, "8");
        hlqpColorCardNoMap.put(9, "9");
        hlqpColorCardNoMap.put(10, "10");
        hlqpColorCardNoMap.put(11, "J");
        hlqpColorCardNoMap.put(12, "Q");
        hlqpColorCardNoMap.put(13, "k");
    }
    //麻将
    private static Map<Integer, String> hlqpColorDotNoMap = new HashMap<>();
    static {
        hlqpColorDotNoMap.put(1, "1筒");
        hlqpColorDotNoMap.put(2, "2筒");
        hlqpColorDotNoMap.put(3, "3筒");
        hlqpColorDotNoMap.put(4, "4筒");
        hlqpColorDotNoMap.put(5, "5筒");
        hlqpColorDotNoMap.put(6, "6筒");
        hlqpColorDotNoMap.put(7, "7筒");
        hlqpColorDotNoMap.put(8, "8筒");
        hlqpColorDotNoMap.put(9, "9筒");
        hlqpColorDotNoMap.put(10, "白板");
    }
    //牌九
    private static Map<Integer, String> hlqpPJColorDotNoMap = new HashMap<>();
    static {
        hlqpPJColorDotNoMap.put(0, "天牌");
        hlqpPJColorDotNoMap.put(1, "地牌");
        hlqpPJColorDotNoMap.put(2, "人牌");
        hlqpPJColorDotNoMap.put(3, "鹅牌");
        hlqpPJColorDotNoMap.put(4, "梅牌");
        hlqpPJColorDotNoMap.put(5, "长三");
        hlqpPJColorDotNoMap.put(6, "板凳");
        hlqpPJColorDotNoMap.put(7, "斧头");
        hlqpPJColorDotNoMap.put(8, "红头十");
        hlqpPJColorDotNoMap.put(9, "高脚七");
        hlqpPJColorDotNoMap.put(10, "零霖六");
        hlqpPJColorDotNoMap.put(11, "杂九");
        hlqpPJColorDotNoMap.put(12, "杂九");
        hlqpPJColorDotNoMap.put(13, "杂八");
        hlqpPJColorDotNoMap.put(14, "杂八");
        hlqpPJColorDotNoMap.put(15, "杂七");
        hlqpPJColorDotNoMap.put(16, "杂七");
        hlqpPJColorDotNoMap.put(17, "杂五");
        hlqpPJColorDotNoMap.put(18, "杂五");
        hlqpPJColorDotNoMap.put(19, "丁三");
        hlqpPJColorDotNoMap.put(20, "二四");
    }

    private static Map<Integer, String> sportsOddTypeMap = new HashMap<>();
    static {
        sportsOddTypeMap.put(1, "欧洲赔率");
        sportsOddTypeMap.put(2, "香港赔率");
        sportsOddTypeMap.put(3, "马来西亚赔率");
        sportsOddTypeMap.put(4, "印尼赔率");
    }

    private static Map<String, String> xjBaccaratBetTypeNameMap = new HashMap<>();
    private static Map<String, Object> xjBaccaratBetOnMap = new HashMap<>();
    static {
        xjBaccaratBetTypeNameMap.put("Banker / Player", "庄/闲");
        xjBaccaratBetTypeNameMap.put("Tie", "和");
        xjBaccaratBetTypeNameMap.put("Banker Pair / Player Pair" , "闲对子/庄对子");
        xjBaccaratBetTypeNameMap.put("Big / Small", "大小");
        xjBaccaratBetTypeNameMap.put("Happy 6", "快乐 6");
        xjBaccaratBetTypeNameMap.put("Lucky 7", "幸运 7");
        xjBaccaratBetTypeNameMap.put("Fortune 8", "富贵 8");
        xjBaccaratBetTypeNameMap.put("Dragon Bonus", "庄龙宝/闲龙宝");
        xjBaccaratBetTypeNameMap.put("Pair Tie Bonus", "对和宝");
        xjBaccaratBetTypeNameMap.put("Parlay", "连串过关");

        xjBaccaratBetOnMap.put("Banker / Player",
                ImmutableMap.of("Banker","庄", "Banker(NC)","庄(免佣)", "Player","闲", "Player(NC)","闲(免佣)"));
        xjBaccaratBetOnMap.put("Tie",
                ImmutableMap.of("Tie","和", "Tie(NC)","和(免佣)"));
        xjBaccaratBetOnMap.put("Banker Pair / Player Pair" ,
                ImmutableMap.of("Banker Pair","庄对", "Banker Pair(NC)","庄对(免佣)","Player Pair","闲对","Player Pair(NC)","闲对(免佣)"));
        xjBaccaratBetOnMap.put("Big / Small",
                ImmutableMap.of("Small","小", "Small(NC)","小(免佣)","Big","大","Big(NC)","大(免佣)"));
        xjBaccaratBetOnMap.put("Happy6",
                ImmutableMap.of("Banker(NC)","快乐 6(免佣)"));
        xjBaccaratBetOnMap.put("Lucky 7",
                ImmutableMap.of("Banker","幸运 7"));
        xjBaccaratBetOnMap.put("Fortune 8",
                ImmutableMap.of("Player","富贵 8"));
        xjBaccaratBetOnMap.put("Dragon Bonus",
                ImmutableMap.of("Banker","庄龙宝","Banker(NC)","庄龙宝(免佣)","Player","闲龙宝","Player(NC)","闲龙宝(免佣)"));
        xjBaccaratBetOnMap.put("Pair Tie Bonus",
                ImmutableMap.of("Pair-Tie Bonus","对和宝","Pair-Tie Bonus(NC)","对和宝(免佣)"));
        xjBaccaratBetOnMap.put("Parlay",
                ImmutableMap.of("Parlay","连串过关","Parlay(NC)","连串过关(免佣)"));
    }

    public static String getXjBaccaratBetTypeName(String betType){
        String betTypeName = xjBaccaratBetTypeNameMap.get(betType);
        return StringUtils.isBlank(betTypeName) ? betType : betTypeName;
    }

    public static String getXjBaccaratBetOn(String betType, String betOnType){
        Map<String,String> betOnMap = (Map<String,String>)xjBaccaratBetOnMap.get(betType);
        if(betOnMap == null){
            return betOnType;
        }
        String betOnName = betOnMap.get(betOnType);
        return StringUtils.isBlank(betOnName) ? betOnType : betOnName;
    }

    public static String getXjBaccaratResult(String result){
        result = result.replace("P:","闲:")
                .replace("B:","庄:")
                .replace("C","")
                .replace("S","")
                .replace("H","")
                .replace("D","");
        return result;
    }

    private static Map<String, String> xjSicboBetTypeNameMap = new HashMap<>();
    private static Map<String, Object> xjSicboBetOnMap = new HashMap<>();
    static {
        xjSicboBetTypeNameMap.put("Big / Small","大小");
        xjSicboBetTypeNameMap.put("Odd / Even","单双");
        xjSicboBetTypeNameMap.put("Specific Double","对子");
        xjSicboBetTypeNameMap.put("Specific Triple","围骰");
        xjSicboBetTypeNameMap.put("Any Triple","全围");
        xjSicboBetTypeNameMap.put("Three Dice Total","总点数");
        xjSicboBetTypeNameMap.put("Two Dice Combination","双骰组合");
        xjSicboBetTypeNameMap.put("One Dice Bet","单骰组合");


        xjSicboBetOnMap.put("Big / Small", ImmutableMap.of("Small","小","Big","大"));
        xjSicboBetOnMap.put("Odd / Even", ImmutableMap.of("Odd","单","Even","双"));
        //spit
        xjSicboBetOnMap.put("Specific Double", ImmutableMap.of("Specific Double","对子"));
        xjSicboBetOnMap.put("Specific Triple", ImmutableMap.of("Specific Triple","围骰"));
        xjSicboBetOnMap.put("Any Triple", ImmutableMap.of("Any Triple","全围"));
        xjSicboBetOnMap.put("Three Dice Total", ImmutableMap.of("3 Dice Total","总点数"));
        xjSicboBetOnMap.put("Two Dice Combination", ImmutableMap.of("2 Dice Combination","双骰组合"));
        xjSicboBetOnMap.put("One Dice Bet", ImmutableMap.of("1 Dice Bet","单骰组合"));
    }

    public static String getXjSicboBetTypeName(String betType){
        String betTypeName = xjSicboBetTypeNameMap.get(betType);
        return StringUtils.isBlank(betTypeName) ? betType : betTypeName;
    }

    public static String getXjSicboBetOn(String betType, String betOnType){
        Map<String,String> betOnMap = (Map<String,String>)xjSicboBetOnMap.get(betType);
        String betOnName = null;
        if(betOnMap == null){
            return betOnType;
        }
        if(betType.contains("Big") || betType.contains("Odd")){
            betOnName = betOnMap.get(betOnType);
        }else{
            String[] betOnArry = betOnType.split("_");
            betOnName = betOnMap.get(betOnArry[0]);
            if(StringUtils.isBlank(betOnName)){
                betOnName = betOnType;
            }else{
                betOnName += betOnArry.length > 1 ? betOnArry[1] : "";
            }
        }

        return StringUtils.isBlank(betOnName) ? betOnType : betOnName;
    }

    private static Map<String, String> xjRouletteBetTypeNameMap = new HashMap<>();
    private static Map<String, Object> xjRouletteBetOnMap = new HashMap<>();
    private static List<String> redList = ImmutableList.of("1","3","5","7","9","12","14","16","18",
            "19","21","23","25","27","30","32","34","36");
    static {
        xjRouletteBetTypeNameMap.put("Straight Up","直接押注");
        xjRouletteBetTypeNameMap.put("Column / Dozen","直线押注/十二 码押注");
        xjRouletteBetTypeNameMap.put("Big / Small","大小");
        xjRouletteBetTypeNameMap.put("Odd / Even","单双");
        xjRouletteBetTypeNameMap.put("Black / Red","黑红");
        xjRouletteBetTypeNameMap.put("Split","两码押注");
        xjRouletteBetTypeNameMap.put("Street","竖排三码押注");
        xjRouletteBetTypeNameMap.put("Square","角押注");
        xjRouletteBetTypeNameMap.put("Line","竖排六码押注");
        xjRouletteBetTypeNameMap.put("Trio","三重奏");
        xjRouletteBetTypeNameMap.put("Basket","篮");

        xjRouletteBetOnMap.put("Big / Small", ImmutableMap.of("Big","大","Small","小"));
        xjRouletteBetOnMap.put("Odd / Even", ImmutableMap.of("Odd","单","Even","双"));
        xjRouletteBetOnMap.put("Black / Red", ImmutableMap.of("Black","黑","Red","红"));
        xjRouletteBetOnMap.put("Trio", ImmutableMap.of("Trio_0-1-2","三重奏 0-1-2","Trio_0-2-3","三重奏 0-2-3"));
        xjRouletteBetOnMap.put("Basket", ImmutableMap.of("Basket_0-1-2-3","篮 0-1-2-3"));
        //spit
        xjRouletteBetOnMap.put("Straight Up", ImmutableMap.of("Straight Up","直接押注"));
        xjRouletteBetOnMap.put("Column / Dozen", ImmutableMap.of("Column","直线押注","Dozen","十二码押注"));
        xjRouletteBetOnMap.put("Split", ImmutableMap.of("Split","两码押注"));
        xjRouletteBetOnMap.put("Street", ImmutableMap.of("Street","竖排三码押注"));
        xjRouletteBetOnMap.put("Square", ImmutableMap.of("Square","角押注"));
        xjRouletteBetOnMap.put("Line", ImmutableMap.of("Line","竖排六码押注"));
    }

    public static String getXjRouletteBetTypeName(String betType){
        String betTypeName = xjRouletteBetTypeNameMap.get(betType);
        return StringUtils.isBlank(betTypeName) ? betType : betTypeName;
    }

    public static String getXjRouletteBetOn(String betType, String betOnType){
        Map<String,String> betOnMap = (Map<String,String>)xjRouletteBetOnMap.get(betType);
        String betOnName = null;
        if(betOnMap == null){
            return betOnType;
        }
        if(betType.contains("Big") || betType.contains("Odd")|| betType.contains("Black")
                || betType.contains("Trio")|| betType.contains("Basket")){
            betOnName = betOnMap.get(betOnType);
        }else{
            String[] betOnArry = betOnType.split("_");
            betOnName = betOnMap.get(betOnArry[0]);
            if(StringUtils.isBlank(betOnName)){
                betOnName = betOnType;
            }else{
                betOnName += betOnArry.length > 1 ? betOnArry[1] : "";
            }
        }

        return StringUtils.isBlank(betOnName) ? betOnType : betOnName;
    }

    public static String getXjRouletteResult(String number){
        return redList.contains(number) ? "红"+number : "黑"+number ;
    }

    private static Map<String, String> xjBullBullBetTypeNameMap = new HashMap<>();
    private static Map<String, Object> xjBullBullBetOnMap = new HashMap<>();
    static {
        xjBullBullBetTypeNameMap.put("Equal","平倍");
        xjBullBullBetTypeNameMap.put("Double","翻倍");
        xjBullBullBetTypeNameMap.put("Bull Bull Bonus","牛牛宝");

        xjBullBullBetOnMap.put("Equal", ImmutableMap.builder()
                .put("Banker 1","庄 1(平倍)")
                .put("Player 1","闲 1(平倍)")
                .put("Banker 2","庄 2(平倍)")
                .put("Player 2","闲 2(平倍)")
                .put("Banker 3","庄 3(平倍)")
                .put("Player 3","闲 3(平倍)").build()
        );
        xjBullBullBetOnMap.put("Double", ImmutableMap.builder()
                .put("Banker 1","庄 1(翻倍)")
                .put("Player 1","闲 1(翻倍)")
                .put("Banker 2","庄 2(翻倍)")
                .put("Player 2","闲 2(翻倍)")
                .put("Banker 3","庄 3(翻倍)")
                .put("Player 3","闲 3(翻倍)").build()
        );
        xjBullBullBetOnMap.put("Bull Bull Bonus", ImmutableMap.of("Bull Bull Bonus","牛牛宝"));
    }

    public static String getXjBullBullBetTypeName(String betType){
        String betTypeName = xjBullBullBetTypeNameMap.get(betType);
        return StringUtils.isBlank(betTypeName) ? betType : betTypeName;
    }

    public static String getXjBullBullBetOn(String betType, String betOnType){
        Map<String,String> betOnMap = (Map<String,String>)xjBullBullBetOnMap.get(betType);
        if(betOnMap == null){
            return betOnType;
        }
        String betOnName = betOnMap.get(betOnType);
        return StringUtils.isBlank(betOnName) ? betOnType : betOnName;
    }

    public static String getXjBullBullResult(String result){
        result = result.replace("F:","首牌:")
                .replace("P1:","闲1:")
                .replace("P2:","闲2:")
                .replace("P3:","闲3:")
                .replace("B:","庄:")
                .replace("C","")
                .replace("S","")
                .replace("H","")
                .replace("D","");
        return result;
    }

    public static String getHlqpColorNo(Integer gameCode)
    {
        return hlqpColorNoMap.get(gameCode);
    }
    public static String getHlqpColorCardNo(Integer gameCode)
    {
        return hlqpColorCardNoMap.get(gameCode);
    }
    public static String getHlqpColorDotNo(Integer gameCode)
    {
        return hlqpColorDotNoMap.get(gameCode);
    }
    public static String getHlqpPJColorDotNo(Integer gameCode)
    {
        return hlqpPJColorDotNoMap.get(gameCode);
    }
    public static String getEbetGameName(Integer gameCode) {
        return ebetGameTypeMap.get(gameCode);
    }
    public static String getEbetTigerGameName(String gameCode) {
        return ebetTigerGameNameMap.get(gameCode);
    }

    public static String getEbetNiuNiuResult(Integer gameCode) {
        return ebetNiuNiuResultMap.get(gameCode);
    }

    public static String getSportName(String name) {
        return sportNameMap.get(name);
    }

    public static String getSportBetType(String type) {
        return sportBetTypeMap.get(type);
    }

    public static String getSportOddsType(Integer type) {
        return sportsOddTypeMap.get(type);
    }

    public static String getSportPeriodName(String name) {
        return sportPeriodNameMap.get(name);
    }

    public static String getSportSelectionName(String name) {
        return sportSelectionNameMap.get(name);
    }
}

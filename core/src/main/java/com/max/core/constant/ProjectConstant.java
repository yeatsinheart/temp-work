package com.max.core.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;

/**
 * 项目常量
 */
public final class ProjectConstant {


    public static final String BASE_PACKAGE = "com.max.max";// 项目基础包名称，根据自己公司的项目修改

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";// Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";// Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";// Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";// ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";// Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = "com.betball.utils.dao.Mapper";// Mapper插件基础接口的完全限定名

    public static final String MSG_TYPE_REGISTER = "mobile_register"; // 手机注册
    public static final String MSG_TYPE_BIND = "mobile_bind"; // 手机绑定
    public static final String MSG_TYPE_UNBIND = "mobile_unbind"; // 手机解绑
    public static final String MSG_TYPE_CARDBIND = "card_bind"; // 绑卡
    public static final String MSG_TYPE_CARDDEL = "card_del"; // 删除银行卡
    public static final String MSG_TYPE_SETPASS = "set_pass"; // 修改密码
    public static final String MSG_TYPE_FINDPASS = "find_pass"; // 找回密码
    public static final String MSG_TYPE_SECURITY = "security"; // 安全码
    public static final String MSG_TYPE_CASHSECURITY = "cash_security"; // 提现安全
    public static final String MSG_TYPE_LOGINSECURITY = "login_security"; // 登录安全
    public static final String MSG_TYPE_CASH = "cash"; // 提现
    public static final String MSG_TYPE_LOGIN = "login"; // 登录

    public static final String MSG_TYPE_CASHIER = "mobile_cashier";
    public static final String MSG_TYPE_WITHDRAW_VAL = "mobile_withdraw_val";
    public static final String MSG_TYPE_LOGIN_VAL = "mobile_login_val";

    public static final String EMAIL_TYPE_SETPASS = "set_pass";
    public static final String EMAIL_TYPE_LOGIN = "login_pass";
    public static final String EMAIL_TYPE_BIND = "email_bind"; // 邮箱绑定
    public static final String EMAIL_TYPE_UNBIND = "email_unbind"; // 邮箱解绑
    public static final String EMAIL_TYPE_FINDPASS = "find_pass"; // 找回密码
    public static final String EMAIL_TYPE_MODIFYPASS = "code_pass";

    public static final String FIND_PWD_MOBILE = "mobile";
    public static final String FIND_PWD_EMAIL = "email";
    public static final int REPORT_DATA_DAYS = 30;


    public static final Integer ES_FACTOR = 10000;//ES数值系数


    /**
     * 系统通知模板ID
     */
    public final class SystemNoticeTemplete {
        public final static int RECHARGE = 1;// 充值到账
        public final static int WITHDRAW = 2;// 提现成功
        public final static int TRANSFER = 3;// 转账成功
        public final static int LOGINPWD = 4;// 修改登录密码
        public final static int PAYPWD = 5;// 修改资金密码
        public final static int PWDSECURITY = 6;// 修改密保问题
        public final static int BANKCAD = 7;// 绑定银行卡
        public final static int LOGIN = 8;// 异常登录
        public final static int WIN = 9;// 中奖通知
        public final static int SEND_GIFT = 10;// 发送礼物
        public final static int UP_AMOUNT = 11; // 上分成功
        public final static int TRANSFER_FAIL = 12; // 转账失败
    }

    /**
     * 系统通知模板ID
     * 1:充值成功,2:提现成功 3:转账失败 4:红利 5:返水 6:提现退回 7:上级转入(上分) 8:加币 9:减币,10:充值失败,11:提现失败,12:提现退回失败
     */
    public final class SystemNoticeTempleteId {
        public final static int RECHARGE = 1;// 充值到账
        public final static int WITHDRAW = 2;// 提现成功
        public final static int TRANSFER_FAIL = 3;// 转账失败
        public final static int DIVIDEND = 4;// 红利
        public final static int REBATE = 5;// 返水
        public final static int WITHDRAWAL_RETURN = 6;// 提现退回
        public final static int UP_AMOUNT = 7;// 上级转入(上分)
        public final static int BONUS = 8;// 加币
        public final static int DEDUCTION = 9;// 减币
        public final static int RECHARGE_FAIL = 10;// 充值失败
        public final static int WITHDRAW_FAIL = 11;// 提现失败
        public final static int WITHDRAWAL_RETURN_FAIL = 12;// 提现退回失败

        public final static int LOGINPWD = 12;// 修改登录密码
        public final static int PAYPWD = 13;// 修改资金密码
        public final static int PWDSECURITY = 14;// 修改密保问题
        public final static int BANKCAD = 15;// 绑定银行卡
        public final static int LOGIN = 16;// 异常登录
        public final static int WIN = 17;// 中奖通知
        public final static int SEND_GIFT = 18;// 发送礼物
        public final static int LOGIN_LOCKED = 19;// 登录锁定
    }

    /**
     * 各种状态定义
     */
    public final class Status {
        public final static int NORMAL = 0;// 正常状态
        public final static int UNSELECTED = 0;// 未选中
        public final static int SELECTED = 1;// 已选中
        public final static int PENDING = 0;// 待处理
        public final static int SUCCESS = 1;// 处理成功
        public final static int FAILED = 2; // 处理失败
        public final static int ERROR = -1; // 状态错误
    }

    /**
     * 异常提现类型
     */
    public final class WithdrawRiskType {
        public final static int NORMAL = 0;// 正常状态
        public final static int FIRST_AMOUNT_RISK = 1;// 首提金额过大
        public final static int SINGLE_AMOUNT_RISK = 2;// 单笔金额过大
        public final static int DAILY_AMOUNT_RISK = 3;// 当日金额过大
        public final static int DAILY_TIMES_RISK = 4;// 频繁提现
        public final static int DAILY_PROFIT_RISK = 5;// 利润异常
        public final static int WEEKLY_AMOUNT_RISK = 6;// 7日累积金额过大
        public final static int IP_CONFLICT_RISK = 7;// 提现IP冲突
        public final static int DEVICE_CONFLICT_RISK = 8;// 提现设备冲突
    }

    /**
     * 出款类型
     */
    public final class WithdrawType {
        public final static int MANUAL = 0;// 手动出款
        public final static int API = 1;// 三方自动出款
        public final static int API_MANUAL = 2; //三方手动出款
    }

    /**
     * 提现状态
     */
    public final class WithdrawStatus {
        public final static int RISK_PENDING = -3; // 风险待审核
        public final static int RISK_REJECT = -2; // 风险审核拒绝
        public final static int PENDING = 0; // 风险审核通过-待出款
        public final static int SUCCESS = 1; // 出款成功
        public final static int FAILED = 2; // 拒绝出款(出款失败)
        public final static int RETURN_PENDING = 3; // 申请退回中
        public final static int RETURN = 4; // 退回成功
        public final static int RETURN_REJECT = 5; // 拒绝退回
        public final static int SUCCESS_PENDING = 6; // 申请强制成功中
        public final static int AUTO_FAILED = 7; // 自动出款失败
        public final static int FORCE_SUCCESS = 8; // 通过强制成功
        public final static int FORCE_SUCCESS_REJECT = 9; // 拒绝强制成功
        public final static int AUTO_PENDING = 10; //三方自动出款中
        public final static int SEPERATOR_PENDING = 11; // 出款专员处理中 （该状态不入库）
    }

    /**
     * 用户帐变类型
     *
     * @author Leo
     * <p>
     * 2015年8月4日 上午11:58:41
     */
    public final class BalanceType {
        // 交易类型：1存款，2提现，3转账，4红利，5返水，6人工加币，7人工减币，8上级转入，9佣金,10其他
        // 前台交易类型对照：1存款，2提现，3转账，4红利（包括加币），5返水，8上级转入，9佣金，10其他（包括减币）
        public final static int RECHARGE = 1;
        public final static int WITHDRAW = 2;
        public final static int TRANSFER = 3;
        public final static int BONUS = 4;
        public final static int REBATE = 5;
        public final static int ADD = 6;
        public final static int DIS = 7;
        public final static int CREDIT = 8;
        public final static int COMMISSION = 9;
        public final static int OTHERS = 10;

        public final static int API_TRANSFER = 1; // 接口转账出款
        public final static int MANUAL_TRANSFER = 0; // 手动转账出款
    }

    public final class PaymentType {
        /**
         * @Author: Sim
         * @Description: 支付方式
         * @params:
         * @Date: 上午10:46 2018/5/14
         */
        public final static int CHUKUAN = 0; // 出款

        public final static int WANGYIN = 1; // 网银支付
        public final static int ZHIFUBAO = 2; // 支付宝支付
        public final static int WEIXIN = 3; // 微信支付
        public final static int QQ = 4; // QQ支付

        public final static int UNION = 5; // 银联扫码
        public final static int UNION_SCAN_PAY = 5; // 银联扫码支付

        public final static int JD = 6; // 京东支付
        public final static int JD_SCAN_PAY = 6; // 京东扫码支付

        public final static int BANKCARD_ZHUANZ = 7; // 银行卡转账
        public final static int ZHIFUBAO_ZHUANZ = 8; // 支付宝转账
        public final static int WEIXIN_ZHUANZ = 9; // 微信转账

        public final static int SCAN_PAY = 12; // 扫码支付
        public final static int QQ_SCAN_PAY = 13; // QQ扫码支付

        public final static int WANGYIN2 = 19; // 网银支付二
        public final static int WANGYIN3 = 20; // 网银支付三
        public final static int WEIXIN2 = 21; // 微信支付二
        public final static int CREDIT_CARD = 22; // 信用卡支付
        public final static int WEIXIN3 = 23; // 微信支付三
        public final static int QUICK_PAY = 24; // 快捷支付
        public final static int UNION_PAY = 25; // 云闪付

        /**
         * @Author: Sim
         * @Description: 支付渠道
         * @params:
         * @Date: 上午10:46 2018/5/14
         */
        public final static int BAOFOO = 1;// 宝付支付
        public final static int JUBAO = 2;// 聚宝支付
        public final static int YEEPAY = 3;// 易宝支付
        public final static int MOBO = 4;// 魔宝支付
        public final static int KUAI41 = 5;// 快汇通
        public final static int EKAPAY = 6; // 易优付
        public final static int DINPAY = 7; // 智付

        public final static int EYPAL = 10; // 盈宝
        public final static int NEWPAY = 11;// 新生支付
        public final static int YOMPAY = 12;// 优付支付
        public final static int SWIFTPASS = 13;// 威富通支付
        public final static int ECPSS = 14;// 汇朝支付
        public final static int KJTPAY = 15;// 快捷通支付
        public final static int SIXPAY = 16;// 6付支付
        public final static int YSEPAY = 17;// 银盛支付
        public final static int YHJPAY = 18;// 易汇金支付
        public final static int FUNPAY = 19;// 乐盈支付
        public final static int MOBO_YUNHUI = 20;// 摩宝云汇
        public final static int SHOUFUTONG = 23;// 收付通

        public final static int HUA_SHI = 25;// 华势支付
        public final static int SHANGXIN = 26;// 商信易支付
        public final static int HUICHAO = 27;// 汇潮支付
        public final static int PUXUN = 28;// 普讯支付
        public final static int HUANXUN = 30;// 环迅支付
        public final static int JUHE = 31; // 聚合支付
        public final static int NEW_YSEPAY = 32; // 新银盛支付
        public final static int JHZ = 33;// 金海哲支付(收付通)
        public final static int SHUORAN = 34; // 硕冉支付
        public final static int JUCHENG = 35; // 聚诚汇付
        public final static int SUHUIBAO = 36; // 速汇宝支付
        public final static int ZESHENG = 37; // 泽圣支付
        public final static int EHUIKA = 38; // 易汇卡支付
        public final static int TFB8 = 39; // 天付宝支付
        public final static int YUANFU = 40; // 源付支付
        public final static int GAOHUITONG = 41; // 高汇通支付
        public final static int ZHONGWEIPAY = 42; // 众微付
        public final static int YIMATONG = 43; // 一码通
        public final static int SHIKEBAO = 44; // 时刻宝支付
        public final static int HUITONG = 45; // 汇通支付
        public final static int DUODUO = 46; // 多多支付
        public final static int POLYPAY = 47; // 易融支付
        public final static int S66PAY = 48; // 顺付通支付
        public final static int GXTPAY = 49; // 国信通支付
        public final static int OPENEPAY = 50; // 开联通支付
        public final static int ETONEPAY = 51; // 易通支付
        public final static int QYFPAY = 52;// 轻易付支付
        public final static int HUITIANFU = 76;// 汇天付
        public final static int HANYIN = 78;// 瀚银支付

        public final static int GOPAY = 8; // 国付宝
        public final static int CHINAGPAY = 54; // 爱农支付

        public final static int IFEEPAY = 53;// 艾付支付
        public final static int EFENGPAY = 58; // 亿丰支付
        public final static int XINFUTONG = 68;// B019-信付通支付
        public final static int GAIYA = 75;// 盖亚支付
        public final static int RUYI = 77;// B001-如意支付
        public final static int DUOBAO = 81;// 多宝支付
        public final static int HANYINV2 = 82;// 瀚银官方
        public final static int EFENGWANGYINPAY = 83;// 亿丰网银支付
        public final static int ZBPAY = 84; // 众宝支付
        public final static int MAYIPAY = 85; // B004-蚂蚁支付
        public final static int UIBENPAY = 86; // 皮皮支付
        public final static int ONEGOPAY = 87; // B007-OneGo支付
        public final static int JIXIANG = 88; // B006-吉祥支付
        public final static int SAVEPAY = 89; // B010-安心付
        public final static int WATERPAY = 90; // B009-Water支付
        public final static int BEIJING = 22;// 首信易
        public final static int XFPAY = 91; // B012-信付支付
        public final static int UCFPAY = 92; // B003-先锋支付
        public final static int HUITAOPAY = 93; // B014-汇淘支付
        public final static int DUOPAY = 94; // 多代支付
        public final static int BITERPAY = 95; // B013-比特支付
        public final static int CHANGPAY = 96; // B016-畅汇
        public final static int JUHUIPAY = 97; // B011-聚汇支付
        public final static int HUIFUBAO = 98; // B017-惠付宝
        public final static int SITONGPAY = 99; //B022-四通支付
        public final static int XINPAY = 100; // B018-新付支付
        public final static int JSPPAY = 101; // B020-极之宝
        public final static int QBPAY = 102; // B023-QB支付
        public final static int YHPAY = 103; // B025-永恒支付
        public final static int MACHI = 104; // B026-麻吉付
        public final static int BVV = 105; // B027-BVV代付
        public final static int JUBAOPEN = 106; //B021_聚宝盆华城
        public final static int JIUFU = 107; //B028-玖付支付
        public final static int JUBAOFU = 108; //B020-聚宝付支付
        public final static int WATER_REDPACK = 109; //B024-water支付宝红包
        public final static int XINDUOBAO = 110; // B005-鑫多宝
        public final static int XIANFENG = 111; // B029-先锋支付
        public final static int HAOFU = 112; //B030-豪富支付
        public final static int EXPAY = 113; //expay
        public final static int UPAY = 114; //B009-UPAY 支付
        public final static int COCOPAY = 115; //B031-cocopay支付
        public final static int B032_PONYPAY = 116; //B032-立马付
        public final static int B034_HAOFU_PAY = 117; //B034_好付
        public final static int B033_168_PAY = 118; //B033_168支付
        public final static int B037_HUYUNPAY = 119; //B037虎云支付
        public final static int B038_GPAY = 120; //B038-GPay支付
        public final static int B036_HOTPOTPAY = 121; //B036-锅子支付
        public final static int GUANFUBAO = 122; // B042-贯付宝支付
        public final static int OUFEI = 123; // B041-欧飞支付

        public final static int FENGYUN = 1001; // B002-风云聚合
        public final static int JBP = 1002; // B008-聚宝盆

        public final static int YIFUBAO = 2001;// 彩票项目-易付宝

    }

    public final static int[] OS_LIST = new int[]{OSType.ALL, OSType.PC, OSType.H5, OSType.ANDROID, OSType.IOS,
            OSType.PAD};

    public final class OSType { // -1ALL, 0PC，1H5，2安卓，3IOS，4PAD
        public final static int ALL = -1;
        public final static int PC = 0;
        public final static int H5 = 1;
        public final static int ANDROID = 2;
        public final static int IOS = 3;
        public final static int PAD = 4;
    }

    public final static int[] CLIENT_LIST = new int[]{ClientType.ALL, ClientType.PC, ClientType.APP};

    public final class ClientType {//应用端(0 PC端、1 移动端)
        public final static int ALL = -1;
        public final static int PC = 0;
        public final static int APP = 1;
    }

    public final class APPType { // -1ALL, 0现金网，1体育，2代理
        public final static int ALL = -1; // 全部
        public final static int CASH = 0; // 现金网
        public final static int SPORT = 1; // 体育
        public final static int PROXY = 2; // 代理
    }

    public final class ACT_ID { // 活动ID：-1全部，1首存活动，2体育闯关活动，3真人连赢活动，4老虎机救援金活动
        public final static int ALL = -1; // 全部
        public final static int FIRST_RECHARGE = 1; // 首存活动
        public final static int SPORT_GO = 2; // 体育闯关活动
        public final static int REAL_WIN = 3; // 真人连赢活动
        public final static int TIGER_RESCUE = 4; // 老虎机救援金活动
        public final static int GAME_REBATE = 5; // 返水活动
        public final static int REAL_OVERCOME = 6; // 真人闯关活动
        public final static int BONUS = 7; // 红包活动
        public final static int SPORT_RETURN = 8; // 体育返现活动
        public final static int GOLDEN_EGG = 9; // 砸金蛋活动
        public final static int LUCKY_WHEEL = 10; // 幸运大轮盘活动
        public final static int ZONGZI_FESTIVAL = 11; // 端午节活动
        public final static int AMERICAS_CUP = 12; // 美洲杯活动
        public final static int VIP_UPGRADE = 13; // VIP升级礼金
        public final static int VIP_BIRTHDAY = 14; // VIP生日礼金
        public final static int VIP_MONTHLY = 15; // VIP月度礼金

    }

    public final class ActivityStatus { // 活动状态：-1未达标，0已达标未领取，1已领取，2已过期
        public final static int UN_AVALIABLE = -1; // 未达标
        public final static int AVALIABLE = 0; // 已达标未领取
        public final static int RECEIVED = 1; // 已领取
        public final static int EXPIRED = 2; // 已过期
        public final static int PROCESS = 3;// 进行中，不能领取
    }

    public final class RechargeStatus { // 支付状态：0：待支付，1：支付成功，2：支付失败，3：补单审核中
        public final static int PENDING = 0;
        public final static int SUCCESS = 1;
        public final static int FAILED = 2;
        public final static int REVIEW = 3;
    }

    public final class ActivitySportReturnStatus { // 体育存返活动状态：1.请先完成首存活动（按钮跳转首存活动）  2.未领取  3.未达标(未登录显示未达标)  4.进行中  5.结算中（12-1点展示）  6.过期  7.已领取
        public final static int UNFINISHEDDEPOSIT = 1; // 首存活动未完成
        public final static int AVALIABLE = 2; // 已达标未领取
        public final static int UN_AVALIABLE = 3; // 未达标
        public final static int PROCESS = 4;// 进行中，不能领取
        public final static int SETTLEMENT = 5; // 结算中
        public final static int EXPIRED = 6; // 已过期
        public final static int RECEIVED = 7; // 已领取
    }

    /**
     * 反馈记录表(平台收信箱)平台状态
     * 平台状态(0:未处理,1:待回复,2:待发送,3已回复)
     */
    public final class FeedbackRecordPlatformState {
        public final static int UNTREATED = 0; // 未处理
        public final static int PENDING_REPLY = 1; // 待回复
        public final static int UNSEND = 2; // 待发送
        public final static int RECOVERED = 3; // 已回复
    }

    /**
     * 信件状态(平台发件箱)平台状态
     * 信件模板状态(0:待发送,1:已发送,2已收回,3:临时状态(后台立即发送,但是前台未触发))
     */
    public final class LetterTemplateState {
        public final static int UNSEND = 0; // 待发送
        public final static int SEND = 1; // 已发送
        public final static int REVOKE = 2; // 已收回
    }

    /**
     * 信件类别(0:普通信件,1:活动信件,2:回复信件,3:系统消息)
     */
    public final class LetterType {
        public final static int ORDINARY = 0;
        public final static int ACTIVITY = 1;
        public final static int REPLY = 2;
        public final static int SYSTEM = 3;
    }

    /**
     * 产品端维护类型(1:会员-PC端,2:会员-IOS端,3:会员-ANDROID端,4:代理-PC端,5:代理-IOS端,6:代理-ANDROID端,7:体育-IOS端,8:体育-ANDROID端,9:会员-H5端)
     */
    public final class ProductType {
        public final static String USER_PC = "1";
        public final static String USER_IOS = "2";
        public final static String USER_ANDROID = "3";
        public final static String PRO_PC = "4";
        public final static String PRO_IOS = "5";
        public final static String PRO_ANDROID = "6";
        public final static String SPORT_IOS = "7";
        public final static String SPORT_ANDROID = "8";
        public final static String USER_H5 = "9";
    }

    public final class LevelType {
        public final static int USER_LEVEL = 0;
        public final static int PROXY_LEVEL = 1;
    }

    /**
     * 通用状态定义（0 - 正常、 1 - 失效、 2 - 已删除）
     */
    public final class CommonStatus {
        public final static int NORMAL = 0;
        public final static int INVALID = 1;
        public final static int DELETE = 2;
    }

    public final static int[] PAYMENT_CACHE_LIST = new int[]{PaymentCache.NORMAL, PaymentCache.LARGE};

    /**
     * 充值商户缓存：0 普通充值、1 大额充值
     */
    public final class PaymentCache {
        public final static int NORMAL = 0;
        public final static int LARGE = 1;
    }

    public enum GlGameTypeEnum {

        //0彩票，1真人，2体育，3老虎机，4捕鱼，5电竞
        TICKET(0),
        LIVE(1),
        SPORTS(2),
        TIGER(3),
        FISH(4),
        E_SPORTS(5),
        POKER(6);

        private int value = 0;

        GlGameTypeEnum(int value) {
            this.value = value;
        }

        @JsonValue
        public int value() {
            return this.value;
        }
    }

    public enum GlGameMaintainEnum {

        //0彩票，1真人，2体育，3老虎机，4捕鱼，5电竞
        AG_LIVE(1),
        AG_FISH(2),
        SPORT_188(3),
        PT_TIGER(4),
        EBET_LIVE(5),
        AG_TIGER(6),
        LB_TICKET(8),
        HL_POKER(10),
        GM_POKER(11),
        IM_TIGER(17),
        SW_LOTTERY(19),
        ;

        private int value;

        GlGameMaintainEnum(int value) {
            this.value = value;
        }

        @JsonValue
        public int value() {
            return this.value;
        }
    }

    public enum ImProductWalletEnum {

        //0彩票，1真人，2体育，3老虎机，4捕鱼，5电竞
        ESPORTSBULL(401),
        SW_LOTTERY(504),
        PP_TIGER(101),
        PT_TIGER(102),
        ;

        private int value = 0;

        ImProductWalletEnum(int value) {
            this.value = value;
        }

        @JsonValue
        public int value() {
            return this.value;
        }
    }

    /**
     * 充值异常状态
     */
    public final class RechargeErrorStatus { // 0 - 系统异常、1 - 三方异常
        public final static int SYSTEM = 0;
        public final static int PAYMENT = 1;
    }

    /**
     * 用户层级类型
     */
    public final class UserLevelType { // 0 - 会员层级、1 - 代理层级
        public final static int USER = 0;
        public final static int PROXY = 1;
    }

    /**
     * 转盘类型： 0:充值,1:投注,2:输赢,3:公共配置
     */
    public final class LuckyWheelType {
        public final static int RECHARGE = 0;
        public final static int BET = 1;
        public final static int WIN = 2;
        public final static int CONFIG = 3;
    }

    /**
     * 奖励物品： 0:充值返利券(单次有效),1:投注返利券,2:中奖返利券,3:亏损补贴券,4:免费彩金,5:能量点
     */
    public final class LuckyWheelProp {
        public final static int REFUND_COUPON = 0;
        public final static int BET_COUPON = 1;
        public final static int WIN_COUPON = 2;
        public final static int LOSS_COUPON = 3;
        public final static int FREE_BONUS = 4;
        public final static int ENERGY_POINT = 5;
        public final static int PHYSICAL_REWARD = 9;
    }

    /**
     * 福利中心奖励：0:VIP生日奖励,1:VIP升级奖励,2:VIP月度奖励
     */
    public final class awardType {
        public final static int VIP_BIRTHDAY_AWARD = 0;
        public final static int VIP_UPGRADE_AWARD = 1;
        public final static int VIP_MONTHLY_AWARD = 2;
    }

    /**
     * 福利状态：-1不可领取，0已达标未领取，1已领取，2已过期
     */
    public final class awardStatus {
        public final static int UN_AVALIABLE = -1;
        public final static int AVALIABLE = 0;
        public final static int RECEIVED = 1;
        public final static int EXPIRED = 2;
    }

    /**
     * 任务(0:绑定银行卡,1:绑定手机,2:绑定邮箱,3:充值额,4:有效投注额,5:盈利额,6:体育投注,7:EBET体育投注,
     * 8:AG真人投注,9:PT电子投注,10:AG电子投注,11:AG捕鱼投注,12:LB彩票投注,13:GM棋牌投注,14:欢乐棋牌投注)
     */
    public final class TaskList {
        public final static int BIND_CARD = 0;
        public final static int BIND_MOBLLE = 1;
        public final static int BIND_MAIL = 2;
        public final static int RECHARGE = 3;
        public final static int BET = 4;
        public final static int PROFIT = 5;
        public final static int SPORT_BET = 6;
        public final static int EBET_BET = 7;
        public final static int AG_REAL_BET = 8;
        public final static int PT_BET = 9;
        public final static int AG_ELECTRONIC_BET = 10;
        public final static int AG_FISHING_BET = 11;
        public final static int LB_BET = 12;
        public final static int GM_BET = 13;
        public final static int HLQP_BET = 14;
    }

    public final static class BigDecimalNum {
        public final static BigDecimal TEN_THOUSAND = new BigDecimal(10000);
    }

    /**
     * 端午节活动状态(0:未获得,1:已获得,2:已剥完)
     */
    public final class zongziStatus {
        public final static int NO = 0;
        public final static int YES = 1;
        public final static int USE = 2;
    }

    /**
     * 用户黑名单类型
     */
    public final class BlackType { // 0 - 账号黑名单、1 - IP黑名单、2 - 设备号、3 - 银行卡号、4 - 手机号、1 - 真实姓名
        public final static int USERNAME = 0;
        public final static int IP = 1;
        public final static int DEVICEID = 2;
        public final static int BANKCARD = 3;
        public final static int MOBILE = 4;
        public final static int REALNAME = 5;
    }

    /**
     * 黑名单权限
     */
    public final class BlackPermission { //会随需求扩展 0 - 禁止注册、1 - 监控注册、2 - 禁止登陆、3 - 监控登陆、4 - 禁止提现、1 - 监控提现、1 - 禁止发放返水、1 - 监控发放返水
        public final static int REGISTER_MONITORED = 100;
        public final static int REGISTER_FORBIDEN = 101;
        public final static int LOGGIN_MONITORED = 200;
        public final static int LOGGIN_FORBIDEN = 201;
        public final static int WITHDRAW_MONITORED = 300;
        public final static int WITHDRAW_FORBIDEN = 301;
        public final static int REBATE_MONITORED = 400;
        public final static int REBATE_FORBIDEN = 401;

    }

    /**
     * 黑名单操作类型
     */
    public final class BlackOptType { // 0 - 手动添加、1 - 调整等级、2 - 调整关联等级
        public final static int HAND_ADD = 0;
        public final static int LEVEL_UPDATED = 1;
        public final static int LEVEL_RELEVANCE_UPDATED = 2;

    }

    /**
     * 黑名单监控行为
     */
    public final class BlackBehavior { // 0 - 登录、1 - 注册、2 - 提现 3-返水
        public final static int LOGIN = 0;
        public final static int REGISTER = 1;
        public final static int WITHDRAW = 2;

    }

    /**
     * 端午节活动抽奖类型(0:如意,1:吉祥)
     */
    public final class zongziRewardType {
        public final static int WISHFUL = 0;
        public final static int AUSPICIOUS = 1;
    }

    /**
     * 行为发起人的分类，比如VIP可以有系统自动调整，或者人工手动调整，代理上分清算可以后台清算，或者自行清算，适时拓展
     */
    public final class OPERATION_TYPE {
        public final static int AUTO = 0;//自动的，系统的
        public final static int MANUAL = 1;//人工操作的
    }

    /**
     * 锁定状态常量，目前可用于用户层级，用户VIP等级的锁定状态，其他场景可酌情使用，适度拓展
     */
    public final class lockStatus {
        public final static int UNLOCKED = 0;//未锁定
        public final static int LOCKED = 1;//已锁定
    }

    /**
     * 同IP 注册限制功能按钮
     */
    public final class SameIpLimitButton { // 0 - 关闭、1 - 开启
        public final static int OFF = 0;
        public final static int ON = 1;
    }

    /**
     * 上分操作类型
     */
    public final class CreditOptType {
        //人工清算
        public final static int ARTIFICIAL_CREDIT = 1;
        //代理上分
        public final static int PROXY_CREDIT = 2;
        //公司上分
        public final static int COMPANY_CREDIT = 3;
        //会员上分
        public final static int PAYER_CREDIT = 4;
        //余额抵扣清算
        public final static int DEDUCTION_CREDIT = 5;

    }

    /**
     * 系统API分类，对应DB中的api_type字段
     */
    public final class SystemApiType {
        public final static int SMS = 1;                 // 短信
        public final static int SMS_INTERNATIONAL = 5;   // 国际短信
        public final static int BANK_CARD = 2;           // 银行卡
    }

    /**
     * 系统API
     */
    public final class SystemApi {
        public final static String BANK_API = "BANK_API";    // 校验银行卡
        public final static String SMS_API = "SMS_API";    // 校验银行卡
        public final static int SHOW_BANK = 3;               // 银行卡接口1
        public final static int SHOW_SMS = 4;                 // showapi
        public final static int YUNZHIXUN = 5;               // 云之讯
        public final static int WANGYI = 6;                  // 网易
        public final static int YUNPIAN = 7;                 // 云片
        public final static int WANGYI_INTERNATIONAL = 8;    // 网易国际
        public final static int BANK_API_APIX = 9;           // 银行卡接口Apix
    }

}

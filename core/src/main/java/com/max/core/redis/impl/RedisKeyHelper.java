package com.max.core.redis.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Redis Key 辅助类
 */
@Component
@Lazy(false)
public class RedisKeyHelper {
    public static final String USER_SIGNIN_CODE = "USER_SIGNIN_CODE_";
    public static final String USER_LOGIN_CODE = "USER_LOGIN_CODE_";
    public static final String USER_PHONE_LOGIN_CODE = "USER_PHONE_LOGIN_CODE_";
    public static final String USER_PHONE_SIGNIN_BEFORE_CODE = "USER_PHONE_SIGNIN_BEFORE_CODE_";
    public static final String USER_PHONE_SIGNIN_CODE = "USER_PHONE_SIGNIN_CODE_";
    public static final String TOKEN_ONLINE = "TOKEN_ONLINE_";
    public static final String USER_ONLINE = "USER_ONLINE_";

    /**
     * 首充活动配置
     */
    public static final String FIRST_RECHARGE_CONFIG = "FIRST_RECHARGE_CONFIG";

    /**
     * 体育闯关活动配置
     */
    public static final String SPORT_GO_CONFIG = "SPORT_GO_CONFIG";

    /**
     * 体育存送活动配置
     */
    public static final String SPORT_RETURN_CONFIG = "SPORT_RETURN_CONFIG";

    /**
     * 真人连赢活动配置
     */
    public static final String REAL_WIN_CONFIG = "REAL_WIN_CONFIG";

    /**
     * 老虎机救援活动配置
     */
    public static final String TIGER_RESCUE_CONFIG = "TIGER_RESCUE_CONFIG";
    /**
     * 真人闯关活动配置
     */
    public static final String REAL_OVERCOME_CONFIG = "REAL_OVERCOME_CONFIG";
    /**
     * 真人闯关类游戏的返水发放上限
     */
    public static final String REAL_OVERCOME_REBATE_LIMIT_AMOUNT = "REAL_OVERCOME_REBATE_LIMIT_AMOUNT";
    /**
     * 真人闯关类游戏的返水发放用户小计
     */
    public static final String REAL_OVERCOME_REBATE_LIMIT_SUM = "REAL_OVERCOME_REBATE_LIMIT_SUM_";

    /**
     * 返水活动配置
     */
    public static final String GAME_REBATE = "GAME_REBATE";
    /**
     * 红包活动配置
     */
    public static final String BONUS_CONFIG = "BONUS_CONFIG";

    /**
     * 红包活动配置，用户当天的红包额度
     */
    public static final String BONUS_RANGE_FOR_TODAY = "BONUS_RANGE_FOR_TODAY";

    /**
     * 红包活动配置，每一波红包的数量
     */
    public static final String BONUS_COUNT_EACH_WAVE = "BONUS_COUNT_EACH_WAVE";

    /**
     * 红包活动配置，每一波红包的数量
     */
    public static final String BONUS_RECEIVE = "BONUS_RECEIVE";

    /**
     * 红包活动防止暴力刷新
     */
    public static final String BONUS_RECEIVE_REFRESH_FORBIDDEN_PREFIX = "BONUS_RECEIVE_REFRESH_FORBIDDEN_PREFIX";

    /**
     * 转盘活动配置
     */
    public static final String LUCKY_WHEEL_CONFIG = "LUCKY_WHEEL_CONFIG_";

    /**
     * 转盘活动公共配置
     */
    public static final String LUCKY_WHEEL_COMMON_CONFIG = "LUCKY_WHEEL_COMMON_CONFIG";

    /**
     * 转盘活动惊喜大奖列表
     */
    public static final String LUCKY_WHEEL_SURPRISE_AWARD = "LUCKY_WHEEL_SURPRISE_AWARD";

    /**
     * 转盘活动惊喜大奖能量点
     */
    public static final String LUCKY_WHEEL_ENERGY_POINT = "LUCKY_WHEEL_ENERGY_POINT";

    /**
     * 转盘活动任务列表
     */
    public static final String LUCKY_WHEEL_TASK_LIST = "LUCKY_WHEEL_TASK_LIST";

    /**
     * 转盘活动用户每日
     */
    public static final String LUCKY_WHEEL_USER = "LUCKY_WHEEL_USER_";

    /**
     * 用户今天已经中过的唯一性券(投注,中奖,亏损券)
     */
    public static final String LUCKY_WHEEL_CONFIG_USER_ONLY = "LUCKY_WHEEL_CONFIG_USER_ONLY_";

    /**
     * 第三方出款失败队列
     */
    public static final String WITHDRAW_FAILED_LIST = "WITHDRAW_FAILED_LIST_";
    /**
     * 第三方出款成功金额
     */
    public static final String WITHDRAW_SUCCESS_AMOUNT = "WITHDRAW_SUCCESS_AMOUNT_";

    /**
     * 帐变ID
     */
    public static final String USER_BALANCE_DETAIL_ID = "USER_BALANCE_DETAIL_ID";

    /**
     * 用户后台操作ID
     */
    public static final String USER_MANAGE_ID = "USER_MANAGE_ID";
    /**
     * 用户前台操作ID
     */
    public static final String USER_OPERATION_ID = "USER_OPERATION_ID";
    /**
     * 系统通知上次获取时间
     */
    public static String USER_NOTICE_LAST_TIME = "USER_NOTICE_LAST_TIME_";
    /**
     * 用户登录失败次数
     */
    public static String LOGIN_FAIL_TIME = "LOGIN_FAIL_TIME_";

    public static String IMAGE_CODE_CACHE = "IMAGE_CODE_";
    /**
     * 邮箱验证码发送时间
     */
    public static String EMAIL_MSG_SEND_TIME = "EMAIL_MSG_SEND_TIME_";
    /**
     * 短信验证码发送时间
     */
    public static String MOBILE_MSG_SEND_TIME = "MOBILE_MSG_SEND_TIME_";
    /**
     * 短信验证码发送次数
     */
    public static String SMS_SEND_COUNT = "SMS_SEND_COUNT";
    /**
     * 银行卡验证次数
     */
    public static String BANK_CARD_VALIDATE_COUNT = "BANK_CARD_VALIDATE_COUNT";
    /**
     * 银行卡验证错误次数
     */
    public static String BANK_CARD_VALIDATE_ERROR_COUNT = "BANK_CARD_VALIDATE_ERROR_COUNT";
    /**
     * 第三方渠道API配置-短信
     */
    public static String SYSTEM_API_SMS = "SYSTEM_API_SMS";
    /**
     * 第三方渠道API配置-国际短信
     */
    public static String SYSTEM_API_SMS_INTERNATIONAL = "SYSTEM_API_SMS_INTERNATIONAL";
    /**
     * 第三方渠道API配置-银行卡
     */
    public static String SYSTEM_API_BANK_CARD = "SYSTEM_API_BANK_CARD";
    /**
     * 手机号注册锁定用户名
     */
    public static final String USERNAME_MOBILE_LOCK = "USERNAME_MOBILE_LOCK_";
    /**
     * 用户层级列表缓存
     */
    public static String USER_LEVEL_CACHE = "USER_LEVEL_CACHE";

    /**
     * 接口与岗位权限的关系缓存
     */
    public static String API_JOB_CACHE = "API_JOB_CACHE_";
    /**
     * 岗位菜单权限缓存
     */
    public static String JOB_MENU_CACHE = "JOB_MENU_CACHE_";
    /**
     * 岗位数据菜单权限缓存
     */
    public static String JOB_DATA_MENU_CACHE = "JOB_DATA_MENU_CACHE_";
    /**
     * 黑名单等级（分组）权限缓存
     */
    public static String BLACK_USERNAME_PERMISSION_CACHE = "BLACK_USERNAME_PERMISSION_CACHE_";
    /**
     * 黑名单功能开关
     */
    public static String BLACK_ONOFF = "BLACK_ONOFF";
    /**
     * 部门数据缓存
     */
    public static String DEPARTMENT_CACHE = "DEPARTMENT_CACHE";
    /**
     * 应用级别前缀
     */
    public static String REQ_TOKEN = "TOKEN_";
    /**
     * 被顶掉的token
     */
    public static String KICKED_TOKEN = "KICKED_TOKEN_";
    /**
     * 登录用户ID前缀
     */
    public static String REQ_LOGIN = "LOGIN_";
    /**
     * 后台登录TOKEN
     */
    public static String ADMIN_TOKEN = "ADMIN_TOKEN_";
    /**
     * 后台用户信息
     */
    public static String ADMIN_USER = "ADMIN_USER_";

    /**
     * 首页活动推荐缓存前缀
     */
    public static final String HOME_PAGE_ACT_RECOMMEND = "HOME_PAGE_ACT_RECOMMEND";
    /**
     * 短信验证失败次数
     */
    public static String MOBILE_FAIL_TIME = "MOBILE_FAIL_TIME_";

    /**
     * 处理中的出款订单
     */
    public static final String WITHDRAW_PENDING_LIST = "WITHDRAW_PENDING_LIST";

    /**
     * 操作过的出款订单
     */
    public static final String WITHDRAW_PENDING_LIST_CACHE = "WITHDRAW_PENDING_LIST_CACHE";

    /**
     * 同账户同时提现
     */
    public static final String LOCK_WITHDRAW = "LOCK_WITHDRAW_";

    /**
     * 游戏余额缓存
     */
    public static final String GAME_BALANCE_CACHE = "GAME_BALANCE_CACHE_";

    /**
     * 等待发送的反馈回复
     */
    public static final String WAITING_RECORD_ID = "WAITING_RECORD_ID";

    /**
     * 等待发送的信件
     */
    public static final String WAITING_LETTER_ID = "WAITING_LETTER_ID";

    /**
     * 信件已读未读人数统计key
     */
    public static final String IS_READ_COUNT = "IS_READ_COUNT_";


    /**
     * 产品端维护key
     */
    public static final String PRODUCT_MAINTEN_CONFIG = "PRODUCT_MAINTEN_CONFIG";


    /**
     * 充值渠道缓存(普通充值)
     */
    public static final String PAYMENT_MERCHANT_APP_NORMAL_CACHE = "PAYMENT_MERCHANT_APP_NORMAL_CACHE_";

    /**
     * 充值渠道缓存(大额充值)
     */
    public static final String PAYMENT_MERCHANT_APP_LARGE_CACHE = "PAYMENT_MERCHANT_APP_LARGE_CACHE_";

    /**
     * 普通充值快捷金额
     */
    public static final String PAYMENT_NORMAL_FAST_AMOUNT = "PAYMENT_NORMAL_FAST_AMOUNT";

    /**
     * 大额充值快捷金额
     */
    public static final String PAYMENT_LARGE_FAST_AMOUNT = "PAYMENT_LARGE_FAST_AMOUNT";

    /**
     * 商户实时数据缓存
     */
    public static final String PAYMENT_MERCHANT_ACCOUNT_CACHE = "PAYMENT_MERCHANT_ACCOUNT_CACHE_";

    /**
     * 用户充值失败队列
     */
    public static final String PAYMENT_MERCHANT_APP_FAIL_LIST = "PAYMENT_MERCHANT_APP_FAIL_LIST_";

    /**
     * 用户充值成功队列
     */
    public static final String PAYMENT_MERCHANT_APP_SUCCESS_LIST = "PAYMENT_MERCHANT_APP_SUCCESS_LIST_";

    /**
     * 用户充值锁
     */
    public static final String BALLBET_RECHARGE_USER_LOCK = "BALLBET_RECHARGE_USER_LOCK_";

    /**
     * 信件上次获取时间
     */
    public static final String LETTER_UNSEND_LAST_TIME = "LETTER_UNSEND_LAST_TIME_";

    /**
     * 提现理由拒绝key
     */
    public static final String WITHDRAW_REASON_REJECTION = "WITHDRAW_REASON_REJECTION";

    /**
     * 热门赛事
     */
    public static final String ODDS_HOT_LIST = "ODDS_HOT_LIST";

    /**
     * 推荐赛事
     */
    public static final String ODDS_REC_LIST = "ODDS_REC_LIST";

    /**
     * 充值通道显示开关控制
     */
    public static final String SHOW_MERCHANT_SETTING = "SHOW_MERCHANT_SETTING";

    /**
     * 用户验证银行卡失败次数
     */
    public static final String BANK_CARD_VOILENT_REFRESH_COUNT = "BANK_CARD_VOILENT_REFRESH_COUNT_";

    /**
     * game第三方ACCESS_TOKEN
     */
    public static final String THIRD_ACCESS_TOKEN = "THIRD_ACCESS_TOKEN";

    public static final String LDTIGER_DOMAIN = "LDTIGER_DOMAIN";


    /**
     * VIP 会员等级缓存
     */
    public static final String VIP_MEMBER_LEVEL_CATCH = "VIP_MEMBER_LEVEL_CATCH_";

    /**
     * VIP 会员等级配置
     */
    public static final String VIP_MEMBER_LEVEL_CONFIG = "VIP_MEMBER_LEVEL_CONFIG";

    /**
     * VIP 会员等级奖励配置
     */
    public static final String VIP_MEMBER_LEVEL_AWARD_CONFIG = "VIP_MEMBER_LEVEL_AWARD_CONFIG";

    /**
     * VIP 会员等级返水配置
     */
    public static final String VIP_MEMBER_LEVEL_REBATE_CONFIG = "VIP_MEMBER_LEVEL_REBATE_CONFIG";

    /**
     * 端午节活动商品库存
     */
    public static final String ZONGZI_GOODS_NUM = "ZONGZI_GOODS_NUM_";

    /**
     * 端午节活动手气王redis
     */
    public static final String ZONGZI_LIST_OF_KING = "ZONGZI_LIST_OF_KING";

    /**
     * 端午节活动banner图点击次数
     */
    public static final String ZONGZI_COUNT_BANNER_NUM = "ZONGZI_COUNT_BANNER_NUM";

    /**
     * 同IP注册按钮限制
     */
    public static final String SAME_IP_REGISTER_ONOFF = "SAME_IP_REGISTER_ONOFF";

    /**
     * 同IP注册限制 分钟数
     */
    public static final String SAME_IP_REGISTER_MINUTES = "SAME_IP_REGISTER_MINUTES";

    /**
     * 同IP注册限制 分钟限制注册数量
     */
    public static final String SAME_IP_REGISTER_MINUTES_COUNT = "SAME_IP_REGISTER_MINUTES_COUNT";

    /**
     * 同IP注册限制 每天限制注册数量
     */
    public static final String SAME_IP_REGISTER_DAY_COUNT = "SAME_IP_REGISTER_DAY_COUNT";

    /**
     * 美洲杯活动有效投注额虚假值
     */
    public static final String AMERICAS_CUP_FAKE_NUM = "AMERICAS_CUP_FAKE_NUM";

    /**
     * 美洲杯活动有效投注额真实值
     */
    public static final String AMERICAS_CUP_NUM = "AMERICAS_CUP_NUM";


    /**
     * 用户的提现流水
     */
    public static final String GL_FUND_USER_ACCOUNT_BET_ = "GL_FUND_USER_ACCOUNT_BET_";

    /**
     * 充值Job-成功上分订单
     */
    public static final String GL_RECHARGE_SUCCESS_QUERY_ORDER_ = "GL_RECHARGE_SUCCESS_QUERY_JOB_";

    
    /**
     * 用户的提现流水
     */
    public static final String GAME_BALANCE_CHECK = "GAME_BALANCE_CHECK";

    /**
     * 充值补单-查询商户订单状态
     */
    public static String RECHARGE_MERCHANT_ORDER_STATUS_ = "RECHARGE_MERCHANT_ORDER_STATUS_";

}

package com.max.core.result;

import com.max.core.constant.UserConstant;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    FAIL_FORMATTER(501, "{}"),
    SUCCESS(1, "SUCCESS"),//成功
    FAIL(400, "访问失败"),//失败
    ARGS_FAIL(401, "访问失败(参数错误)"),//失败
    UNAUTHORIZED(401, "签名错误"),//未认证（签名错误）
    TOEKNUNVALIBLE(405, "登录失效"),//未认证（token错误）
    KICKED_OUT(505, "用户被踢出"),//用户被踢出
    NOT_FOUND(404, "此接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500, "系统繁忙,请稍后再试"),//服务器内部错误
    INVALID_PARAM(10000, "参数错误"),
    USER_NAME_EXIST(20001, "用户名已存在"),
    VALIDATAE_CODE_ERROR(20002, "获取验证码失败"),
    PHONE_VALIDATAE_CODE_SENDED(20002, "验证码已发送到手机，请"+ UserConstant.VALIDATE_REDIS_KEEP_TIME +"秒后重试"),
    VALIDATAE_CODE_EXPIRED(20002, "验证码已过期"),
    USER_NAME_NOT_EXIST(20003, "用户名不存在"),
    PASSWOWRD_WRONG(20004, "用户密码错误"),
    LOGIN_NO_USER(20004, "用户名密码不匹配，请核对用户名和密码"),
    LOGIN_NO_USER_BY_PHONE(20004, "该手机号未注册，请注册后再登录"),
    USER_NAME_ERROR(20005, "用户名不符合要求"),
    INVITE_CODE_NOT_EXIST(20006, "邀请码不存在"),
    MOBILE_EXIST(20007, "手机号码已存在"),
    EMAIL_EXIST(20008, "邮箱已存在"),
    EMAIL_NOT_EXIST(200018, "邮箱不存在"),
    AWARD_NOT_EXIST(200018, "暂时没有活动奖品，加油哦"),
    TOKEN_UNAVAILABLE(20009, "登录失效"),
    TRANSFER_UNAVAILABLE(20010, "您的账号无平台转账权限"),
    TRANSFER_COUNT_MAX(20011, "转账次数已用完"),
    TRANSFER_PLATFORM_NOT_ENOUGH_LEFT(20012, "平台余额不足"),
    TRANSFER_GAME_NOT_ENOUGH_LEFT(20013, "游戏余额不足"),
    TRANSFER_AMOUNT_LOCK(20014, "资金已锁定，请先资金解锁"),
    TRANSFER_ERROR(20015, "转账失败"),
    NOT_ENGOUH_BALANCE(20016, "余额不足"),
    NO_WALLET_PASSWD(20016, "请设置支付密码"),
    NO_USER_BANK(20016, "请绑定提现银行卡"),
    INVALID_USERNAME(20017, "无效的用户名"),
    CARD_VALIDATE_ERROR(20020, "银行卡校验错误"),
    CARD_VALIDATEEXCEED_ERROR(20021, "银行卡验证次数超限"),
    NAME_VALIDATE_ERROR(20028, "银行卡姓名不匹配"),
    CARD_EXIST_ERROR(20029, "银行卡已存在"),

    MOBILE_NOT_EXIST(200021,"手机号码不存在"),
    INVALID_SMS_CODE(200022,"验证码错误"),
    SENDED_SMS_CODE(200023,"验证码已发送"),
    ERR_SMS_CODE(200023,"验证码暂时无法获取，请稍后重试"),
    RECHARGE_CHANNEL_CLOSED(200024,"充值渠道已关闭"),
    IMG_CODE_ERROR(200025,"图片验证码错误"),
    GAME_CODE_XJ_ERROR(200026,"请求数据时间出错"),
    GAME_CODE_FETCHDATA_ERROR(200027,"定时任务出错"),
    TRANSFER_GAME_NOT_ENOUGH_LEFT_MONEY(20028,"游戏可下分余额不足"),
    APP_TYPE_ERROR(20029,"APP类型不能为空"),
    PASSWOWRD_SAME_WRONG(20030,"新密码不能和旧密码一致"),
    WITHDRAW_UNAVAILABLE(20031,"您的账号无平台提现权限"),
    WITHDRAW_COUNT_MAX(20032,"下分次数已用完"),
    TRANSFER_SPORTS_ERROR(20033,"下分失败"),
    TRANSFER_AMOUNT_ERROR(20034,"转出钱包金额不足"),
    WITHDRAW_LIMIT(20034,"未满足提现条件"),
    MOBILE_ERROR(20035,"手机号格式错误"),
    RECHARGE_AMOUNT_ERROR(20036, "充值金额异常");
    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

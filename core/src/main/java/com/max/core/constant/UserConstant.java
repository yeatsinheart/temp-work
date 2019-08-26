package com.max.core.constant;

/**
 * 用户常量
 *
 * @author leolee
 */
public interface UserConstant {

    String TOKEN = "token"; // 用户token
    String UID = "uid"; // 用户ID
    String USER_ID = "userId"; // 用户ID
    String IP = "ip"; // 用户ip
    Integer USER_REDIS_KEEP_TIME=60*10;
    Integer VALIDATE_REDIS_KEEP_TIME=60;
    final class Status {
        public final static int NEW = -1;// 上级创建，必须修改密码
        public final static int NORMAL = 0;// 正常状态
        public final static int LOCKED = 1;// 完全锁定
        public final static int HALF_LOCKED = 2; //间接锁定
        public final static int LOGIN_LOCKED = 4; //登录锁定
        public final static int HALF_AND_LOGIN_LOCKED = 6; //间接锁定  AND  登录锁定
    }

    final class UserType {
        public final static int PLAYER = 0;// 会员
        public final static int PROXY = 1;// 代理
    }

    final class isFake {
        public final static String NO = "0";// 真实用户
        public final static String YES = "1";// 虚拟用户
    }

    /**
     * 操作人类型 1公司,2代理
     */
    final class OperatorType {
        public final static int COMPANY = 1;// 公司
        public final static int PROXY = 2;// 代理
    }

    final class DomainType {
        public final static int COMMON = 0;// 通用域名
        public final static int SPECIAL = 1;// 专属域名
    }

    enum UserOperateType {
        PROXY_CHANGE(UserOperateType.PROXY_CHANGE_OPTTYPE, "变更上级代理"),
        CONTACT_CHANGE(UserOperateType.CONTACT_CHANGE_OPTTYPE, "变更联系方式"),
        BANK_RESET(UserOperateType.BANK_RESET_OPTTYPE, "重置银行信息"),
        FULL_LOCK(UserOperateType.FULL_LOCK_OPTTYPE, "完全锁定"),
        FULL_LOCK_DELETE_TELEPHONE_NUMBER_AND_EMAIL(UserOperateType.FULL_LOCK_DELETE_TELEPHONE_NUMBER_AND_EMAIL_OPTTYPE,"完全锁定"),
        HALF_LOCK(UserOperateType.HALF_LOCK_OPTTYPE, "间接锁定"),
        LOGIN_LOCK(UserOperateType.LOGIN_LOCK_OPTTYPE, "登录锁定"),
        HALF_AND_LOGIN_LOCK(UserOperateType.HALF_AND_LOGIN_LOCK_OPTTYPE, "间接锁定,登录锁定"),
        UN_LOCK(UserOperateType.UN_LOCK_OPTTYPE, "解除锁定"),
        UN_LOGIN_LOCK(UserOperateType.UN_LOGIN_LOCK_OPTTYPE, "解除登录锁定"),
        COMMISSION_CHANGE(UserOperateType.COMMISSION_CHANGE_OPTTYPE, "修改代理返佣模式"),
        CARD_DELETE(UserOperateType.CARD_DELETE_OPTTYPE, "删除银行卡"),
        REMARK_CHANGE(UserOperateType.REMARK_CHANGE_OPTTYPE, "修改备注"),
        CREDIT_CHANGE(UserOperateType.CREDIT_CHANGE_OPTTYPE, "修改上分设置"),//修改代理上分设置
        CREDIT_CLEAR(UserOperateType.CREDIT_CLEAR_OPTTYPE, "上分清算-人工操作清算"),
        CREDIT_DEDUCTION_CLEAR(UserOperateType.CREDIT_CLEAR_DEDUCTION_OPTTYPE, "上分清算-账户余额清算"),
        CLEAN_FREEZE(UserOperateType.CLEAN_FREEZE_WITHDRAW, "流水清零"),
        CREDIT_PROXY_LEVEL_CHANGE(UserOperateType.CREDIT_PROXY_LEVEL_CHANGE_OPTTYPE, "修改配置下级上分设置"),//修改代理上分设置
        PROXY_FEE_RULE(UserOperateType.MODIFY_PROXY_FEE_RULE, "修改代理手续费规则"),
        PROXY_COMM_LINE(UserOperateType.MODIFY_PROXY_COMM_LINE, "修改代理佣金链规则"),
        LEVEL_MANUAL_CHANGE(UserOperateType.MANUAL_LEVEL_MODIFY, "手动层级变更"),

        RESET_PASSWORD(UserOperateType.RESET_PASSWORD_OPTTYPE, "找回密码"),
        UPDATE_PASSWORD(UserOperateType.UPDATE_PASSWORD_OPTTYPE, "修改密码"),
        UPDATE_RECHARGE(UserOperateType.UPDATE_RECHARGE_OPTTYPE, "修改充值限制"),
        UPDATE_TRANSFER(UserOperateType.UPDATE_TRANSFER_OPTTYPE, "修改转账限制"),
        LOCK_ACCOUNT(UserOperateType.LOCK_ACCOUNT_OPTTYPE, "锁定账号"),
        OPEN_WITHDRAW(UserOperateType.OPEN_WITHDRAW_OPTTYPE, "开启提现安全"),
        CLOSE_WITHDRAW(UserOperateType.CLOSE_WITHDRAW_OPTTYPE, "关闭提现安全"),

        EDIT_PROFILE(UserOperateType.EDIT_PROFILE_OPTTYPE, "编辑个人资料"),
        NEW_RECIPIENT_ADDRESS(UserOperateType.NEW_RECIPIENT_ADDRESS_OPTTYPE, "新建收货地址"),
        EDIT_RECIPIENT_ADDRESS(UserOperateType.EDIT_RECIPIENT_ADDRESS_OPTTYPE, "编辑收货地址"),
        DELETE_RECIPIENT_ADDRESS(UserOperateType.DELETE_RECIPIENT_ADDRESS_OPTTYPE, "删除收货地址"),
        BIND_MAILBOX(UserOperateType.BIND_MAILBOX_OPTTYPE, "绑定邮箱"),
        BIND_PHONE(UserOperateType.BIND_PHONE_OPTTYPE, "绑定手机"),
        BIND_BANK_CARD(UserOperateType.BIND_BANK_CARD_OPTTYPE, "绑定银行卡"),
        UNTIED_BANK_CARD(UserOperateType.UNTIED_BANK_CARD_OPTTYPE, "解绑银行卡"),
        RESET_PASSWORD_MOBILE(UserOperateType.RESET_PASSWORD_MOBILE_OPTTYPE, "手机找回-登录密码"),
        RESET_PASSWORD_EMAIL(UserOperateType.RESET_PASSWORD_EMAIL_OPTTYPE, "邮箱找回-登录密码"),


        //资金流水相关枚举
        BETTING_BALANCE_ADJUSTMENT(UserOperateType.BETTING_BALANCE_ADJUSTMENT_OPTTYPE, "调整流水"),
        BETTING_BALANCE_REMOVE(UserOperateType.BETTING_BALANCE_REMOVE_OPTTYPE, "清除流水"),
        BETTING_BALANCE_RECOVER(UserOperateType.BETTING_BALANCE_RECOVER_OPTTYPE, "恢复流水");

        private int optType;
        private String desc;

        private UserOperateType(int optType, String desc) {
            this.optType = optType;
            this.desc = desc;
        }

        public int getOptType() {
            return optType;
        }

        public String getDesc() {
            return desc;
        }

        public static final int PROXY_CHANGE_OPTTYPE = 1;
        public static final int CONTACT_CHANGE_OPTTYPE = 2;
        public static final int BANK_RESET_OPTTYPE = 3;
        public static final int FULL_LOCK_OPTTYPE = 4;
        public static final int HALF_LOCK_OPTTYPE = 5;
        public static final int UN_LOCK_OPTTYPE = 6;
        public static final int COMMISSION_CHANGE_OPTTYPE = 7;
        public static final int CARD_DELETE_OPTTYPE = 8;
        public static final int REMARK_CHANGE_OPTTYPE = 9;
        public static final int CREDIT_CHANGE_OPTTYPE = 10;
        public static final int CREDIT_CLEAR_OPTTYPE = 11;
        public static final int CLEAN_FREEZE_WITHDRAW = 12;
        public static final int CREDIT_PROXY_LEVEL_CHANGE_OPTTYPE = 13;
        public static final int MODIFY_PROXY_FEE_RULE = 14;
        public static final int MODIFY_PROXY_COMM_LINE = 15;
        public static final int MANUAL_LEVEL_MODIFY = 16;
        public static final int LOGIN_LOCK_OPTTYPE = 17;
        public static final int HALF_AND_LOGIN_LOCK_OPTTYPE = 18;
        public static final int UN_LOGIN_LOCK_OPTTYPE = 19;
        public static final int CREDIT_CLEAR_DEDUCTION_OPTTYPE = 20;
        public static final int FULL_LOCK_DELETE_TELEPHONE_NUMBER_AND_EMAIL_OPTTYPE = 21;

        public static final int RESET_PASSWORD_OPTTYPE = 101;
        public static final int UPDATE_PASSWORD_OPTTYPE = 102;
        public static final int UPDATE_RECHARGE_OPTTYPE = 103;
        public static final int UPDATE_TRANSFER_OPTTYPE = 104;
        public static final int LOCK_ACCOUNT_OPTTYPE = 105;
        public static final int OPEN_WITHDRAW_OPTTYPE = 106;
        public static final int CLOSE_WITHDRAW_OPTTYPE = 107;

        //以下是资金流水审核的内容
        public static final int BETTING_BALANCE_ADJUSTMENT_OPTTYPE = 108;
        public static final int BETTING_BALANCE_REMOVE_OPTTYPE = 109;
        public static final int BETTING_BALANCE_RECOVER_OPTTYPE = 110;

        public static final int EDIT_PROFILE_OPTTYPE = 111;
        public static final int NEW_RECIPIENT_ADDRESS_OPTTYPE = 112;
        public static final int EDIT_RECIPIENT_ADDRESS_OPTTYPE = 113;
        public static final int DELETE_RECIPIENT_ADDRESS_OPTTYPE = 114;
        public static final int BIND_MAILBOX_OPTTYPE = 115;
        public static final int BIND_PHONE_OPTTYPE = 116;
        public static final int BIND_BANK_CARD_OPTTYPE = 117;
        public static final int UNTIED_BANK_CARD_OPTTYPE = 118;
        public static final int RESET_PASSWORD_MOBILE_OPTTYPE = 119;
        public static final int RESET_PASSWORD_EMAIL_OPTTYPE = 120;
    }
}

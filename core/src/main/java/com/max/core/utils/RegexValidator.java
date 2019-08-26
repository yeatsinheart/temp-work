package com.max.core.utils;

import java.util.regex.Pattern;

/**
 * 校验器：利用正则表达式校验邮箱、手机号等
 * <p>
 * Created by ken on 2018/4/8.
 */
public class RegexValidator {

    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z0-9]{6,16}$";

    /**
     * 正则表达式：验证后台用户名
     */
    public static final String REGEX_ADMINNAME = "^[a-zA-Z0-9]{3,16}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{8,20}$";
    /**
     * 正则表达式：校验密码至少为字母，数字，符号两种组成，不包含空格中文
     */
    public static final String REGEX_MIXTURE_PASSWORD = "(?!^\\d+$)(?!^[A-Za-z]+$)(?!^[^A-Za-z0-9]+$)(?!^.*[\\u4E00-\\u9FA5].*$)^\\S{8,20}$";
    /**
     * 正则表达式：强验证密码
     */
    public static final String REGEX_STRONG_PASSWORD = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![`~!@#$%^&*()+=|{}':;',\\[\\].<>/?]+$)[\\da-zA-Z`~!@#$%^&*()+=|{}':;',\\[\\].<>/?]{8,20}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[1,2,3,5,6,7,8])|(18[0-9])|(19[1|8|9]))\\d{8}$";

    /**
     * 正则表达式：验证银行卡号
     */
    public static final String REGEX_BANKCARD = "^\\d{16}|\\d{17}|\\d{18}|\\d{19}$";

    /**
     * 正则表达式：简单验证国际手机号
     */
    public static final String REGEX_MOBILE_I18N = "^\\d{7,11}";

    /**
     * 正则表达式：简单验证国际电话区号
     */
    public static final String REGEX_MOBILE_AREACODE = "^\\d{1,4}";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" + "|(18[0-9])|(19[8,9]))\\d{8}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\\u4e00-\\u9fa5]+$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})(\\.(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})){3}";

    /**
     * 正则表达式：验证IP前三段
     */
    public static final String REGEX_IP_ADDR_IGNORRE_LAST = "(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})(\\.(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})){2}";


    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isAdminName(String username) {
        return Pattern.matches(REGEX_ADMINNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验密码至少为数字，字母，下划线的组合
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMixturePassword(String password) {
        return Pattern.matches(REGEX_MIXTURE_PASSWORD, password);
    }

    /**
     * 校验密码(强校验)
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isStrongPassword(String password) {
        return Pattern.matches(REGEX_STRONG_PASSWORD, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验银行卡号
     *
     * @param bankCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isBankCard(String bankCard) {
        return Pattern.matches(REGEX_BANKCARD, bankCard);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }

    /**
     * 校验IP前三段地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddrIgnoreLast(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR_IGNORRE_LAST, ipAddr);
    }
}

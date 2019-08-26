package com.max.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringEncryptor {

    private static final String upperCaseChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encryptMobile(String mobile) {
        if (StringUtils.isEmpty(mobile) || mobile.length() <= 7) {
            return mobile;
        }
        return simpleEncrypt(mobile, 3, 7);
    }

    public static String encryptBankCard(String cardNo) {
        return simpleEncrypt(cardNo, 4, cardNo.length()-4);
    }

    public static String encryptEmail(String email) {
        if (StringUtils.isEmpty(email) || email.length() <= 3 || !email.contains("@")) {
            return email;
        }
        int end = email.indexOf("@");
        return simpleEncrypt(email, 3, end);
    }
    public static String encryptUsername(String username){
        String realname1 =null;
        char[] r =  username.toCharArray();
        if(r.length ==1){
            realname1 =  username;
        }
        if(r.length == 2){
            realname1 =  username.replaceFirst(username.substring(1),"*");
        }
        if (r.length > 2) {
            realname1 =  username.replaceFirst(username.substring(1,r.length-1) ,"*");
        }
        return realname1;
    }

    public static String simpleEncrypt(String str, int from, int end) {
        int len = str.length();
        if (len <= from) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, from));
        if (len <= end) {
            for (int i = 0; i < len - from; i++) {
                sb.append("*");
            }
        } else {
            for (int i = 0; i < end - from; i++) {
                sb.append("*");
            }
            sb.append(str.substring(end, str.length()));
        }
        return sb.toString();
    }

    public static String simpleEncrypt(String str, int from) {
        return simpleEncrypt(str, from, str.length());
    }

    /**
     * 将数字转换成大写字符串
     *
     * @param num
     * @param len
     * @return
     */
    public static String numToUpperString(long num, int len) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, upperCaseChar.charAt((int) (num % upperCaseChar.length())));
            num = num / upperCaseChar.length();
        }
        if (sb.length() > len) {
            return sb.substring(0, len);
        }
        int length = sb.length();
        for (int i = 0; i < len - length; i++) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    public static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder("|");
        if (null != list && !list.isEmpty()) {
            for (Integer obj : list) {
                sb.append(obj.toString()).append("|");
            }
        }
        return sb.toString();
    }

    public static List<Integer> strToIntList(String str) {
        if (StringUtils.isEmpty(str) || "|".equals(str.trim())) {
            return null;
        }
        String[] strList = str.split("\\|");
        List<Integer> list = new ArrayList<>();
        for (String s : strList) {
            list.add(Integer.valueOf(s));
        }
        return list;
    }

    /**
     * 2位字母自增
     * @param args
     */
    public static void main(String[] args) {
            String a="bb";

        System.out.print(createNext(a));
//            for (int i=1;i<26*26+1;i++){
//                System.out.print((a+" ").toUpperCase());
//                a=createNext(a);
//                if (i%26==0){
//                    System.out.println();
//                }
//            }
        }

        public static String createNext(String string){
            char [] tempChar = string.toCharArray();
            for(int i =tempChar.length-1;i>=1;i--){
                if (tempChar[i]<'z' ){
                    tempChar[i]=(char)(tempChar[i]+1);
                    break;
                }else {
                    tempChar[i]='a';
                    tempChar[i-1]=(char)(tempChar[i-1]+1);
                    if (tempChar[i-1]<='z'){
                        i=0;
                    }
                }
            }
            return String.valueOf(tempChar);
        }
    public String getTelnum(String sParam){

        if(sParam.length()<=0)
            return "";
        Pattern pattern = Pattern.compile("(1|861)(3|5|8)\\d{9}$*");
        Matcher matcher = pattern.matcher(sParam);
        StringBuffer bf = new StringBuffer();
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        return bf.toString();
    }

    /**
     * emoji 表情过滤
     * @author Chaims
     * @date 2019/4/2 17:41
     * @param source ;
     * @return java.lang.String
     */
    public static String filterEmoji(String source) {
        if(StringUtils.isNotBlank(source)){
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
        }else{
            return source;
        }
    }

    /**
     * 数字转换成 大写中文
     * @param intInput
     * @return
     */
    public static String toCH(int intInput) {
        String si = String.valueOf(intInput);
        String sd = "";
        if (si.length() == 1) {
            sd += GetCH(intInput);
            return sd;
        } else if (si.length() == 2) {
            if (si.substring(0, 1).equals("1")) {
                sd += "十";
            } else {
                sd += (GetCH(intInput / 10) + "十");
            }
            sd += toCH(intInput % 10);
        } else if (si.length() == 3) {
            sd += (GetCH(intInput / 100) + "百");
            if (String.valueOf(intInput % 100).length() < 2) {
                sd += "零";
            }
            sd += toCH(intInput % 100);
        }
        return sd;
    }

    private static String GetCH(int input) {
        String sd = "";
        switch (input) {
            case 1:
                sd = "一";
                break;
            case 2:
                sd = "二";
                break;
            case 3:
                sd = "三";
                break;
            case 4:
                sd = "四";
                break;
            case 5:
                sd = "五";
                break;
            case 6:
                sd = "六";
                break;
            case 7:
                sd = "七";
                break;
            case 8:
                sd = "八";
                break;
            case 9:
                sd = "九";
                break;
            default:
                break;
        }
        return sd;
    }

    /**
     * 获取ActivityGameTypeList
     * @param gameType
     * @return
     */
    public static List<Integer> getActivityGameTypeList(String gameType) {
        return Arrays.asList(gameType.replace("[","").replace("]","").split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}

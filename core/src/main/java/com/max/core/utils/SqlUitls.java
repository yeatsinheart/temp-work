package com.max.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by ken on 2018/6/11.
 */
public class SqlUitls {
    public static String listConvertString(List<Integer> list, String split) {
        StringBuilder sb = new StringBuilder();
        for (Integer item : list) {
            sb.append(item).append(split);//拼接字符串
        }
        String linkString = sb.toString();
        linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);//去除最后一个','

        return linkString;
    }
}

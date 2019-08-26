package com.max.core.utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by ken on 2018/3/15.
 */
public class EncodingTool {
    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

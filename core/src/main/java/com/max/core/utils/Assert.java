package com.max.core.utils;//package com.max.core.utils;
//
//import com.betball.core.exception.BusinessException;
//import com.betball.core.result.ResultCode;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//
//import java.util.Arrays;
//
///**
// * Created by wander on 2017/1/25.
// * updated by Stan， 因可变参数只能置后，错误信息统一放第一个参数
// */
//public abstract class Assert {
//
//    private final static Logger log = LoggerFactory.getLogger(Assert.class);
//
//    private Assert() {
//    }
//
//    public static void isTrue(String message, boolean expression) throws BusinessException{
//        if (!expression) {
//            throw new BusinessException(ResultCode.INVALID_PARAM.getCode(), message);
//        }
//    }
//
//    public static void isTrue(ResultCode errorCode, boolean expression) throws BusinessException {
//        if (!expression) {
//            throw new BusinessException(errorCode);
//        }
//    }
//
//    public static void isTrueParams(String message, boolean expression) throws BusinessException {
//        if (!expression) {
//            throw new BusinessException(ResultCode.INVALID_PARAM.getCode(), message,  HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    public static void isTrueParams(ResultCode errorCode, boolean expression) throws BusinessException {
//        if (!expression) {
//            throw new BusinessException(errorCode, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    public static void notNullOrBlank(String message, Object... args) throws BusinessException {
//        if(Arrays.stream(args).anyMatch(a -> {
//            if(a instanceof String){
//                return StringUtils.isBlank((String)a);
//            } else {
//                return a == null;
//            }
//         })){
//            throw new BusinessException(ResultCode.INVALID_PARAM.getCode(), message);
//        }
//    }
//
//    public static void notNullOrBlank(ResultCode errorCode, Object... args) throws BusinessException {
//        if(Arrays.stream(args).anyMatch(a -> {
//            if(a instanceof String){
//                return StringUtils.isBlank((String)a);
//            } else {
//                return a == null;
//            }
//        })){
//            throw new BusinessException(errorCode);
//        }
//    }
//
//    public static void notNullOrBlankParams(String message, Object... args) throws BusinessException {
//        if(Arrays.stream(args).anyMatch(a -> {
//            if(a instanceof String){
//                return StringUtils.isBlank((String)a);
//            } else {
//                return a == null;
//            }
//        })){
//            throw new BusinessException(ResultCode.INVALID_PARAM.getCode(), message, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    public static void notNullOrBlankParams(ResultCode errorCode, Object... args) throws BusinessException {
//        if(Arrays.stream(args).anyMatch(a -> {
//            if(a instanceof String){
//                return StringUtils.isBlank((String)a);
//            } else {
//                return a == null;
//            }
//        })){
//            throw new BusinessException(errorCode, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//    public static void notNull(String message, Object obj) throws BusinessException {
//        if(obj == null){
//            throw new BusinessException(ResultCode.INVALID_PARAM.getCode(), message);
//        }
//    }
//
//    public static void notNull(ResultCode errorCode, Object obj) throws BusinessException {
//        if(obj == null){
//            throw new BusinessException(errorCode);
//        }
//    }
//
//    public static void notBlank(String message, String param) throws BusinessException {
//        if(StringUtils.isBlank(param)){
//            throw new BusinessException(ResultCode.INVALID_PARAM.getCode(), message);
//        }
//    }
//
//    public static void notBlank(ResultCode errorCode, String param) throws BusinessException {
//        if(StringUtils.isBlank(param)){
//            throw new BusinessException(errorCode);
//        }
//    }
//
//    // ---------------------------------
//
//    @Deprecated
//    public static void isTrue(boolean expression, String message) throws BusinessException {
//        if (!expression) {
//            throw new BusinessException(ResultCode.INVALID_PARAM.getCode(), message);
//        }
//    }
//
//    @Deprecated
//    public static void isTrue(boolean expression) throws BusinessException {
//        isTrue(expression, "表达式必须为真");
//    }
//
//    @Deprecated
//    private static void notEmpty(Object object, String message) throws BusinessException {
//        if (object == null) {
//            throw new BusinessException(ResultCode.INVALID_PARAM.getCode(), message);
//        }
//    }
//
//    @Deprecated
//    public static void notEmpty(Object... args) throws BusinessException {
//        for (int i = 0; i < args.length; i++) {
//            notEmpty(args[i], args.length + "个参数，第" + (i + 1) + " 个参数为空！");
//            break;
//        }
//    }
//
//    @Deprecated
//    public static void state(boolean expression, String message) throws BusinessException {
//        if (!expression) {
//            throw new BusinessException(ResultCode.INVALID_PARAM.getCode(), message);
//        }
//    }
//
//    @Deprecated
//    public static void state(boolean expression) throws BusinessException {
//        state(expression, "状态不能为空");
//    }
//
//    public static final String[] levels = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
//}

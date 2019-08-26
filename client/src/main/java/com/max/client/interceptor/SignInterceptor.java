package com.max.client.interceptor;

/**
 * Created by ken on 2018/9/4.
 */

import com.alibaba.fastjson.JSON;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

//import com.max.core.utils.HttpUtils;

@Slf4j
@Component
public class SignInterceptor extends HandlerInterceptorAdapter {

    /**
     * pre handle
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //接口签名认证拦截器，该签名认证比较简单，实际项目中可以使用Json Web Token或其他更好的方式替代。
        // if (!"dev".equals(env) && !"loc".equals(env)) { //开发环境忽略签名认证
        // if (!"loc".equals(env)) { //开发环境忽略签名认证
        String requestURI = request.getRequestURI();
//        log.info("sign interceptor requestURI:{}.", requestURI);
        if (validateSign(request)) {
            return true;
        }
        log.warn("签名认证失败，请求接口：{}，请求IP：{}，请求参数：{}",
                request.getRequestURI(),
                //HttpUtils.getRequestIp(request),
                JSON.toJSONString(request.getParameterMap())
        );
        Result result = new Result();
        result.setCode(ResultCode.UNAUTHORIZED);
        responseResult(response, result);
        return false;
    }

    /**
     * 一个简单的签名认证，规则：
     * 1. 将请求参数按ascii码排序
     * 2. 拼接为a=value&b=value...这样的字符串（不包含sign）
     * 3. 混合密钥（secret）进行md5获得签名，与请求的签名进行比较
     */
    private boolean validateSign(HttpServletRequest request) {
        //获得请求签名，如sign=19e907700db7ad91318424a97c54ed57
        String requestSign = request.getHeader("sign");
        if (StringUtils.isEmpty(requestSign)) {
            return false;
        }
        LinkedHashMap<String, String> keys = new LinkedHashMap<>();
        //几个关键词用&拼接后  md5Hex
        keys.put("device_id", request.getHeader("device_id"));
        keys.put("os_type", request.getHeader("os_type"));
        keys.put("timestamp", request.getHeader("timestamp"));
        keys.put("version", request.getHeader("version"));


        StringBuilder sb = new StringBuilder();
        for (String key : keys.keySet()) {
            sb.append(key).append("=").append(keys.get(key)).append("&");//拼接字符串
        }
        String linkString = sb.toString();
        linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);//去除最后一个'&'

        String secret = "max";//密钥，自己修改

        String sign = DigestUtils.md5Hex(linkString + secret);//混合密钥md5

//        log.info("sign = " + sign);
        //比较 传入密钥是否与后台生成相同
        return StringUtils.equals(sign, requestSign);
    }

    /**
     * response result
     */
    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
}

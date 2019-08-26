package com.max.client.interceptor;

/**
 * Created by ken on 2018/9/4.
 */

import com.alibaba.fastjson.JSON;
import com.max.core.constant.UserConstant;
import com.max.core.redis.RedisService;
import com.max.core.redis.impl.RedisKeyHelper;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import com.max.core.utils.TokenValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Resource
    TokenValidateUtils tokenValidateUtils;
    @Resource
    private RedisService redisService;

    /**
     * pre handle
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
//        log.info("token interceptor requestURI:{}.", requestURI);

        // 验证token
        String token = request.getHeader(UserConstant.TOKEN);
        if (token == null) {
            token = request.getParameter(UserConstant.TOKEN);
        }
        String uid = request.getHeader(UserConstant.UID);
        if (uid == null) {
            uid = request.getParameter(UserConstant.UID);
        }
        String os_type = request.getHeader("os_type");

        if (os_type == null) {
            os_type = request.getParameter("os_type");
        }

        if (token != null && uid != null && validateToken(uid, os_type, token, requestURI)) {
            return true;
        }
        Result result = new Result();
        result.setCode(ResultCode.TOEKNUNVALIBLE);
        responseResult(response, result);
        return false;
    }

    /**
     * validate token
     *
     * @return boolean
     */
    private boolean validateToken(String uid, String os_type, String token, String requestURI) {

        return tokenValidateUtils.validationToken(uid, os_type, "0", token) || vlidateAdminToken(token, requestURI);
    }

    private boolean vlidateAdminToken(String token, String requestURI) {
        String redisKey = RedisKeyHelper.ADMIN_TOKEN + token;
        Integer uid = redisService.get(redisKey, Integer.class);
       /* if (null == uid || uid <= 0 || glAdminService.validTokenAccess(token, requestURI) == false) {
            return false;
        }*/
        redisService.setTTL(RedisKeyHelper.ADMIN_TOKEN + uid, 120);
        redisService.setTTL(redisKey, 120);

        return true;
    }

    /**
     * +     * response result
     * +
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

package com.max.client.controller;

import com.max.client.dto.LoginUserRequest;
import com.max.core.constant.UserConstant;
import com.max.core.redis.RedisService;
import com.max.core.redis.impl.RedisKeyHelper;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import com.max.core.result.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ValidateController {
    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "/login/code", tags = {"账号密码登录：网页验证码"})
    @PostMapping("/login/code")
    public Result login(LoginUserRequest login) {
        String code = "1234";
        redisService.set(RedisKeyHelper.USER_LOGIN_CODE + login.getName(), code, UserConstant.VALIDATE_REDIS_KEEP_TIME);
        return ResultGenerator.genSuccessResult(code);
    }

    @ApiOperation(value = "/login/phone/code", tags = {"手机短信登录：网页验证码"})
    @PostMapping("/login/phone/code")
    public Result loginphone(LoginUserRequest login, String code) {
        //网页验证码
        String pageCode = redisService.getResult(RedisKeyHelper.USER_LOGIN_CODE + login.getName(), String.class).getResult();
        if (StringUtils.isEmpty(pageCode)) {
            return ResultGenerator.genFailResult(ResultCode.VALIDATAE_CODE_EXPIRED);
        }
        //短信验证码
        if (StringUtils.isNotBlank(code) && code.equals(pageCode)) {
            String phoneCode = redisService.getResult(RedisKeyHelper.USER_PHONE_LOGIN_CODE + login.getName(), String.class).getResult();
            if (StringUtils.isNotBlank(phoneCode)) {
                return ResultGenerator.genFailResult(ResultCode.PHONE_VALIDATAE_CODE_SENDED);
            }
            String phone = "1234";
            redisService.set(RedisKeyHelper.USER_PHONE_LOGIN_CODE + login.getName(), phone, UserConstant.VALIDATE_REDIS_KEEP_TIME);
            return ResultGenerator.genSuccessResult(code);
        } else {
            return ResultGenerator.genFailResult(ResultCode.INVALID_SMS_CODE);
        }

    }


    @ApiOperation(value = "/signin/code", tags = {"账号注册：网页验证码"})
    @PostMapping("/signin/code")
    public Result signin(LoginUserRequest login) {
        String code = "1234";
        redisService.set(RedisKeyHelper.USER_SIGNIN_CODE + login.getName(), code, UserConstant.VALIDATE_REDIS_KEEP_TIME);
        return ResultGenerator.genSuccessResult(code);
    }

    @ApiOperation(value = "/signin/phone/code", tags = {"账号注册：短信验证码"})
    @PostMapping("/signin/phone/code")
    public Result signinphone(LoginUserRequest login, String code) {
        //网页验证码
        String pageCode = redisService.getResult(RedisKeyHelper.USER_SIGNIN_CODE + login.getName(), String.class).getResult();
        if (StringUtils.isEmpty(pageCode)) {
            return ResultGenerator.genFailResult(ResultCode.VALIDATAE_CODE_EXPIRED);
        }
        //短信验证码
        if (StringUtils.isNotBlank(code) && code.equals(pageCode)) {
            String phoneCode = redisService.getResult(RedisKeyHelper.USER_PHONE_SIGNIN_CODE + login.getName(), String.class).getResult();
            if (StringUtils.isNotBlank(phoneCode)) {
                return ResultGenerator.genFailResult(ResultCode.PHONE_VALIDATAE_CODE_SENDED);
            }
            String phone = "1234";
            redisService.set(RedisKeyHelper.USER_PHONE_SIGNIN_CODE + login.getName(), phone, UserConstant.VALIDATE_REDIS_KEEP_TIME);
            return ResultGenerator.genSuccessResult(code);
        }
        return ResultGenerator.genFailResult(ResultCode.INVALID_SMS_CODE);
    }
}

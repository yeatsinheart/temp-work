package com.max.client.controller;

import com.max.client.dto.LoginUserRequest;
import com.max.core.constant.UserConstant;
import com.max.core.redis.RedisService;
import com.max.core.redis.impl.RedisKeyHelper;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import com.max.core.result.ResultGenerator;
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

    @PostMapping("/login/validate")
    public Result login(LoginUserRequest login) {
        String code = "1234";
        redisService.set(RedisKeyHelper.USER_LOGIN_CODE + login.getName(), code, UserConstant.VALIDATE_REDIS_KEEP_TIME);
        return ResultGenerator.genSuccessResult(code);
    }

    @PostMapping("/login/phone/validate")
    public Result loginphone(LoginUserRequest login) {
        String loginCodeInRedis = redisService.getResult(RedisKeyHelper.USER_PHONE_LOGIN_CODE + login.getName(), String.class).getResult();
        if (StringUtils.isNotBlank(loginCodeInRedis)) {
            return ResultGenerator.genFailResult(ResultCode.PHONE_VALIDATAE_CODE_SENDED.getCode(), ResultCode.PHONE_VALIDATAE_CODE_SENDED.getMessage());
        }
        String code = "1234";
        redisService.set(RedisKeyHelper.USER_PHONE_LOGIN_CODE + login.getName(), code, UserConstant.VALIDATE_REDIS_KEEP_TIME);
        return ResultGenerator.genSuccessResult(code);
    }

    @PostMapping("/signin/validate")
    public Result signin(LoginUserRequest login) {
        String code = "1234";
        redisService.set(RedisKeyHelper.USER_SIGNIN_CODE + login.getName(), code, UserConstant.VALIDATE_REDIS_KEEP_TIME);
        return ResultGenerator.genSuccessResult(code);
    }

    @PostMapping("/signin/phone/validate")
    public Result signinphone(LoginUserRequest login) {
        String loginCodeInRedis = redisService.getResult(RedisKeyHelper.USER_PHONE_SIGNIN_CODE + login.getName(), String.class).getResult();
        if (StringUtils.isNotBlank(loginCodeInRedis)) {
            return ResultGenerator.genFailResult(ResultCode.PHONE_VALIDATAE_CODE_SENDED.getCode(), ResultCode.PHONE_VALIDATAE_CODE_SENDED.getMessage());
        }
        String code = "1234";
        redisService.set(RedisKeyHelper.USER_PHONE_SIGNIN_CODE + login.getName(), code, UserConstant.VALIDATE_REDIS_KEEP_TIME);
        return ResultGenerator.genSuccessResult(code);
    }
}

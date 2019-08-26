package com.max.client.controller;

import com.max.base.dto.UserDto;
import com.max.base.service.UserService;
import com.max.client.dto.LoginUserRequest;
import com.max.client.dto.SigninUserRequest;
import com.max.client.dto.UserResponse;
import com.max.core.constant.UserConstant;
import com.max.core.exception.ServiceException;
import com.max.core.redis.RedisResult;
import com.max.core.redis.RedisService;
import com.max.core.redis.impl.RedisKeyHelper;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import com.max.core.result.ResultGenerator;
import com.max.core.utils.RandomName;
import com.max.event.login.LoginEvent;
import com.max.event.signin.SigninEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserService userService;
    @Autowired
    private SigninEvent signinEvent;
    @Autowired
    private LoginEvent loginEvent;


    /*账号密码登录*/
    @ApiOperation(value = "/login", tags = {"账号密码登录"})
    @PostMapping("/login")
    public Result login(@RequestHeader(required = false) String token, @Validated LoginUserRequest login, String code) {
        RedisResult<UserDto> userInRedis = redisService.getResult(RedisKeyHelper.TOKEN_ONLINE + token, UserDto.class);
        UserDto userInDb = userInRedis.getResult();
        if (null == userInDb) {
            String loginCodeInRedis = redisService.getResult(RedisKeyHelper.USER_LOGIN_CODE + login.getName(), String.class).getResult();
            if (StringUtils.isEmpty(loginCodeInRedis)) {
                return ResultGenerator.genFailResult(ResultCode.VALIDATAE_CODE_EXPIRED.getCode(), ResultCode.VALIDATAE_CODE_EXPIRED.getMessage());
            }
            if (StringUtils.isNotBlank(code) && code.equals(loginCodeInRedis)) {
                UserDto request = login.getUserDto();
                /*用户名 或者 密码 错误*/
                userInDb = userService.login(request);
                if (null == userInDb) {
                    return ResultGenerator.genFailResult(ResultCode.LOGIN_NO_USER.getCode(), ResultCode.LOGIN_NO_USER.getMessage());
                }
                /*userInDb = new UserDto();
                userInDb.setId(new Random().nextInt(99999));
                userInDb.setNick(RandomName.getRandomJianHan(6));
                userInDb.setName(RandomStringUtils.random(11));*/
            } else {
                return ResultGenerator.genFailResult(ResultCode.INVALID_SMS_CODE.getCode(), ResultCode.INVALID_SMS_CODE.getMessage());
            }
        }
        loginEvent.handle(userInDb);
        return ResultGenerator.genSuccessResult(UserResponse.getResponse(userInDb));
    }

    /*手机号验证码登录*/
    @ApiOperation(value = "/phone/login", tags = {"手机号验证码登录"})
    @PostMapping("/phone/login")
    public Result loginPhone(@RequestHeader(required = false) String token, @Validated LoginUserRequest login, String code) {
        RedisResult<UserDto> userInRedis = redisService.getResult(RedisKeyHelper.TOKEN_ONLINE + token, UserDto.class);
        UserDto userInDb = userInRedis.getResult();
        if (null == userInDb) {
            String loginCodeInRedis = redisService.getResult(RedisKeyHelper.USER_PHONE_LOGIN_CODE + login.getName(), String.class).getResult();
            if (StringUtils.isEmpty(loginCodeInRedis)) {
                return ResultGenerator.genFailResult(ResultCode.VALIDATAE_CODE_EXPIRED.getCode(), ResultCode.VALIDATAE_CODE_EXPIRED.getMessage());
            }
            if (StringUtils.isNotBlank(code) && code.equals(loginCodeInRedis)) {
                UserDto request = login.getUserDto();
                userInDb = userService.login(request);
                if (null == userInDb) {
                    return ResultGenerator.genFailResult(ResultCode.LOGIN_NO_USER_BY_PHONE.getCode(), ResultCode.LOGIN_NO_USER_BY_PHONE.getMessage());
                }
            } else {
                return ResultGenerator.genFailResult(ResultCode.INVALID_SMS_CODE.getCode(), ResultCode.INVALID_SMS_CODE.getMessage());
            }
        }
        loginEvent.handle(userInDb);
        return ResultGenerator.genSuccessResult(UserResponse.getResponse(userInDb));
    }
    @ApiOperation(value = "/heart", tags = {"心跳检测"})
    @PostMapping("/heart")
    public Result heart(@RequestHeader(required = false) String token) throws ServiceException {
        //当前
        if (StringUtils.isEmpty(token)) {
            return ResultGenerator.genSuccessResult();
        } else {
            RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
            if (null == loginedUser.getResult()) {
                return ResultGenerator.genFailResult(ResultCode.KICKED_OUT.getCode(), ResultCode.KICKED_OUT.getMessage());
            }
            //增加缓存时间
            redisService.setTTL(loginedUser.getResult().getToken(), UserConstant.USER_REDIS_KEEP_TIME);
            redisService.setTTL(loginedUser.getResult().getName(), UserConstant.USER_REDIS_KEEP_TIME);
            return ResultGenerator.genSuccessResult();
        }

    }
    @ApiOperation(value = "/signin", tags = {"注册"})
    @PostMapping("/signin")
    public Result signin(SigninUserRequest signinUserRequest, String code) throws ServiceException {
        String signinCodeInRedis = redisService.getResult(RedisKeyHelper.USER_SIGNIN_CODE + signinUserRequest.getName(), String.class).getResult();
        if (StringUtils.isEmpty(signinCodeInRedis)) {
            return ResultGenerator.genFailResult(ResultCode.VALIDATAE_CODE_EXPIRED.getCode(), ResultCode.VALIDATAE_CODE_EXPIRED.getMessage());
        }
        if (StringUtils.isNotBlank(code) && code.equals(signinCodeInRedis)) {
            UserDto request = signinUserRequest.getUserDto();
            UserDto userInDb = userService.signin(request);
            if (null == userInDb) {
                return ResultGenerator.genFailResult(ResultCode.USER_NAME_EXIST.getCode(), ResultCode.USER_NAME_EXIST.getMessage());
            }
            signinEvent.handle(userInDb);
            return ResultGenerator.genSuccessResult(UserResponse.getResponse(userInDb));
        }
        return ResultGenerator.genFailResult(ResultCode.INVALID_SMS_CODE.getCode(), ResultCode.INVALID_SMS_CODE.getMessage());
    }
}

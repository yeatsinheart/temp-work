package com.max.client.controller;

import com.max.base.dto.UserDto;
import com.max.base.service.UserService;
import com.max.client.dto.LoginUserRequest;
import com.max.client.dto.SigninUserRequest;
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
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "/login", tags = {"账号密码登录"})
    @PostMapping("/login")
    public Result login(@RequestHeader(required = false) String token, @Validated LoginUserRequest login, String code) {
        RedisResult<UserDto> userInRedis = redisService.getResult(RedisKeyHelper.TOKEN_ONLINE + token, UserDto.class);
        UserDto userInDb = userInRedis.getResult();
        if (null == userInDb) {
            String loginCodeInRedis = redisService.getResult(RedisKeyHelper.USER_LOGIN_CODE + login.getName(), String.class).getResult();
            if (StringUtils.isEmpty(loginCodeInRedis)) {
                return ResultGenerator.genFailResult(ResultCode.VALIDATAE_CODE_EXPIRED);
            }
            if (StringUtils.isNotBlank(code) && code.equals(loginCodeInRedis)) {
                /*用户名 或者 密码 错误*/
                UserDto loginRequest = new UserDto();
                loginRequest.setName(login.getName());
                loginRequest.setPasswd(login.getPasswd());
                userInDb = userService.login(loginRequest);
                if (null == userInDb) {
                    return ResultGenerator.genFailResult(ResultCode.LOGIN_NO_USER);
                }
            } else {
                return ResultGenerator.genFailResult(ResultCode.INVALID_SMS_CODE);
            }
        }
        loginEvent.handle(userInDb);
        return ResultGenerator.genSuccessResult(userInDb);
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
                return ResultGenerator.genFailResult(ResultCode.VALIDATAE_CODE_EXPIRED);
            }
            if (StringUtils.isNotBlank(code) && code.equals(loginCodeInRedis)) {
                UserDto request = login.getUserDto();
                userInDb = userService.login(request);
                if (null == userInDb) {
                    return ResultGenerator.genFailResult(ResultCode.LOGIN_NO_USER_BY_PHONE);
                }
            } else {
                return ResultGenerator.genFailResult(ResultCode.INVALID_SMS_CODE);
            }
        }
        loginEvent.handle(userInDb);
        return ResultGenerator.genSuccessResult(userInDb);
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
                return ResultGenerator.genFailResult(ResultCode.KICKED_OUT);
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
        //获取已发送的手机验证码
        String signinCodeInRedis = redisService.getResult(RedisKeyHelper.USER_PHONE_SIGNIN_CODE + signinUserRequest.getName(), String.class).getResult();
        if (StringUtils.isEmpty(signinCodeInRedis)) {
            return ResultGenerator.genFailResult(ResultCode.VALIDATAE_CODE_EXPIRED);
        }
        //手机验证码正确
        if (StringUtils.isNotBlank(code) && code.equals(signinCodeInRedis)) {
            UserDto request = new UserDto();
            request.setName(signinUserRequest.getName());
            request.setPasswd(signinUserRequest.getPasswd());
            request.setNick(RandomName.randomName(false,4));
            UserDto userInDb = userService.signin(request);
            if (null == userInDb) {
                return ResultGenerator.genFailResult(ResultCode.USER_NAME_EXIST);
            }
            signinEvent.handle(userInDb);
            return ResultGenerator.genSuccessResult(userInDb);
        }
        return ResultGenerator.genFailResult(ResultCode.INVALID_SMS_CODE);
    }
}

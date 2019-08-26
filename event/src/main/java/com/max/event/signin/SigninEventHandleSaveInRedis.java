package com.max.event.signin;

import com.max.base.dto.UserDto;
import com.max.core.constant.UserConstant;
import com.max.core.redis.RedisService;
import com.max.core.redis.impl.RedisKeyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SigninEventHandleSaveInRedis implements SigninEventHandle{
    @Autowired
    private RedisService redisService;
    public void handle(UserDto user){
        redisService.set(RedisKeyHelper.TOKEN_ONLINE + user.getToken(), user, UserConstant.USER_REDIS_KEEP_TIME);
        redisService.set(RedisKeyHelper.USER_ONLINE + user.getId().toString(), user, UserConstant.USER_REDIS_KEEP_TIME);
    }
}

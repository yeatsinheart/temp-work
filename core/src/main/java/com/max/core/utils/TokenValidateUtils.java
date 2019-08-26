package com.max.core.utils;

import com.max.core.redis.RedisService;
import com.max.core.redis.impl.RedisKeyHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ken on 2018/3/16.
 */
@Slf4j
@Component("tokenValidateUtils")
public class TokenValidateUtils {
    @Resource
    private RedisService redisService;

    private final static String LOGIN_KEY = "max2019#";

    public boolean validationToken(String uid, String clientType, String appType, String token) {
        String deToken = null;
        try {
            deToken = DESEncrypt.decrypt(token, LOGIN_KEY);
        } catch (Exception e) {
            deToken = token;
        }
        String tokenKey = RedisKeyHelper.REQ_TOKEN + clientType + "_" + appType + "_" + uid;
        String uidKey = RedisKeyHelper.REQ_LOGIN + deToken;
        String redisToken = redisService.get(tokenKey);
        String redisUid = redisService.get(uidKey);
        if (redisToken != null && redisToken.equals(deToken) && redisUid != null && redisUid.equals(uid)) {
            redisService.setTTL(tokenKey, 1800);
            redisService.setTTL(uidKey, 1800);
            return true;
        } else {
            return false;
        }
    }

    public String createUserToken(Integer userId, Integer clientType, Integer appType) {
        String token = clientType + "_" + ProjectTokenUtils.genToken();
        String tokenKey = RedisKeyHelper.REQ_TOKEN + clientType + "_" + appType + "_" + userId;
        String uidKey = RedisKeyHelper.REQ_LOGIN + token;
        redisService.set(tokenKey, token, 1800);
        redisService.set(uidKey, userId, 1800);
        try {
            token = DESEncrypt.encrypt(token, LOGIN_KEY);
        } catch (Exception e) {
            log.warn("token encrypt error");
        }
        return token;
    }

    public String getUserToken(Integer userId, Integer clientType, Integer appType) {
        String tokenKey = RedisKeyHelper.REQ_TOKEN + clientType + "_" + appType + "_" + userId;
        return redisService.get(tokenKey);
    }

    public String getEncyptedUserToken(Integer userId, Integer clientType, Integer appType) {
        try {
            return DESEncrypt.encrypt(getUserToken(userId, clientType, appType), LOGIN_KEY);
        } catch (Exception e) {
            log.warn("token encrypt error");
        }
        return null;
    }

    public Integer getUserIdByToken(String token) {
        String deToken = null;
        try {
            deToken = DESEncrypt.decrypt(token, LOGIN_KEY);
        } catch (Exception e) {
            log.warn("token decrypt error");
            deToken = token;
        }

        String uidKey = RedisKeyHelper.REQ_LOGIN + deToken;

        return redisService.get(uidKey, Integer.class);
    }

    public void addKickedToken(String oldToken, String kickedIp, Date kickedTime) {
        UserKickedInfo kicked = new UserKickedInfo();
        kicked.setKickedIp(kickedIp);
        kicked.setKickedTime(kickedTime);
        redisService.set(RedisKeyHelper.KICKED_TOKEN + oldToken, kicked, 180);
    }

    public UserKickedInfo getKickedInfo(String token) {
        String deToken = null;
        try {
            deToken = DESEncrypt.decrypt(token, LOGIN_KEY);
        } catch (Exception e) {
            log.warn("token decrypt error");
            deToken = token;
        }
        return redisService.get(RedisKeyHelper.KICKED_TOKEN + deToken, UserKickedInfo.class);
    }

}

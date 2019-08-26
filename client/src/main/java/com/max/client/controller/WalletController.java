package com.max.client.controller;


import com.max.base.dto.BankDto;
import com.max.base.dto.UserDto;
import com.max.base.service.UserService;
import com.max.business.service.UserBankService;
import com.max.client.utils.IpUtil;
import com.max.core.redis.RedisResult;
import com.max.core.redis.RedisService;
import com.max.core.redis.impl.RedisKeyHelper;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import com.max.core.result.ResultGenerator;
import com.max.money.dto.WalletLogRequest;
import com.max.money.service.WalletLogService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
    @Autowired
    private UserBankService userBankService;
    @Autowired
    private WalletLogService walletLogService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    /*绑定银行卡*/
    @ApiOperation(value = "/band", tags = {"绑定银行卡"})
    @PostMapping("/band")
    public Result band(@RequestHeader String token, BankDto bank) {
        //新建支付密码
        RedisResult<UserDto> userInRedis = redisService.getResult(RedisKeyHelper.TOKEN_ONLINE + token, UserDto.class);
        UserDto userInDb = userInRedis.getResult();
        if (null != userInDb) {
            if(StringUtils.isBlank(userInDb.getWithdrawPasswd())){
                return ResultGenerator.genFailResult(ResultCode.NO_WALLET_PASSWD);
            }
            boolean success = userBankService.addBank(bank);
            if (success) {
                return ResultGenerator.genSuccessResult(success);
            }
            return ResultGenerator.genFailResult(ResultCode.BIND_BANK_ERR);
        }
        return ResultGenerator.genFailResult(ResultCode.KICKED_OUT);
    }

    /*我的钱包*/
    @ApiOperation(value = "/wallet", tags = {"我的钱包：归并"})
    @PostMapping("/wallet")
    public Result wallet(@RequestHeader String token) {
        //查询各个游戏账户余额，并归集到钱包，所有都成功
        //查询钱包余额
        String ip = IpUtil.getIpAddr();
        return null;
    }

    /*我的余额*/
    @ApiOperation(value = "/money", tags = {"我的余额：不归并"})
    @PostMapping("/money")
    public Result money(@RequestHeader String token) {
        RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
        UserDto user = loginedUser.getResult();
         user = userService.getBalance(user);
        return ResultGenerator.genSuccessResult(user);
    }

    /*我的资金明细*/
    @ApiOperation(value = "/moneyhistory", tags = {"我的资金明细"})
    @PostMapping("/moneyhistory")
    public Result moneyhistory(WalletLogRequest walletLogRequest) {
        //查询钱包增减日志
       // walletLogService.pageLog(walletLogRequest);
        String ip = IpUtil.getIpAddr();
        return null;
    }

}

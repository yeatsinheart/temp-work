package com.max.client.controller;

import com.max.base.dto.UserDto;
import com.max.base.dto.UserWithdrawLimitDto;
import com.max.business.dto.UserBankDto;
import com.max.business.service.UserBankService;
import com.max.business.service.WithdrawLimitService;
import com.max.core.redis.RedisResult;
import com.max.core.redis.RedisService;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import com.max.core.result.ResultGenerator;
import com.max.money.dto.WalletSeriesDto;
import com.max.money.dto.WithdrawOrderDto;
import com.max.money.service.WalletOrderService;
import com.max.money.service.WalletSeriesService;
import com.max.money.service.WithdrawOrderService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private WalletOrderService walletOrderService;
    @Autowired
    private UserBankService userBankService;
    @Autowired
    private WithdrawLimitService withdrawLimitService;

    /*提现*/
    @ApiOperation(value = "/withdraw", tags = {"提现"})
    @PostMapping("/withdraw")
    public Result withdraw(@RequestHeader String token, WithdrawOrderDto withdrawOrder) {
        RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
        UserDto user = loginedUser.getResult();
        if (null == user) {
            return ResultGenerator.genFailResult(ResultCode.TOEKNUNVALIBLE);
        }
        //是否绑定密码
        if (StringUtils.isBlank(user.getPasswd())) {
            return ResultGenerator.genFailResult(ResultCode.NO_WALLET_PASSWD);
        }
        //是否绑定银行卡
        UserBankDto bankCard = userBankService.getCard(user);
        if (null == bankCard) {
            return ResultGenerator.genFailResult(ResultCode.NO_USER_BANK);
        }
        //新建钱包，如果有有则通过，无则创建  获取账户可用提现订单号
        //绑定银行卡 有则通过，无则提示创建银行卡
        //校验提现约束
        boolean pass = withdrawLimitService.passLimited(user);
        if (pass) {
            withdrawOrder.setUserId(user.getId());
            //扣钱生成提现订单
            WithdrawOrderDto withdrawOrderDto = walletOrderService.withdraw(withdrawOrder);
            return ResultGenerator.genSuccessResult(withdrawOrderDto);
        }
        return ResultGenerator.genFailResult(ResultCode.WITHDRAW_LIMIT);
    }

    /*提现 约束条件*/
    @ApiOperation(value = "/limit", tags = {"提现 约束条件"})
    @PostMapping("/limit")
    public Result limit(@RequestHeader String token) {
        RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
        UserDto user = loginedUser.getResult();
        if (null == user) {
            return ResultGenerator.genFailResult(ResultCode.TOEKNUNVALIBLE.getCode(), ResultCode.TOEKNUNVALIBLE.getMessage());
        }
        UserWithdrawLimitDto limit = withdrawLimitService.getLimit(user);
        return ResultGenerator.genSuccessResult(limit);
    }
}

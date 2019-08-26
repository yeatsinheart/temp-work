package com.max.client.controller;

import com.max.base.dto.UserDto;
import com.max.core.redis.RedisResult;
import com.max.core.redis.RedisService;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import com.max.core.result.ResultGenerator;
import com.max.event.recharge.RechargeEvent;
import com.max.money.dto.RechargeOrderDto;
import com.max.money.dto.WalletSeriesDto;
import com.max.money.service.RechargeOrderService;
import com.max.money.service.WalletSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RechargeController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private WalletSeriesService walletSeriesService;
    @Autowired
    private RechargeOrderService rechargeOrderService;
    @Autowired
    private RechargeEvent rechargeEvent;

    /*充值*/
    @PostMapping("/recharge")
    public Result recharge(@RequestHeader String token, RechargeOrderDto rechargeOrder) {
        RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
        UserDto user = loginedUser.getResult();
        if (null == user) {
            return ResultGenerator.genFailResult(ResultCode.TOEKNUNVALIBLE);
        }
        WalletSeriesDto series = walletSeriesService.getRechargeSeries(user);
        rechargeOrder.setUserId(user.getId());
        rechargeOrder.setSeries(series.getSeries());
        //todo 如果插入失败，是返回在途订单 还是 返回失败提示
        boolean success = rechargeOrderService.recharge(rechargeOrder);
        if(success){
            rechargeEvent.handle(rechargeOrder);
            return ResultGenerator.genSuccessResult(rechargeOrder);
        }
        return ResultGenerator.genFailResult("提交充值失败");

    }
    /*充值在途订单-》没有异步通知成功的单子 */
    @PostMapping("/recharge/process")
    public Result rechargeprocess(@RequestHeader String token) {
        RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
        UserDto user = loginedUser.getResult();
        if (null == user) {
            return ResultGenerator.genFailResult(ResultCode.TOEKNUNVALIBLE);
        }
        RechargeOrderDto rechargeOrder = rechargeOrderService.rechargeProcess(user);
        if(null == rechargeOrder){
            return ResultGenerator.genSuccessResult(rechargeOrder);
        }
        return ResultGenerator.genSuccessResult(rechargeOrder);

    }

    /*撤销充值*/
    @PostMapping("/canclerecharge")
    public Result canclerecharge(RechargeOrderDto cancle) {
        boolean result = rechargeOrderService.cancleRecharge(cancle);
        return ResultGenerator.genSuccessResult(result);
    }

}

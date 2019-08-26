//package com.max.client.controller;
//
//import com.max.core.redis.RedisResult;
//import com.max.core.redis.RedisService;
//import com.max.core.result.Result;
//import com.max.core.result.ResultCode;
//import com.max.core.result.ResultGenerator;
//import com.max.forehead.service.WalletService;
//import com.max.forehead.utils.IpUtil;
//import com.max.recharge.dto.RechargeDto;
//import com.max.recharge.dto.RechargeOrderDto;
//import com.max.recharge.service.RechargeOrderService;
//import com.max.user.dto.UserDto;
//import com.max.wallet.dto.WalletDto;
//import com.max.wallet.dto.WalletSeriesDto;
//import com.max.wallet.service.WalletSeriesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RechargeController {
//    @Autowired
//    private WalletService walletService;
//    @Autowired
//    private RedisService redisService;
//    @Autowired
//    private WalletSeriesService walletSeriesService;
//    @Autowired
//    private RechargeOrderService rechargeOrderService;
//
//    /*充值*/
//    @PostMapping("/recharge")
//    public Result recharge(@RequestHeader String token, RechargeDto recharge) {
//        RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
//        UserDto user = loginedUser.getResult();
//        if (null == user) {
//            return ResultGenerator.genFailResult(ResultCode.TOEKNUNVALIBLE.getCode(), ResultCode.TOEKNUNVALIBLE.getMessage());
//        }
//        String ip = IpUtil.getIpAddr();
//        recharge.setIp(ip);
//        //新建钱包，如果有有则通过，无则创建 获取账户可用充值订单号
//        WalletDto wallet = walletService.createWallet(user);
//        WalletSeriesDto series = walletSeriesService.getRechargeSeries(user);
//        recharge.setWalletId(wallet.getId());
//        recharge.setSeries(series.getSeries());
//        RechargeOrderDto rechargeOrder = rechargeOrderService.recharge(recharge);
//        return ResultGenerator.genSuccessResult(rechargeOrder);
//    }
//
//    /*撤销充值*/
//    @PostMapping("/canclerecharge")
//    public Result canclerecharge(RechargeDto cancle) {
//        String ip = IpUtil.getIpAddr();
//        cancle.setIp(ip);
//        boolean result = rechargeOrderService.cancleRecharge(cancle);
//        return ResultGenerator.genSuccessResult(result);
//    }
//
//}

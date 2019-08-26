//package com.max.client.controller;
//
//import com.max.core.redis.RedisResult;
//import com.max.core.redis.RedisService;
//import com.max.core.result.Result;
//import com.max.core.result.ResultCode;
//import com.max.core.result.ResultGenerator;
//import com.max.forehead.utils.IpUtil;
//import com.max.user.dto.UserBankDto;
//import com.max.user.dto.UserDto;
//import com.max.user.service.UserBankService;
//import com.max.wallet.dto.WalletDto;
//import com.max.wallet.dto.WalletSeriesDto;
//import com.max.wallet.service.WalletSeriesService;
//import com.max.wallet.service.WalletService;
//import com.max.withdraw.dto.WithdrawDto;
//import com.max.withdraw.dto.WithdrawLimitDto;
//import com.max.withdraw.dto.WithdrawOrderDto;
//import com.max.withdraw.service.WithdrawLimitService;
//import com.max.withdraw.service.WithdrawOrderService;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class WithdrawController {
//    @Autowired
//    private WalletService walletService;
//    @Autowired
//    private RedisService redisService;
//    @Autowired
//    private WalletSeriesService walletSeriesService;
//    @Autowired
//    private WithdrawOrderService withdrawOrderService;
//    @Autowired
//    private UserBankService userBankService;
//    @Autowired
//    private WithdrawLimitService withdrawLimitService;
//
//    /*提现*/
//    @PostMapping("/withdraw")
//    public Result withdraw(@RequestHeader String token, WithdrawDto withdraw) {
//        RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
//        UserDto user = loginedUser.getResult();
//        if (null == user) {
//            return ResultGenerator.genFailResult(ResultCode.TOEKNUNVALIBLE.getCode(), ResultCode.TOEKNUNVALIBLE.getMessage());
//        }
//        //新建钱包，如果有有则通过，无则创建  获取账户可用提现订单号
//        WalletDto wallet = walletService.createWallet(user);
//        WalletSeriesDto series = walletSeriesService.getWithdrawSeries(user);
//        //新建支付密码，如果已经有密码则通过，无则提示需要创建支付密码
//        //绑定银行卡 有则通过，无则提示创建银行卡
//        //校验提现约束
//        if (StringUtils.isBlank(wallet.getPasswd())) {
//            return ResultGenerator.genFailResult(ResultCode.NO_WALLET_PASSWD.getCode(), ResultCode.NO_WALLET_PASSWD.getMessage());
//        }
//        UserBankDto bankCard = userBankService.getCard(user);
//        if (null == bankCard) {
//            return ResultGenerator.genFailResult(ResultCode.NO_USER_BANK.getCode(), ResultCode.NO_USER_BANK.getMessage());
//        }
//        WithdrawLimitDto limit = withdrawLimitService.getLimit(user);
//        boolean pass = withdrawLimitService.isLimited(user);
//        if (pass) {
//            //生成提现订单
//            withdraw.setWalletId(wallet.getId());
//            withdraw.setSeries(series.getSeries());
//            String ip = IpUtil.getIpAddr();
//            withdraw.setIp(ip);
//            WithdrawOrderDto withdrawOrderDto = withdrawOrderService.withdraw(withdraw);
//            return ResultGenerator.genSuccessResult(withdrawOrderDto);
//        }
//        return ResultGenerator.genFailResult(ResultCode.WITHDRAW_LIMIT.getCode(), ResultCode.WITHDRAW_LIMIT.getMessage());
//    }
//        /*提现 约束条件*/
//        @PostMapping("/limit")
//        public Result limit (@RequestHeader String token){
//            RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
//            UserDto user = loginedUser.getResult();
//            if (null == user) {
//                return ResultGenerator.genFailResult(ResultCode.TOEKNUNVALIBLE.getCode(), ResultCode.TOEKNUNVALIBLE.getMessage());
//            }
//            //新建钱包，如果有有则通过，无则创建  获取账户可用提现订单号
//            WalletDto wallet = walletService.createWallet(user);
//            if (StringUtils.isBlank(wallet.getPasswd())) {
//                return ResultGenerator.genFailResult(ResultCode.NO_WALLET_PASSWD.getCode(), ResultCode.NO_WALLET_PASSWD.getMessage());
//            }
//            UserBankDto bankCard = userBankService.getCard(user);
//            if (null == bankCard) {
//                return ResultGenerator.genFailResult(ResultCode.NO_USER_BANK.getCode(), ResultCode.NO_USER_BANK.getMessage());
//            }
//            WithdrawLimitDto limit = withdrawLimitService.getLimit(user);
//            return ResultGenerator.genSuccessResult(limit);
//        }
//    }

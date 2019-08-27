package com.max.money.service;

import com.max.base.dto.UserDto;
import com.max.money.dto.RechargeOrderDto;
import com.max.money.dto.WithdrawOrderDto;

public interface WalletOrderService  {
    RechargeOrderDto recharge(RechargeOrderDto rechargeOrder);

    RechargeOrderDto rechargeProcess(UserDto user);

    boolean cancleRecharge(RechargeOrderDto cancle);

    WithdrawOrderDto withdraw(WithdrawOrderDto withdrawOrder);
}
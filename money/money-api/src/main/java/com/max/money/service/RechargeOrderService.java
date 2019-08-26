package com.max.money.service;

import com.max.base.dto.UserDto;
import com.max.money.dto.RechargeOrderDto;

public interface RechargeOrderService  {
    boolean recharge(RechargeOrderDto rechargeOrder);
    //撤销没有异步通知成功的单子
    RechargeOrderDto rechargeProcess(UserDto user);
    //撤销没有异步通知成功的单子
    boolean cancleRecharge(RechargeOrderDto cancle);
}
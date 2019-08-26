package com.max.money.service;

import com.max.money.dto.WithdrawOrderDto;

public interface WithdrawOrderService  {
    /**扣钱生成提现订单*/
    WithdrawOrderDto withdraw(WithdrawOrderDto withdrawOrder);
}
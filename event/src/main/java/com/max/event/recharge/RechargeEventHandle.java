package com.max.event.recharge;

import com.max.money.dto.RechargeOrderDto;

public interface RechargeEventHandle {
    void handle(RechargeOrderDto recharge);
}

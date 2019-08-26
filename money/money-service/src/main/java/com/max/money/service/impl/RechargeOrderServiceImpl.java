package com.max.money.service.impl;
import com.max.base.dto.UserDto;
import com.max.money.dto.RechargeOrderDto;
import com.max.money.service.RechargeOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class RechargeOrderServiceImpl implements RechargeOrderService {
    @Override
    public boolean recharge(RechargeOrderDto rechargeOrder) {
        return false;
    }

    @Override
    public RechargeOrderDto rechargeProcess(UserDto user) {
        return null;
    }

    @Override
    public boolean cancleRecharge(RechargeOrderDto cancle) {
        return false;
    }
}

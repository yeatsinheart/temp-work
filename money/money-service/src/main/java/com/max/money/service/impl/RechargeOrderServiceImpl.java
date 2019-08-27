package com.max.money.service.impl;
import com.max.base.dto.UserDto;
import com.max.money.dto.RechargeOrderDto;
import com.max.money.dto.WalletSeriesDto;
import com.max.money.entity.RechargeOrder;
import com.max.money.mapper.RechargeOrderMapper;
import com.max.money.service.RechargeOrderService;
import com.max.money.service.WalletSeriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class RechargeOrderServiceImpl implements RechargeOrderService {
    @Autowired
    private WalletSeriesService walletSeriesService;
    @Autowired
    private RechargeOrderMapper rechargeOrderMapper;
    @Override
    @Transactional
    public boolean recharge(RechargeOrderDto rechargeOrder) {
        WalletSeriesDto series = walletSeriesService.getRechargeSeries(rechargeOrder.getUserId());
        rechargeOrder.setSeries(series.getSeries());
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

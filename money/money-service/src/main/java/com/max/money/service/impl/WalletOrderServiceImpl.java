package com.max.money.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.max.base.dto.UserDto;
import com.max.core.exception.ServiceException;
import com.max.money.dto.RechargeOrderDto;
import com.max.money.dto.WithdrawOrderDto;
import com.max.money.entity.WalletOrder;
import com.max.money.mapper.WalletOrderMapper;
import com.max.money.service.WalletOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class WalletOrderServiceImpl implements WalletOrderService {
    @Autowired
    private WalletOrderMapper walletOrderMapper;

    @Override
    public RechargeOrderDto recharge(RechargeOrderDto rechargeOrder) {
        BigDecimal money = rechargeOrder.getMoney();
        if (null == money || money.compareTo(BigDecimal.ZERO) != 1) {
            throw new ServiceException("充值金额异常，请确认");
        }
        List<WalletOrder> orders = walletOrderMapper.selectList(new QueryWrapper<WalletOrder>()
                .eq("user_id", rechargeOrder.getUserId())
                .eq("type", rechargeOrder.getType())
                .eq("status", 0)
                .orderByDesc("create_time")
        );
        if (!CollectionUtils.isEmpty(orders)) {
            throw new ServiceException("存在未完成充值订单，请确认");
        }
        WalletOrder order = new WalletOrder();
        order.setType(rechargeOrder.getType());
        order.setStatus(0);
        order.setUserId(rechargeOrder.getUserId());
        order.setMoney(money.multiply(new BigDecimal(1000)).toString());
        int insertNum = 0;
        while (insertNum != 1) {
            order.setSeries(RandomStringUtils.randomAlphanumeric(10));
            rechargeOrder.setSeries(order.getSeries());
            insertNum = walletOrderMapper.insert(order);
        }
        return rechargeOrder;
    }

    @Override
    public RechargeOrderDto rechargeProcess(UserDto user) {
        List<WalletOrder> orders = walletOrderMapper.selectList(new QueryWrapper<WalletOrder>()
                .eq("user_id", user.getId())
                .eq("type", 1)
                .eq("status", 0)
                .orderByDesc("create_time")
        );
        if (!CollectionUtils.isEmpty(orders)) {
            WalletOrder order = orders.get(0);
            RechargeOrderDto rechargeOrder = new RechargeOrderDto();
            rechargeOrder.setSeries(order.getSeries());
            rechargeOrder.setMoney(new BigDecimal(order.getMoney()).divide(new BigDecimal(1000)));
            return rechargeOrder;
        }
        throw new ServiceException("没有未完成充值订单，请确认");
    }

    @Override
    public boolean cancleRecharge(RechargeOrderDto cancle) {
        UpdateWrapper<WalletOrder> deleted = new UpdateWrapper<>();
        deleted.set("deleted", 1);
        deleted.eq("user_id", cancle.getUserId())
                .eq("type", 1);
        int deletedNum = walletOrderMapper.update(null, deleted);
        return deletedNum == 1;
    }

    @Override
    public WithdrawOrderDto withdraw(WithdrawOrderDto withdrawOrder) {
        BigDecimal money = withdrawOrder.getMoney();
        if (null == money || money.compareTo(BigDecimal.ZERO) != 1) {
            throw new ServiceException("提现金额异常，请确认");
        }
        List<WalletOrder> orders = walletOrderMapper.selectList(new QueryWrapper<WalletOrder>()
                .eq("user_id", withdrawOrder.getUserId())
                .eq("type", withdrawOrder.getType())
                .eq("status", 0)
                .orderByDesc("create_time")
        );
        if (!CollectionUtils.isEmpty(orders)) {
            throw new ServiceException("存在未完成提现订单，请确认");
        }
        WalletOrder order = new WalletOrder();
        order.setType(withdrawOrder.getType());
        order.setStatus(0);
        order.setUserId(withdrawOrder.getUserId());
        order.setMoney(money.multiply(new BigDecimal(1000)).toString());
        int insertNum = 0;
        while (insertNum != 1) {
            order.setSeries(RandomStringUtils.randomAlphanumeric(10));
            withdrawOrder.setSeries(order.getSeries());
            insertNum = walletOrderMapper.insert(order);
        }
        return withdrawOrder;
    }
}

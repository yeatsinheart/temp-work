package com.max.money.service.impl;
import com.max.core.exception.ServiceException;
import com.max.core.result.ResultCode;
import com.max.money.dto.WithdrawOrderDto;
import com.max.money.service.WithdrawOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class WithdrawOrderServiceImpl implements WithdrawOrderService {
    /**
     * 扣钱生成提现订单
     *
     * @param withdrawOrder
     */
    @Override
    public WithdrawOrderDto withdraw(WithdrawOrderDto withdrawOrder) {
        throw new ServiceException(ResultCode.NOT_ENGOUH_BALANCE);
    }
}

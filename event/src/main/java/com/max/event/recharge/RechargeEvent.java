package com.max.event.recharge;

import com.max.money.dto.RechargeOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RechargeEvent {
    @Autowired
    private List<RechargeEventHandle> rechargeEventHandles;

    public void handle(RechargeOrderDto recharge) {
        for (RechargeEventHandle handler : rechargeEventHandles) {
            handler.handle(recharge);
        }
    }
}

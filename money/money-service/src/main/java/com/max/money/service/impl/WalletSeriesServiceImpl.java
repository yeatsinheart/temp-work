package com.max.money.service.impl;
import com.max.base.dto.UserDto;
import com.max.money.dto.WalletSeriesDto;
import com.max.money.service.WalletSeriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class WalletSeriesServiceImpl implements WalletSeriesService {
    @Override
    public WalletSeriesDto getRechargeSeries(UserDto user) {
        return null;
    }

    @Override
    public WalletSeriesDto getWithdrawSeries(UserDto user) {
        return null;
    }
}

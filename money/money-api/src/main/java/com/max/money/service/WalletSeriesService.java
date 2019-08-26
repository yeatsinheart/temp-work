package com.max.money.service;

import com.max.base.dto.UserDto;
import com.max.money.dto.WalletSeriesDto;

public interface WalletSeriesService  {
    WalletSeriesDto getRechargeSeries(UserDto user);

    WalletSeriesDto getWithdrawSeries(UserDto user);
}
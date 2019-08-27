package com.max.money.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.max.base.dto.UserDto;
import com.max.money.dto.WalletSeriesDto;
import com.max.money.entity.WalletSeries;
import com.max.money.mapper.WalletSeriesMapper;
import com.max.money.service.WalletSeriesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class WalletSeriesServiceImpl implements WalletSeriesService {
    @Autowired
    private WalletSeriesMapper walletSeriesMapper;
    @Override
    public WalletSeriesDto getRechargeSeries(Integer userId) {
        WalletSeries series = walletSeriesMapper.selectOne(new QueryWrapper<WalletSeries>().eq("user_id", userId)
                .eq("type", 1)
                .eq("status", 0)
        );
        //不存在则新建
        if(null == series){
            series = new WalletSeries();
            series.setStatus(0);
            series.setUserId(userId);
            series.setType(1);
            int insertNum = 0;
            while (insertNum!=1){
                series.setSeries(RandomStringUtils.randomAlphanumeric(10));
                insertNum = walletSeriesMapper.insert(series);
            }
        }
        return null;
    }

    @Override
    public WalletSeriesDto getWithdrawSeries(Integer userId) {
        return null;
    }
}

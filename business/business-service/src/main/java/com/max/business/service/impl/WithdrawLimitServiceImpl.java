package com.max.business.service.impl;

import com.max.base.dto.UserDto;
import com.max.base.dto.UserWithdrawLimitDto;
import com.max.business.service.WithdrawLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class WithdrawLimitServiceImpl implements WithdrawLimitService {
    @Override
    public boolean passLimited(UserDto user) {
        return false;
    }

    @Override
    public UserWithdrawLimitDto getLimit(UserDto user) {
        return null;
    }
}

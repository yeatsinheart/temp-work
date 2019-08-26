package com.max.business.service;

import com.max.base.dto.UserDto;
import com.max.base.dto.UserWithdrawLimitDto;

public interface WithdrawLimitService {
    boolean passLimited(UserDto user);

    UserWithdrawLimitDto getLimit(UserDto user);
}

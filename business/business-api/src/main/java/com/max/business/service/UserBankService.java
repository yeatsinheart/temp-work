package com.max.business.service;

import com.max.base.dto.BankDto;
import com.max.base.dto.UserDto;
import com.max.business.dto.UserBankDto;

public interface UserBankService  {
    boolean addBank(BankDto bank);

    UserBankDto getCard(UserDto user);
}
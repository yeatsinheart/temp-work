package com.max.business.service.impl;
import com.max.base.dto.BankDto;
import com.max.base.dto.UserDto;
import com.max.business.dto.UserBankDto;
import com.max.business.service.UserBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UserBankServiceImpl implements UserBankService {
    @Override
    public boolean addBank(BankDto bank) {
        return false;
    }

    @Override
    public UserBankDto getCard(UserDto user) {
        return null;
    }
}

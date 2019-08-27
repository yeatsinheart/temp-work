package com.max.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.max.base.dto.UserDto;
public interface UserService  {
    UserDto login(UserDto login);

    UserDto signin(UserDto request);

    UserDto getBalance(UserDto user);
}
package com.max.base.service;

import com.max.base.dto.UserDto;

public interface UserService  {
    UserDto login(UserDto login);

    UserDto signin(UserDto request);
}
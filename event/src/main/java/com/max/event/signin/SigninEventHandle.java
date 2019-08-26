package com.max.event.signin;

import com.max.base.dto.UserDto;

public interface SigninEventHandle {
    void handle(UserDto user);
}

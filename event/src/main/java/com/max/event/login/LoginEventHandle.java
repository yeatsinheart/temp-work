package com.max.event.login;

import com.max.base.dto.UserDto;

public interface LoginEventHandle {
    void handle(UserDto user);
}

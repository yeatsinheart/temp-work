package com.max.event.login;

import com.max.base.dto.UserDto;
import com.max.event.signin.SigninEventHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginEvent {
    @Autowired
    private List<LoginEventHandle> signinEventHandles;
    public void handle(UserDto user){
        for(LoginEventHandle handler:signinEventHandles){
            handler.handle(user);
        }
    }
}

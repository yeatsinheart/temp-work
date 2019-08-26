package com.max.event.signin;

import com.max.base.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SigninEvent {
    @Autowired
    private List<SigninEventHandle> signinEventHandles;
    public void handle(UserDto user){
        for(SigninEventHandle handler:signinEventHandles){
            handler.handle(user);
        }
    }
}

package com.max.client.dto;

import com.max.base.dto.UserDto;
import com.max.client.utils.IpUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LoginUserRequest implements Serializable {
    private String name="";
    private String passwd="";
    private String ip = IpUtil.getIpAddr();
    public UserDto getUserDto(){
        UserDto user = new UserDto();
        user.setName(this.getName());
        user.setPasswd(this.getPasswd());
        return user;
    }
}

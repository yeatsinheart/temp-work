package com.max.client.dto;

import com.max.base.dto.UserDto;
import com.max.client.utils.IpUtil;
import com.max.core.utils.RandomName;
import lombok.Data;

import java.io.Serializable;
@Data
public class SigninUserRequest implements Serializable {
    private String name;
    private String passwd;

    private String ip = IpUtil.getIpAddr();
    public UserDto getUserDto(){
        UserDto user = new UserDto();
        user.setName(this.getName());
        user.setPasswd(this.getPasswd());
        user.setNick(RandomName.randomName(false,4));
        return user;
    }
}

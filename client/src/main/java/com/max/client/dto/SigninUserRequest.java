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

}

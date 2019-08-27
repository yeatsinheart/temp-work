package com.max.client.dto;

import com.max.base.dto.UserDto;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class UserResponse implements Serializable {
    private String token;
    private Integer userId;
    private String nick;
    private BigDecimal balance;

}

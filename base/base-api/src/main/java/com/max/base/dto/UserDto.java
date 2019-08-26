package com.max.base.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private String nick;
    private String passwd;
    private String token;
    private BigDecimal balance;
    private Integer status;
}
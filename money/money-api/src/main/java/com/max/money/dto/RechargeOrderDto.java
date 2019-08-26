package com.max.money.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RechargeOrderDto implements Serializable {
    private Integer userId;
    private String series;
}
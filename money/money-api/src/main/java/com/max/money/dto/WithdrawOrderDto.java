package com.max.money.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WithdrawOrderDto implements Serializable {
    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "操作：1充值 2提现 3转入游戏 4转出游戏 5活动入款")
    private Integer type=2;

    @ApiModelProperty(value = "金额")
    private BigDecimal money;

    @ApiModelProperty(value = "订单号")
    private String series;

    @ApiModelProperty(value = "订单状态 0 处理中 1已结束")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime=LocalDateTime.now();

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime=LocalDateTime.now();
}
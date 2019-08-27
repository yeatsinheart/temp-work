package com.max.money.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value="WalletSeries对象", description="钱包流水号")
public class WalletSeries implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "用户账号")
    private Integer userId;
    @ApiModelProperty(value = "钱包流水号")
    private String series;
    @ApiModelProperty(value = "1 充值 2 提现 3 转入游戏 4 转出游戏")
    private Integer type;
    @ApiModelProperty(value = "所处状态 0 处理中 1已用完")
    private Integer status;
}

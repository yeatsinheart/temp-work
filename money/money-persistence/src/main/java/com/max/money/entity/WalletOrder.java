package com.max.money.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 订单
 * </p>
 *
 * @author yeats
 * @since 2019-08-27
 */
@Data

@ApiModel(value = "WalletOrder对象", description = "订单")
public class WalletOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "操作：1充值 2提现 3转入游戏 4转出游戏 5活动入款")
    private Integer type;

    @ApiModelProperty(value = "金额")
    private String money;

    @ApiModelProperty(value = "订单号")
    private String series;

    @ApiModelProperty(value = "订单状态 0 处理中 1已结束")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "删除 1 已删除")
    private Integer deleted;



}

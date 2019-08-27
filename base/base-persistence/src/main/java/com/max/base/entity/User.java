package com.max.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@ApiModel("用户表")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID  数据库类型int(11)
     */
    @ApiModelProperty(value = "用户ID", name = "id", required = true)
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名，手机号  数据库类型varchar(45)
     */
    @ApiModelProperty(value = "用户名，手机号", name = "name", required = true)
    private String name;

    /**
     * 密码  数据库类型varchar(45)
     */
    @ApiModelProperty(value = "密码", name = "passwd", required = true)
    private String passwd;

    /**
     * 昵称  数据库类型varchar(45)
     */
    @ApiModelProperty(value = "昵称", name = "nick", required = true)
    private String nick;

    /**
     * 创建时间  数据库类型timestamp
     */
    @ApiModelProperty(value = "创建时间", name = "createTime", required = true)
    private LocalDateTime createTime;

    /**
     * 钱包余额，字符元角分厘  数据库类型varchar(45)
     */
    @ApiModelProperty(value = "钱包余额，字符元角分厘", name = "balance", required = true)
    private String balance;

    /**
     * 账号状态 0 正常   数据库类型varchar(45)
     */
    @ApiModelProperty(value = "账号状态 0 正常 ", name = "status", required = true)
    private Integer status;

    @ApiModelProperty(value = "提现密码 ", name = "withdrawPasswd", required = false)
    private String withdrawPasswd;

}


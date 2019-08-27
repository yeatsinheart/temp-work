package com.max.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;



@Data
@ApiModel(value = "GameItemView对象", description = "游戏项视图")
public class GameItemView implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "1游戏项 2游戏集合")
    private String type;

    @ApiModelProperty(value = "界面显示名称")
    private String name;

    @ApiModelProperty(value = "界面显示图")
    private String img;

    @ApiModelProperty(value = "界面小图标")
    private Integer mark;

    @ApiModelProperty(value = "状态0正常 1维护")
    private Integer status;

    @ApiModelProperty(value = "1 已删除")
    private Integer deleted;

    @ApiModelProperty(value = "界面失效开始时间")
    private LocalDateTime disableStartTime;

    @ApiModelProperty(value = "界面失效结束时间")
    private LocalDateTime disableEndTime;

    @ApiModelProperty(value = "内容：type=1时为游戏ID； type=2时为游戏集合跳转页面")
    private String content;

    @ApiModelProperty(value = "所属分组")
    private Integer groupId;


}

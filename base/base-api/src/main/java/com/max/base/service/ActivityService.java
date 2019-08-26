package com.max.base.service;

import com.max.base.dto.ActivityAwardDto;
import com.max.base.dto.ActivityDto;
import com.max.base.dto.UserDto;

import java.util.List;

public interface ActivityService  {
    /**是否可领取 可领取的奖励内容 自动时间范围内确定奖励选项，还是人工申请才确定奖励选项。*/
    ActivityAwardDto getAward(ActivityDto activity, UserDto user);

    List<ActivityDto> pageActivityView();
}
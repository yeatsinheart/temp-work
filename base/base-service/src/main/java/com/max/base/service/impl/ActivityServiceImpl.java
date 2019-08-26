package com.max.base.service.impl;
import com.max.base.dto.ActivityAwardDto;
import com.max.base.dto.ActivityDto;
import com.max.base.dto.UserDto;
import com.max.base.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ActivityServiceImpl implements ActivityService {
    /**
     * 是否可领取 可领取的奖励内容 自动时间范围内确定奖励选项，还是人工申请才确定奖励选项。
     *
     * @param activity
     * @param user
     */
    @Override
    public ActivityAwardDto getAward(ActivityDto activity, UserDto user) {
        return null;
    }

    @Override
    public List<ActivityDto> pageActivityView() {
        return null;
    }
}

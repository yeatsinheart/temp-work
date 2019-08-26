package com.max.client.controller;


import com.max.base.dto.ActivityAwardDto;
import com.max.base.dto.ActivityDto;
import com.max.base.dto.UserDto;
import com.max.base.service.ActivityService;
import com.max.business.dto.ActivityOrderDto;
import com.max.business.service.ActivityOrderService;
import com.max.core.redis.RedisResult;
import com.max.core.redis.RedisService;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import com.max.core.result.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private ActivityOrderService activityOrderService;


    /*活动视图*/
    @PostMapping("/activity")
    public Result activity() {
        //平台：维护，分类：顺序 游戏：顺序，维护
        List<ActivityDto> activityDtos = activityService.pageActivityView();
        return ResultGenerator.genSuccessResult(activityDtos);
    }

    /*参与活动*/
    @PostMapping("/join")
    public Result join(@RequestHeader String token, ActivityDto activity) {
        //是否有效用户
        RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
        UserDto user = loginedUser.getResult();
        if (null == user) {
            return ResultGenerator.genFailResult(ResultCode.TOEKNUNVALIBLE.getCode(), ResultCode.TOEKNUNVALIBLE.getMessage());
        }
        //是否可领取 可领取的奖励内容 自动时间范围内确定奖励选项，还是人工申请才确定奖励选项。
        ActivityAwardDto award = activityService.getAward(activity, user);
        if (null == award) {
            return ResultGenerator.genFailResult(ResultCode.AWARD_NOT_EXIST.getCode(), ResultCode.AWARD_NOT_EXIST.getMessage());
        }
        return ResultGenerator.genSuccessResult(award);
    }

    /*领取奖励内容*/
    @PostMapping("/award")
    public Result award(@RequestHeader String token, ActivityDto activity) {
        //是否有效用户
        RedisResult<UserDto> loginedUser = redisService.getResult(token, UserDto.class);
        UserDto user = loginedUser.getResult();
        if (null == user) {
            return ResultGenerator.genFailResult(ResultCode.TOEKNUNVALIBLE.getCode(), ResultCode.TOEKNUNVALIBLE.getMessage());
        }
        //
        ActivityAwardDto award = activityService.getAward(activity, user);
        if (null == award) {
            return ResultGenerator.genFailResult(ResultCode.AWARD_NOT_EXIST.getCode(), ResultCode.AWARD_NOT_EXIST.getMessage());
        }
        ActivityOrderDto activityOrder = activityOrderService.award(award);
        return ResultGenerator.genSuccessResult(award);
    }
}

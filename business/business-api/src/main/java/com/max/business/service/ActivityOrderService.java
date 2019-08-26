package com.max.business.service;

import com.max.base.dto.ActivityAwardDto;
import com.max.business.dto.ActivityOrderDto;

public interface ActivityOrderService  {
    ActivityOrderDto award(ActivityAwardDto award);
}
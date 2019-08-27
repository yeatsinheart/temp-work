package com.max.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.max.base.dto.GameItemViewDto;
import com.max.base.entity.GameItemView;
import com.max.base.mapper.GameItemViewMapper;
import com.max.base.service.GameItemViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class GameItemViewServiceImpl implements GameItemViewService {
    @Autowired
    private GameItemViewMapper gameItemViewMapper;

    @Override
    public List<GameItemViewDto> game() {
        List<GameItemView> views = gameItemViewMapper.selectList(new QueryWrapper<GameItemView>().ne("deleted", 1));
        List<GameItemViewDto> arr = JSONArray.parseArray(JSONArray.toJSONString(views), GameItemViewDto.class);
        return arr;
    }
}

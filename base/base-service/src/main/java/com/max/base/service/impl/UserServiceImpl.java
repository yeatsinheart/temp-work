package com.max.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.max.base.dto.UserDto;
import com.max.base.entity.User;
import com.max.base.mapper.UserMapper;
import com.max.base.service.UserService;
import com.max.core.exception.ServiceException;
import com.max.core.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDto login(UserDto login) {
        log.error("{}", userMapper.selectById(1));
        QueryWrapper<User> selectByName = new QueryWrapper<User>();
        selectByName.eq("name", login.getName());
        List<User> usersByName = userMapper.selectList(selectByName);
        if(CollectionUtils.isEmpty(usersByName)){
            throw new ServiceException(ResultCode.USER_NAME_NOT_EXIST);
        }else {
            for(User user:usersByName){
                if(user.getPasswd().equals(login.getPasswd())){
                    UserDto userResponse = new UserDto();
                    userResponse.setId(user.getId());
                    userResponse.setNick(user.getNick());
                    userResponse.setBalance(new BigDecimal(user.getBalance()));
                    return userResponse;
                }
            }
        }

        return null;
    }

    @Override
    public UserDto signin(UserDto request) {
        User user = new User();
        user.setName(request.getName());
        user.setPasswd(request.getPasswd());
        user.setCreateTime(LocalDateTime.now());
        user.setNick(request.getNick());
        user.setBalance("0");
        user.setStatus(0);
        int insetNum = userMapper.insert(user);
        if(insetNum==1){
            QueryWrapper<User> selectByName = new QueryWrapper<User>();
            selectByName.eq("name", request.getName());
            user = userMapper.selectOne(selectByName);
            UserDto userResponse = new UserDto();
            userResponse.setId(user.getId());
            userResponse.setNick(user.getNick());
            userResponse.setBalance(new BigDecimal(user.getBalance()));
            return userResponse;
        }
        return null;
    }

    @Override
    public UserDto getBalance(UserDto user) {
        return null;
    }
}

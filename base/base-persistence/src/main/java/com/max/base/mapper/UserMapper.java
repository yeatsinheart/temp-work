package com.max.base.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.max.base.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

package com.dubianmayou.dao.mapper;

import com.dubianmayou.dao.slave.mapper.SlaveUserMapper;
import com.dubianmayou.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by bruce on 4/4/2015.
 */
public interface UserMapper extends SlaveUserMapper {
    User loadUser2(@Param("userName") String userName, @Param("password") String password);
}

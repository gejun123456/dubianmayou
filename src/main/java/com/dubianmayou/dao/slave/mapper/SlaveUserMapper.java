package com.dubianmayou.dao.slave.mapper;

import com.dubianmayou.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by bruce on 4/4/2015.
 */
public interface SlaveUserMapper {
    User loadUser(@Param("userName") String userName, @Param("password") String password);
}

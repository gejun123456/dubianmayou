package com.dubianmayou.dao.mapper;

import com.dubianmayou.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by bruce on 4/4/2015.
 */
public interface UserMapper {
    User loadUser(@Param("userName") String userName, @Param("password") String password);
}

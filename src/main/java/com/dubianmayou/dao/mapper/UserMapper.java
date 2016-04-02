package com.dubianmayou.dao.mapper;

import com.dubianmayou.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bruce on 4/4/2015.
 */
public interface UserMapper {
    User loadUser2(@Param("userName") String userName, @Param("password") String password);

    User loadUser(@Param("userName") String userName, @Param("password") String password);

    int insert(@Param("entity") User user);

    int insertList(@Param("userList")List<User> users);

}

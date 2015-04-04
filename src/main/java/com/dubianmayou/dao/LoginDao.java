package com.dubianmayou.dao;

import com.dubianmayou.dao.inter.UserMapper;
import com.dubianmayou.entity.User;

/**
 * Created by bruce on 4/4/2015.
 */
public class LoginDao {
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Boolean login(String name, String password) {
        User bruce = userMapper.getUser(name, password);
        System.out.println(bruce.getUser_Id());
        System.out.println(bruce.getPassword());
        if (bruce != null) {
            return true;
        } else {
            return false;
        }
    }
}

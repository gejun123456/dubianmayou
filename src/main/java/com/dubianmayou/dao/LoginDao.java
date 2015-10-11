package com.dubianmayou.dao;

import com.dubianmayou.dao.inter.UserMapper;
import com.dubianmayou.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bruce on 4/4/2015.
 */
@Repository
public class LoginDao {
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Boolean login(String name, String password) {
        User bruce = userMapper.getUser(name, password);
        if (bruce != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean insert(String name, String password) {
        try {
            User user = new User();
            user.setUser_Id(name);
            user.setPassword(password);
            userMapper.insertUser(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<User> findAllUser() {
        return userMapper.findAll();
    }
}

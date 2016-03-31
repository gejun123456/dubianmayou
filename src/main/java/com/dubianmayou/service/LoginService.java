package com.dubianmayou.service;

import com.dubianmayou.dao.mapper.UserMapper;
import com.dubianmayou.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bruce on 4/4/2015.
 */
@Service
public class LoginService {

    private static Logger logger = LogManager.getLogger(LoginService.class);

    @Autowired
    private UserMapper userMapper;


    public Boolean login(String name, String password) {
        try {
            User bruce = userMapper.loadUser(name, password);
            if (bruce != null) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            logger.error("userMapper can't load data",e);
        }
        return false;
    }
//
//    public Boolean insert(String name, String password) {
//        try {
//            User user = new User();
//            user.setUser_Id(name);
//            user.setPassword(password);
//            userMapper.insertUser(user);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public List<User> findAllUser() {
//        return userMapper.findAll();
//    }
}

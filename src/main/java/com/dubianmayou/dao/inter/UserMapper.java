package com.dubianmayou.dao.inter;

import com.dubianmayou.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by bruce on 4/4/2015.
 */
public interface UserMapper {
    User getUser(String name, String password);

    List<User> findUser(String name);

    void insertUser(User user) throws Exception;

    List<User> findAll();
}

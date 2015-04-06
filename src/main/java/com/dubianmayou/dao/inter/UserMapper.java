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
    @Select("SELECT * FROM user WHERE USER_ID = #{userId} and PASSWORD = #{password}")
    User getUser(@Param("userId") String name, @Param("password") String password);

    @Select("SELECT * FROM user WHERE USER_ID = #{name}")
    List<User> findUser(String name);

    @Insert("INSERT INTO user (USER_ID,PASSWORD) VALUES (#{user_Id},#{password})")
    int insertUser(User user) throws Exception;

}

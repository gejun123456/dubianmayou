package com.dubianmayou.dao.inter;

import com.dubianmayou.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by bruce on 4/4/2015.
 */
public interface UserMapper {
    @Select("SELECT * FROM user WHERE USER_ID = #{userId} and PASSWORD = #{password}")
    User getUser(@Param("userId") String name, @Param("password") String password);

}

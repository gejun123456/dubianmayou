package com.dubianmayou.controller;

import com.dubianmayou.dao.LoginDao;
import com.dubianmayou.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bruce on 4/3/2015.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginDao loginDao;


    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    String getIndexPage(@RequestBody User user) {
        if (loginDao.login(user.getUser_Id(), user.getPassword())) {
            return "loginss";
        } else {
            return "loginf";
        }
    }
}

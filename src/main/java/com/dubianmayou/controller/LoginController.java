package com.dubianmayou.controller;

import com.dubianmayou.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bruce on 4/3/2015.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginDao loginDao;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String getIndexPage(@RequestParam String username, @RequestParam String password) {
        if (loginDao.login(username, password)) {
            return "loginss";
        } else {
            return "loginf";
        }
    }
}

package com.dubianmayou.controller;

import com.dubianmayou.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bruce on 4/3/2015.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginDao loginDao;

    @RequestMapping
    public String getIndexPage(@RequestParam String inputEmail, @RequestParam String inputPassword) {
        if (loginDao.login(inputEmail, inputPassword)) {
            return "loginss";
        } else {
            return "loginf";
        }
    }
}

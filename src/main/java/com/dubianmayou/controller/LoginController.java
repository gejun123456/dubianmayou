package com.dubianmayou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bruce on 4/3/2015.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping
    public String getIndexPage(@RequestParam String inputEmail, @RequestParam String inputPassword) {
        if(inputEmail.equals("aa")&&inputPassword.equals("bb")) {
            return "loginss";
        } else {
            return "loginf";
        }
    }
}

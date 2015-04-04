package com.dubianmayou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

/**
 * Created by bruce on 4/3/2015.
 */
@Controller

public class IndexController {
    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping("/profile")
    public String getProfile() {
        return "profile";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

}

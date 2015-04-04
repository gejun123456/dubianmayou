package com.dubianmayou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getProfile(){
        return "profile";
    }


}

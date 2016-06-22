package com.dubianmayou.controller;

import com.dubianmayou.dto.FollowerDto;
import com.dubianmayou.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by bruce on 4/3/2015.
 */
@Controller

public class IndexController {
    @Autowired
    private OperatorService operatorService;
    @RequestMapping("/")
    public String getIndexPage(HttpServletRequest request,ModelMap model) {
        String remote = request.getRemoteAddr();
        //use database to get the remote data.
        //bind by ip cause i don't care. ip will generate code for share.
        //for velocity to check if the data is empty.
        List<FollowerDto> followers = operatorService.findFollowers("192.168.8.101");
        model.addAttribute("followers",followers);
        return "index2";
    }

    @RequestMapping("/profile")
    public String getProfile() {
        return "profile";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getLogOut(HttpSession httpSession) {
        httpSession.invalidate();
        return "index";
    }

}

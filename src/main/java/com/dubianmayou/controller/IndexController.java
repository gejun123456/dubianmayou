package com.dubianmayou.controller;

import com.dubianmayou.dto.FollowerDto;
import com.dubianmayou.dto.FollowerDtoBuilder;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by bruce on 4/3/2015.
 */
@Controller

public class IndexController {
    @RequestMapping("/")
    public String getIndexPage(HttpSession httpSession,ModelMap model) {
        model.addAttribute("hehe","nimeiya");
        ArrayList<FollowerDto> followerDtos = Lists.newArrayList(
                FollowerDtoBuilder.aFollowerDto().withUrl("http://www.baidu.com").withCount(4).withPicUrl("http:www.baidu.com").build(),
                FollowerDtoBuilder.aFollowerDto().withUrl("http://www.baidu.com").withCount(4).withPicUrl("http:www.baidu.com").build(),
                FollowerDtoBuilder.aFollowerDto().withUrl("http://www.baidu.com").withCount(4).withPicUrl("http:www.baidu.com").build()
        );
        model.addAttribute("followers",followerDtos);
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

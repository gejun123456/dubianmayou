package com.dubianmayou.controller;

import com.dubianmayou.pageentity.User;
import com.dubianmayou.service.LoginService;
import com.dubianmayou.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by bruce on 4/3/2015.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage getIndexPage(@RequestBody User user, HttpSession httpSession) {
        if (loginService.login(user.getUserName(), user.getPassword())) {
            httpSession.setAttribute("user", user.getUserName());
            if (user.getUserName().equals("bruce")) {
                httpSession.setAttribute("isAdmin", true);
            }
            return new ResponseMessage(ResponseMessage.Type.success, "ok");
        } else {
            httpSession.removeAttribute("user");
            return new ResponseMessage(ResponseMessage.Type.error, "no");
        }
    }
}

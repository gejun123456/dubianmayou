package com.dubianmayou.controller;

import com.dubianmayou.dao.LoginDao;
import com.dubianmayou.entity.ResponseMessage;
import com.dubianmayou.entity.User;
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
    private LoginDao loginDao;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage getIndexPage(@RequestBody User user, HttpSession httpSession) {
        if (loginDao.login(user.getUser_Id(), user.getPassword())) {
            httpSession.setAttribute("user", user.getUser_Id());
            if (user.getUser_Id().equals("bruce")) {
                httpSession.setAttribute("isAdmin", true);
            }
            return new ResponseMessage(ResponseMessage.Type.success, "ok");
        } else {
            httpSession.removeAttribute("user");
            return new ResponseMessage(ResponseMessage.Type.error, "no");
        }
    }
}

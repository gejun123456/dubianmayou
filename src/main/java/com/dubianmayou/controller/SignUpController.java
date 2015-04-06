package com.dubianmayou.controller;

import com.dubianmayou.dao.LoginDao;
import com.dubianmayou.entity.ResponseMessage;
import com.dubianmayou.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by bruce on 4/6/2015.
 */
@Controller
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private LoginDao loginDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getSignUpPage() {
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage getSignUp(@RequestBody User user, HttpSession httpSession) {
        if(loginDao.insert(user.getUser_Id(), user.getPassword())) {
            httpSession.setAttribute("user", user.getUser_Id());
            return new ResponseMessage(ResponseMessage.Type.success, "ok");
        } else {
            return new ResponseMessage(ResponseMessage.Type.error, "ok");
        }
    }

}

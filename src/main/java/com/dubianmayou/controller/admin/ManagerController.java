package com.dubianmayou.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bruce on 4/7/2015.
 */
@Controller
public class ManagerController {
    @RequestMapping(value = "/managerUser", method = RequestMethod.GET)
    public String managerUser() {
        return "manageruser";
    }
}

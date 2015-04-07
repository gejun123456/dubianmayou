package com.dubianmayou.controller.admin;

import com.dubianmayou.dao.LoginDao;
import com.dubianmayou.entity.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by bruce on 4/7/2015.
 */
@Controller
public class ManagerController {
    @Autowired
    private LoginDao loginDao;

    @RequestMapping(value = "/managerUser", method = RequestMethod.GET)
    public String managerUser(ModelMap modelMap) {
        List<User> allUser = loginDao.findAllUser();
        modelMap.put("allUser", allUser);
        modelMap.put("testjs", new Gson().toJson(allUser));
        return "manage/manager";
    }
}

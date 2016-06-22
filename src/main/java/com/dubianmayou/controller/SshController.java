package com.dubianmayou.controller;

import com.dubianmayou.utils.cmdb.CmdbUtil;
import com.dubianmayou.utils.cmdb.Projects;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by bruce on 6/22/2016.
 */
@Controller
@RequestMapping("/ssh")
public class SshController {
    //other should all use with ajax.
    @RequestMapping("/")
    public String getAllAddress(ModelMap modelMap){
        List<String> allApps = CmdbUtil.getAllApps();
        modelMap.addAttribute("app",allApps);
        return "ssh";
    }

    @RequestMapping("{app}")
    public @ResponseBody String getAddressForOneApp(@PathVariable("app") String app){
        Projects projectByName = CmdbUtil.getProjectByName(app);
        return new Gson().toJson(projectByName.getDevices());
    }
}

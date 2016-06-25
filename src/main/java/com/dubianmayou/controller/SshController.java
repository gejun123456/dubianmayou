package com.dubianmayou.controller;

import com.dubianmayou.dto.CommandResponse;
import com.dubianmayou.utils.DataUtils;
import com.dubianmayou.utils.cmdb.CmdbUtil;
import com.dubianmayou.utils.cmdb.Projects;
import com.dubianmayou.utils.jsch.ChannelRegister;
import com.dubianmayou.utils.jsch.JschUtils;
import com.dubianmayou.utils.jsch.SessionUtils;
import com.google.gson.Gson;
import com.jcraft.jsch.Channel;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
        if(CollectionUtils.isEmpty(allApps)){
            allApps.add("discount-center-service");
        }
        modelMap.addAttribute("app",allApps);
        return "ssh";
    }

    @RequestMapping("{app}")
    public @ResponseBody String getAddressForOneApp(@PathVariable("app") String app){
        Projects projectByName = CmdbUtil.getProjectByName(app);
        return new Gson().toJson(projectByName.getDevices());
    }

    //should separate request and get response.  //only login to this page. not get data. get data should be continues.
    @RequestMapping("{app}/{ip}/")
    public String ConnectToIp(@PathVariable("app")String app, @PathVariable("ip") String ip, HttpSession session,ModelMap model){
        //get login to the ssh service
        model.addAttribute("title",app+" "+ip);
        model.addAttribute("path",app+"/"+ip);
        String id = session.getId()+ip;
        if(JschUtils.connect(id,ip)){
            model.addAttribute("sessionData","connect success");

        } else {
            model.addAttribute("sessionData","Connect failed");
        }
        return "sshsession";
    }

    @RequestMapping("{app}/{ip}/query")
    @ResponseBody
    public CommandResponse getData(@PathVariable("app")String app, @PathVariable("ip") String ip, @RequestParam("command")String command, HttpSession session) throws InterruptedException {
        //get login to the ssh service
        //just try to send data. not get data.
        String id = session.getId()+ip;
        Channel channel = ChannelRegister.getChannel(id);
        if(channel==null){
            boolean connect = JschUtils.connect(id, ip);
            if(connect){
                channel = ChannelRegister.getChannel(id);
            } else {
                return new CommandResponse(false,"can't connect");
            }
        }
        try {
            JschUtils.writeCommd(channel, command);
        }catch (Exception e){
            return new CommandResponse(false,"write command catch exception");
        }
//        List<String> data = SessionUtils.getData(id);
//        int i =1;
//        while(CollectionUtils.isEmpty(data)&&i<10){
//            data = SessionUtils.getData(id);
//            i++;
//            Thread.sleep(1000);
//        }
//        if(CollectionUtils.isEmpty(data)){
//            return new CommandResponse(false,"can't get data in 10 seconds");
//        }
//        String sessionStrings = DataUtils.buildData(data);
        return new CommandResponse(true,"success");
    }


    @RequestMapping("{app}/{ip}/getData")
    @ResponseBody
    public CommandResponse getData(@PathVariable("app")String app, @PathVariable("ip") String ip, HttpSession session) throws InterruptedException {
        //get login to the ssh service
        //just try to send data. not get data.
        String id = session.getId()+ip;
        List<String> data = SessionUtils.getData(id);
        int i =1;
        while(CollectionUtils.isEmpty(data)&&i<10){
            data = SessionUtils.getData(id);
            i++;
            Thread.sleep(1000);
        }
        String sessionStrings = DataUtils.buildData(data);
        return new CommandResponse(true,sessionStrings);
    }
}

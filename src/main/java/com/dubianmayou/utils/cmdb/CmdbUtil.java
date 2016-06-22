package com.dubianmayou.utils.cmdb;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * Created by ge on 16/6/21.
 */
public class CmdbUtil {
    public static Projects getProjectByName(String name) {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://api.cmdb.dp/api/v0.1/projects/" + name + "/devices?count=50");
        String x=  "";
        try {
            CloseableHttpResponse execute = aDefault.execute(get);
            x = EntityUtils.toString(execute.getEntity());
        }catch (Exception e){
            return null;
        }
        if(StringUtils.isBlank(x)){
            return null;
        }
//        if(StringUtils.isE)
        //        System.out.println(x);
        Gson gson = new Gson();
        Projects projects = gson.fromJson(x, Projects.class);
//    List<Device> devices = projects.getDevices();
//    for(Device device : devices){
////        System.out.println(device.getHostname()+":"+device.getPrivate_ip().get(0)+";");
//    }
        return projects;
    }

//todo how to put it to web to useit.
    public static List<String> getAllApps(){
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://api.cmdb.dp/api/v0.1/products/闪惠/projects?count=100");
        String x=  "";
        try {
            CloseableHttpResponse execute = aDefault.execute(get);
            x = EntityUtils.toString(execute.getEntity());
        }catch (Exception e){
            return null;
        }
        if(StringUtils.isBlank(x)){
            return null;
        }
        int s = -1;
        //找到第一个\n
        List<String> res = Lists.newArrayList();
        while((s=x.indexOf("\"project_name\":"))!=-1){
            x = x.substring(s);
            int d = x.indexOf(",");
            if(d!=-1){
                res.add(x.substring(17,d-1));
                x = x.substring(d+1);
            }
        }
        return res;
    }

    //shall use it as the default value.
    public static void main(String[] args) {
        List<String> allApps = getAllApps();
        for (int i = 0; i < allApps.size(); i++) {
            System.out.println(allApps.get(i));
        }
    }


}

package com.dubianmayou.utils.cmdb;

import java.util.List;

/**
 * Created by ge on 16/6/20.
 */
public class Device {
    private String hostname;

    private List<String> private_ip;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public List<String> getPrivate_ip() {
        return private_ip;
    }

    public void setPrivate_ip(List<String> private_ip) {
        this.private_ip = private_ip;
    }
}

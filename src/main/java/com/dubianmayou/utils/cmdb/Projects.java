package com.dubianmayou.utils.cmdb;

import java.util.List;

/**
 * Created by ge on 16/6/20.
 */
public class Projects {
    private int total;
    private int page;
    private List<Device> devices;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}

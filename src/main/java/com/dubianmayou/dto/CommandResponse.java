package com.dubianmayou.dto;

import java.io.Serializable;

/**
 * Created by bruce on 6/22/2016.
 */
public class CommandResponse implements Serializable{
    private static final long serialVersionUID = -4662718108613513L;
    private boolean isSuccess;

    private String msg;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public CommandResponse(boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
    }
}

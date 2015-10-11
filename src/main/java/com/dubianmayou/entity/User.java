package com.dubianmayou.entity;

import java.io.Serializable;

/**
 * Created by bruce on 4/4/2015.
 */
public class User implements Serializable{
    private static final long serialVersionUID = -4202830655007616623L;
    private String user_Id;
    private String password;

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

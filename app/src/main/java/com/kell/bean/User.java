package com.kell.bean;

/**
 * Created by ydm on 2016/10/18.
 */
/*
* 用户实体类
* */
public class User {

    private String uname;//用户名
    private String upwd;//密码

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}

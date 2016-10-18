package com.kell.model;

import com.kell.bean.User;

import java.util.List;

/**
 * Created by ydm on 2016/10/18.
 */
/*
* 用户Model
* */
public interface IUserModel {
     boolean reg(String uname,String upwd);//用户登录
     User login(String uname, String upwd);//用户注册
     List<User> getUserList();//获取用户
}

package com.kell.presenter;

/**
 * Created by ydm on 2016/10/18.
 */
/*
* 用户登陆
* */
public interface ILoginPresenter {
    void login(String uname,String upwd);//用户登陆
    void reg(String uname,String upwd); //用户注册
}

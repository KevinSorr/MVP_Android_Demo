package com.kell.view;

import com.kell.bean.User;

import java.util.List;

/**
 * Created by ydm on 2016/10/18.
 */

public interface ILoginView {
    void initView();//初始化控件
    void setOnClickListener();//设置按钮监听
    void loginSuccess();//登陆成功页面更新
    void loginFail();//登陆失败页面更新
    void regSuccess();//注册成功页面更新
    void regFail();//注册失败页面更新
    String getUserName();//获取用户名
    String getUserPwd();//获取密码
    void emptyUserName();//判断用户名是否为空
    void emptyUpwd();//判断密码是否为空
    void clearEditText();//清除输入框
    void initUserListView(List<User> users);//初始化文字列表

}

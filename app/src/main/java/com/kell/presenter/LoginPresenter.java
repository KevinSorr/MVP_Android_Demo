package com.kell.presenter;

import android.text.TextUtils;

import com.kell.bean.User;
import com.kell.model.IUserModel;
import com.kell.model.UserModel;
import com.kell.view.ILoginView;

/**
 * Created by ydm on 2016/10/18.
 */
/*
* 用户登陆逻辑实现
* */
public class LoginPresenter implements ILoginPresenter {
    public IUserModel userModel = null;
    public ILoginView loginView = null;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        userModel = new UserModel();
        loginView.initUserListView(userModel.getUserList());
    }

    /**
     * 用户登录逻辑
     */
    @Override
    public void login(String uname, String upwd) {
        if (TextUtils.isEmpty(uname)) {
            loginView.emptyUserName();
            return;
        }
        if (TextUtils.isEmpty(upwd)) {
            loginView.emptyUpwd();
            return;
        }
        if (userModel.login(uname, upwd) == null) {
            loginView.loginFail();
        } else {
            loginView.loginSuccess();
        }
    }

    /**
     * 用户注册逻辑
     */
    @Override
    public void reg(String uname, String upwd) {
        if (TextUtils.isEmpty(uname)) {
            loginView.emptyUserName();
            return;
        }
        if (TextUtils.isEmpty(upwd)) {
            loginView.emptyUpwd();
            return;
        }
        if (userModel.reg(uname, upwd)) {
            loginView.regSuccess();
            loginView.clearEditText();
        } else {
            loginView.loginFail();
        }

    }
}

package com.kell.model;

import com.kell.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydm on 2016/10/18.
 */
/*
* IUserModel实现
* */
public class UserModel implements IUserModel {

    private List<User> users = new ArrayList<>();

    /**
     * 用户注册
     */
    @Override
    public boolean reg(String uname, String upwd) {
        User user = new User(uname, upwd);
        users.add(user);
        return true;
    }
    /**
     * 用户登录
     */
    @Override
    public User login(String uname, String upwd) {
        for (User user : users) {
            if (uname.equals(user.getUname()) && upwd.equals(user.getUpwd())) {
                return user;
            }
        }
        return null;

    }

    @Override
    public List<User> getUserList() {
        return users;
    }
}

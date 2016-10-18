package com.kell.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kell.adapter.RecyclerViewAdapter;
import com.kell.bean.User;
import com.kell.presenter.ILoginPresenter;
import com.kell.presenter.LoginPresenter;

import java.util.List;


public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    private ILoginPresenter loginPresenter = null;
    private EditText inputUserName = null;
    private EditText inputUserPwd = null;
    private Button loginBtn = null;
    private Button regBtn = null;
    private TextView resultTextView = null;
    private RecyclerViewAdapter recyclerViewAdapter = null;
    private RecyclerView userListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setOnClickListener();
    }

    /**
     * 初始化
     */
    @Override
    public void initView() {
        inputUserName = (EditText) findViewById(R.id.input_uname);
        inputUserPwd = (EditText) findViewById(R.id.input_upwd);
        loginBtn = (Button) findViewById(R.id.login_btn);
        regBtn = (Button) findViewById(R.id.reg_btn);
        resultTextView = (TextView) findViewById(R.id.result_text_view);
        userListView = (RecyclerView)findViewById(R.id.user_list);

        loginPresenter = new LoginPresenter(this);

    }

    /**
     * 设置点击事件
     */
    @Override
    public void setOnClickListener() {
        loginBtn.setOnClickListener(this);
        regBtn.setOnClickListener(this);
    }

    /**
     * 登陆成功
     */
    @Override
    public void loginSuccess() {
        resultTextView.setText("登陆成功");

    }

    /**
     * 登陆失败
     */
    @Override
    public void loginFail() {
        resultTextView.setText("登陆失败");
    }

    /**
     * 注册成功
     */
    @Override
    public void regSuccess() {
        resultTextView.setText("注册成功");
        recyclerViewAdapter.updateUI();
    }

    /**
     * 注册失败
     */
    @Override
    public void regFail() {
        resultTextView.setText("注册失败");
    }
    /**
     * 用户名为空
     */
    @Override
    public void emptyUserName() {
        resultTextView.setText("用户名为空");
    }
    /**
     * 密码为空
     */
    @Override
    public void emptyUpwd() {
        resultTextView.setText("密码为空");
    }
    /**
     * 清除输入
     */
    @Override
    public void clearEditText() {
        inputUserName.setText("");
        inputUserPwd.setText("");
    }
    /**
     * 初始化列表数据
     */
    @Override
    public void initUserListView(List<User> users) {
        recyclerViewAdapter = new RecyclerViewAdapter(this,users);
        userListView.setLayoutManager(new LinearLayoutManager(this));
        userListView.setAdapter(recyclerViewAdapter);
    }

    /**
     * 获取用户名
     */
    @Override
    public String getUserName() {
        return inputUserName.getText().toString();
    }

    /**
     * 获取密码
     */
    @Override
    public String getUserPwd() {
        return inputUserPwd.getText().toString();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn: {
                loginPresenter.login(getUserName(), getUserPwd());
                break;
            }
            case R.id.reg_btn: {
                loginPresenter.reg(getUserName(), getUserPwd());
                break;
            }
        }
    }
}

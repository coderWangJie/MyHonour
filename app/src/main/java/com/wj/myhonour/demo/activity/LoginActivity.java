package com.wj.myhonour.demo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.wj.myhonour.R;
import com.wj.myhonour.basis.BaseActivity;
import com.wj.myhonour.info.UserInfo;

/**
 * WangJ jie581825@yeah.net
 * Created on 2016/10/12
 * Modified:
 * Modified on
 */
public class LoginActivity extends BaseActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        // ...... 登录逻辑
        loginSeccess();
    }

    private void loginSeccess() {
        UserInfo.login();

        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.activity_in_left, R.anim.activity_out_right);
    }
}

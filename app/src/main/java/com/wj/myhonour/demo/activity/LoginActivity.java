package com.wj.myhonour.demo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.wangj.baselibrary.basic.BaseActivity;
import com.wj.myhonour.R;
import com.wj.myhonour.info.UserInfo;
import com.wj.myhonour.util.LogUtil;

/**
 * WangJ jie581825@yeah.net
 * Created on 2016/10/12
 * Modified:
 * Modified on
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    Tencent mTencent;
    MyUILis listener;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {
        mTencent = Tencent.createInstance("1105708689", this);
        listener = new MyUILis();

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        findViewById(R.id.img_loginByQQ).setOnClickListener(this);
        findViewById(R.id.img_loginByWeChat).setOnClickListener(this);
        findViewById(R.id.img_loginByBaidu).setOnClickListener(this);
        findViewById(R.id.img_loginByXinlang).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // Native登陆
            case R.id.btn_login:
                login();
                break;

            // QQ登陆
            case R.id.img_loginByQQ:
                if (!mTencent.isSessionValid()) {
                    mTencent.login(this, "all", listener);
                }
                break;

            // TODO 微信登陆
            case R.id.img_loginByWeChat:

                break;

            // TODO 百度账号登录
            case R.id.img_loginByBaidu:

                break;

            // TODO 新浪账号登录
            case R.id.img_loginByXinlang:

                break;
        }

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

    private class MyUILis implements IUiListener{

        @Override
        public void onComplete(Object o) {
            LogUtil.logE(o.toString());
        }

        @Override
        public void onError(UiError uiError) {

        }

        @Override
        public void onCancel() {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Tencent.onActivityResultData(requestCode, resultCode, data, listener);
    }
}

package com.wj.myhonour.demo.activity;

import android.content.Intent;
import android.view.View;

import com.wangj.baselibrary.basic.BaseActivity;
import com.wj.myhonour.R;
import com.wj.myhonour.demo.activity.developframe.FrameIndexActivity;
import com.wj.myhonour.demo.activity.somewidget.WidgetIndexActivity;
import com.wj.myhonour.demo.activity.systemcall.SystemCallActivity;
import com.wj.myhonour.info.UserInfo;

public class TestActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public int getContentViewId() {
        return R.layout.activity_test;
    }

    @Override
    public void setTitleBar() {
        setTitleWithId(R.string.test);

        setTitleRight(R.drawable.ic_flower, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void initView() {
        findViewById(R.id.btn_login).setOnClickListener(this);

        findViewById(R.id.btn_SysCall).setOnClickListener(this);

        findViewById(R.id.btn_widget).setOnClickListener(this);

        findViewById(R.id.btn_activity).setOnClickListener(this);

        findViewById(R.id.btn_volley).setOnClickListener(this);

        findViewById(R.id.btn_menu).setOnClickListener(this);

        findViewById(R.id.btn_developFrame).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (UserInfo.isLogin()) {
                    toast("已经登录了");
                } else {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.activity_in_right, R.anim.activity_out_left);
                }
                break;
            case R.id.btn_SysCall:
                SystemCallActivity.actionStart(this);
                break;
            case R.id.btn_widget:
                WidgetIndexActivity.actionStart(this);
                break;
            case R.id.btn_activity:
                ShowActivity.actionStart(this, "test001");
                break;
            case R.id.btn_volley:
                VolleyDemoActivity.actionStart(this);
                break;
            case R.id.btn_menu:
                MenuDemoActivity.actionStart(this);
                break;
            case R.id.btn_developFrame:
                FrameIndexActivity.actionStart(this);
                break;
        }
    }

    /**
     * 重写Back键响应，在MainActivity中点击Back键退出
     */
    @Override
    public void onBackPressed() {
        UserInfo.logout();
        finish();
    }
}

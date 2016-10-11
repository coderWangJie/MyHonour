package com.wj.myhonour.demo;

import android.view.View;

import com.wj.myhonour.R;
import com.wj.myhonour.basis.BaseActivity;
import com.wj.myhonour.demo.marquee.MarQueeDemo;

public class TestActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public int getContentViewId() {
        return R.layout.activity_test;
    }

    @Override
    public void setTitleBar() {
        setTitleLeft("返回", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("点击了“返回”按钮");
            }
        });

        setTitleWithId(R.string.test);

        setTitleRight(R.drawable.ic_flower, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void initView() {
        findViewById(R.id.btn_toast).setOnClickListener(this);

        findViewById(R.id.btn_activity).setOnClickListener(this);

        findViewById(R.id.btn_dialog).setOnClickListener(this);

        findViewById(R.id.btn_volley).setOnClickListener(this);

        findViewById(R.id.btn_marquee).setOnClickListener(this);

        findViewById(R.id.btn_menu).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toast:
                toast("随机数：" + Math.random() * 10000);
                break;
            case R.id.btn_activity:
                ShowActivity.actionStart(this, "test001");
                break;
            case R.id.btn_dialog:
                DialogDemoActivity.actionStart(this);
                break;
            case R.id.btn_volley:
                VolleyDemoActivity.actionStart(this);
                break;
            case R.id.btn_marquee:
                MarQueeDemo.actionStart(this);
                break;
            case R.id.btn_menu:
                MenuDemoActivity.actionStart(this);
                break;
        }
    }

}

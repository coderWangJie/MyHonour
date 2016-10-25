package com.wj.myhonour.demo.activity.somewidget;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.wangj.baselibrary.basic.BaseActivity;
import com.wj.myhonour.R;
import com.wj.myhonour.demo.activity.somewidget.switchbutton.SomeSwitchActivity1;
import com.wj.myhonour.demo.activity.somewidget.marquee.MarQueeDemo;

public class WidgetIndexActivity extends BaseActivity implements View.OnClickListener {

    public static void actionStart(Context context) {
        Intent intnet = new Intent(context, WidgetIndexActivity.class);
        context.startActivity(intnet);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_widget_index;
    }

    @Override
    public void setTitleBar() {
        setTitleWithString("各种控件");

    }

    @Override
    public void initView() {
        findViewById(R.id.btn_toast).setOnClickListener(this);

        findViewById(R.id.btn_dialog).setOnClickListener(this);

        findViewById(R.id.btn_marquee).setOnClickListener(this);

        findViewById(R.id.btn_someSwitch).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toast:
                toast("随机数：" + Math.random() * 10000);
                break;
            case R.id.btn_dialog:
                DialogDemoActivity.actionStart(this);
                break;
            case R.id.btn_marquee:
                MarQueeDemo.actionStart(this);
                break;
            case R.id.btn_someSwitch:
                SomeSwitchActivity1.actionStart(this);
                break;
        }
    }
}

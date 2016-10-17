package com.wj.myhonour.demo.activity;

import android.content.Context;
import android.content.Intent;

import com.wj.myhonour.R;
import com.wj.myhonour.basis.BaseActivity;

public class MenuDemoActivity extends BaseActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MenuDemoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_menu_demo;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {

    }

}

package com.wj.myhonour.demo.activity;

import android.content.Context;
import android.content.Intent;

import com.wj.myhonour.R;
import com.wj.myhonour.basis.BaseActivity;

public class ShowActivity extends BaseActivity {

    public static void actionStart(Context context, String account){
        Intent intent = new Intent(context, ShowActivity.class);
        intent.putExtra("account", account);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_show;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {

    }
}

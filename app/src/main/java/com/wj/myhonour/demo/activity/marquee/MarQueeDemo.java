package com.wj.myhonour.demo.activity.marquee;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.wj.myhonour.R;
import com.wj.myhonour.basis.BaseActivity;

/**
 *
 * WangJ jie581825@yeah.net
 * Created on 2016/9/27
 * Modified:
 * Modified on
 */
public class MarQueeDemo extends BaseActivity implements View.OnClickListener {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MarQueeDemo.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_marquee_demo;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {
        findViewById(R.id.btn_marqueeInListView).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_marqueeInListView:
                MarqueeInListViewActivity.actionStart(this);
                break;
//            case R.id.btn_marqueeInListView:
//
//                break;

        }
    }
}

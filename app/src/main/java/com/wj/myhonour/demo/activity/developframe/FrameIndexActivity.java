package com.wj.myhonour.demo.activity.developframe;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.wangj.abouteventbus.EventBusMenu;
import com.wangj.androidannotations.FirstActivity;
import com.wj.myhonour.R;
import com.wj.myhonour.basis.BaseActivity;

public class FrameIndexActivity extends BaseActivity implements View.OnClickListener {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, FrameIndexActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_frame_index;
    }

    @Override
    public void setTitleBar() {
        setTitleWithString("一些框架");
    }

    @Override
    public void initView() {
        findViewById(R.id.btn_ButterKnife1).setOnClickListener(this);

        findViewById(R.id.btn_ButterKnife2).setOnClickListener(this);

        findViewById(R.id.btn_AndroidAnnotation).setOnClickListener(this);

        findViewById(R.id.btn_EventBus).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {

            case R.id.btn_ButterKnife1:
                intent.setClass(this, ButterKnifeActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_ButterKnife2:
                toast("好像Module Library中不能使用ButterKnife，因为id不是static final的，但是JackWharton在GitHub上有关于Library中的使用暂时没搞懂！求教求教");
                break;

            case R.id.btn_AndroidAnnotation:
                intent.setClass(this, FirstActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_EventBus:
                intent.setClass(this, EventBusMenu.class);
                startActivity(intent);
                break;
        }

    }
}

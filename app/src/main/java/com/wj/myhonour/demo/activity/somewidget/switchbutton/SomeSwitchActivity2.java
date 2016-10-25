package com.wj.myhonour.demo.activity.somewidget.switchbutton;

import android.content.Context;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.wangj.baselibrary.basic.BaseActivity;
import com.wj.myhonour.R;

public class SomeSwitchActivity2 extends BaseActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SomeSwitchActivity2.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_some_switch2;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {
        Switch switchM = (Switch) findViewById(R.id.switch_switch);
        switchM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    toast("Switch开启了");
                } else {
                    toast("Switch关闭了");
                }
            }
        });
    }

}

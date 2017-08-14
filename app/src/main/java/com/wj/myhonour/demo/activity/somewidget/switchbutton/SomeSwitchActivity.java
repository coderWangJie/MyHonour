package com.wj.myhonour.demo.activity.somewidget.switchbutton;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.wangj.baselibrary.basic.BaseActivity;
import com.wangj.baselibrary.view.checkswitchbutton.CheckSwitchButton;
import com.wangj.baselibrary.view.togglebutton.ToggleButton;
import com.wj.myhonour.R;

public class SomeSwitchActivity extends BaseActivity implements View.OnClickListener {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SomeSwitchActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_some_switch;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle_toggle);
        toggleButton.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    toast("ToggleButton开启了");
                } else {
                    toast("ToggleButton关闭了");
                }
            }
        });

        Switch switchM = (Switch) findViewById(R.id.switch_switch);
        switchM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toast("Switch开启了");
                } else {
                    toast("Switch关闭了");
                }
            }
        });
        findViewById(R.id.tv_otherSwitch).setOnClickListener(this);

        CheckSwitchButton checkSwitchButton = (CheckSwitchButton) findViewById(R.id.switch_checkSwitchButton);
        checkSwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toast("自定义CheckSwitchButton开启了");
                } else {
                    toast("自定义CheckSwitchButton关闭了");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_otherSwitch:
                SwitchAnotherViewActivity.actionStart(this);
                break;
        }
    }
}

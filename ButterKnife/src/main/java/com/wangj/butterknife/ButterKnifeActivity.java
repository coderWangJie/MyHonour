package com.wangj.butterknife;

import android.app.Activity;
import android.os.Bundle;

public class ButterKnifeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
//        tvName.setText("你是我的小呀小苹果！");

    }
}

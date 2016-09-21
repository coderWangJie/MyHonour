package com.wj.myhonour.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.wj.myhonour.R;

public class TestActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initView();
    }

    private void initView() {
        findViewById(R.id.btn_activity).setOnClickListener(this);

        findViewById(R.id.btn_dialog).setOnClickListener(this);

        findViewById(R.id.btn_volley).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity:
                ShowActivity.actionStart(this, "test001");
                break;
            case R.id.btn_dialog:
                DialogDemoActivity.actionStart(this);
                break;
            case R.id.btn_volley:
                VolleyDemoActivity.actionStart(this);
                break;
        }
    }
}

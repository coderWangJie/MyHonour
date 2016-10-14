package com.wj.myhonour.demo.developframe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.wj.myhonour.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeActivity extends Activity {


    @BindView(R.id.tvName)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        tvName.setText("Module:app中使用ButterKnife");
    }

    @OnClick(R.id.btnConfirm)
    public void onClick() {
        Toast.makeText(ButterKnifeActivity.this, "ButterKnife成功了", Toast.LENGTH_SHORT).show();
    }
}

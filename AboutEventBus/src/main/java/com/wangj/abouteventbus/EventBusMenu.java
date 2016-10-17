package com.wangj.abouteventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wangj.abouteventbus.scene1.SceneRegisterActivity;
import com.wangj.abouteventbus.scene2.MessageIndexActivity;

public class EventBusMenu extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_menu);

        initView();
    }

    private void initView() {
        findViewById(R.id.btn_scene1).setOnClickListener(this);
        findViewById(R.id.btn_scene2).setOnClickListener(this);
        findViewById(R.id.btn_scene3).setOnClickListener(this);
        findViewById(R.id.btn_scene4).setOnClickListener(this);
        findViewById(R.id.btn_scene5).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();

        if (id == R.id.btn_scene1) {
            intent.setClass(this, SceneRegisterActivity.class);
            startActivity(intent);

        } else if (id == R.id.btn_scene2) {
            intent.setClass(this, MessageIndexActivity.class);
            startActivity(intent);

        } else if (id == R.id.btn_scene3) {
            Toast.makeText(EventBusMenu.this, "待完成", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_scene4) {
            Toast.makeText(EventBusMenu.this, "待完成", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_scene5) {
            Toast.makeText(EventBusMenu.this, "待完成", Toast.LENGTH_SHORT).show();

        }
    }
}

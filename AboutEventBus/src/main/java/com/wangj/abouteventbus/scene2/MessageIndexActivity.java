package com.wangj.abouteventbus.scene2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wangj.abouteventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MessageIndexActivity extends Activity {

    private int messageNum = 15;
    private TextView tvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        EventBus.getDefault().register(this);

        initView();
    }

    private void initView() {

        tvNumber = (TextView) findViewById(R.id.tvNumber);
        tvNumber.setText(String.valueOf(messageNum));

        Button btnPost = (Button) findViewById(R.id.btn_post);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageIndexActivity.this,
                        ReadMessageActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * TODO !!!!!!!!!!!!!!!!!!不知道为什么参数用Int类型不响应，也不报错!!!!!!!!!!!!
     * @param str
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshMessageNum(String str) {
        messageNum -= Integer.parseInt(str);
        tvNumber.setText(String.valueOf(messageNum));
    }

}

package com.wangj.abouteventbus.scene2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wangj.abouteventbus.R;

import org.greenrobot.eventbus.EventBus;

public class ReadMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        initView();
    }

    private void initView() {
        final EditText etNum = (EditText) findViewById(R.id.etReadNum);

        Button btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNum.getText() != null
                        && !"".equals(etNum.getText().toString())){

                    EventBus.getDefault().post(etNum.getText().toString());
                } else {
                    EventBus.getDefault().post("0");
                }
                finish();
            }
        });
    }


}

package com.wangj.abouteventbus.scene2;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wangj.abouteventbus.R;
import com.wangj.baselibrary.basic.BaseActivity;

import org.greenrobot.eventbus.EventBus;

public class ReadMessageActivity extends BaseActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_read_message;
    }

    @Override
    public void setTitleBar() {
        setTitleWithString("信息详情");
    }

    @Override
    public void initView() {
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

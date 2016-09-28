package com.wj.myhonour.demo;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.wj.myhonour.R;
import com.wj.myhonour.basis.BaseActivity;
import com.wj.myhonour.util.DialogUtil;

/**
 * WangJ jie581825@yeah.net
 * Created on 2016/9/20
 * Modified:
 * Modified on
 */
public class DialogDemoActivity extends BaseActivity implements View.OnClickListener {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, DialogDemoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_dialog_demo;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                DialogUtil.showHintDialog(this, "提示对话框 1");
                break;
            case R.id.btn_2:
                DialogUtil.showHintDialog(this, "提示对话框 2", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogDemoActivity.this, "自定义对话框响应事件", Toast.LENGTH_SHORT).show();
                        DialogUtil.dismissDialog();
                    }
                });
                break;
            case R.id.btn_3:
                DialogUtil.showHintDialog(this, "自定义标题", "提示对话框 3", "自定义文字", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUtil.dismissDialog();
                    }
                });
                break;
            case R.id.btn_4:
                DialogUtil.showDecideDialog(this, "双按钮对话框 1", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUtil.dismissDialog();
                    }
                }, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUtil.dismissDialog();
                    }
                });
                break;
            case R.id.btn_5:
                DialogUtil.showDecideDialog(this, "自定义标题", "双按钮对话框 2", "自定义文字", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUtil.dismissDialog();
                    }
                });
                break;
            case R.id.btn_6:
                DialogUtil.showDecideDialog(this, "自定义标题", "双按钮对话框 2", "自定义文字1", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUtil.dismissDialog();
                    }
                }, "自定义文字2", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUtil.dismissDialog();
                    }
                });
                break;
            case R.id.btn_7:
                // TODO PopupWindow
                DialogUtil.showHintDialog(this, "未完成......");
                break;

        }
    }
}

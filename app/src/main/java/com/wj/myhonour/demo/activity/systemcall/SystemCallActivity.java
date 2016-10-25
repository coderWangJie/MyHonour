package com.wj.myhonour.demo.activity.systemcall;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;

import com.wj.myhonour.R;
import com.wangj.baselibrary.basic.BaseActivity;
import com.wj.myhonour.util.DialogUtil;

public class SystemCallActivity extends BaseActivity implements View.OnClickListener {

    private final int Permission_Call = 300;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SystemCallActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_system_call;
    }

    @Override
    public void setTitleBar() {
        setTitleWithString("系统API调用");
    }

    @Override
    public void initView() {
        findViewById(R.id.btn_SysCall1).setOnClickListener(this);

        findViewById(R.id.btn_SysCall2).setOnClickListener(this);

        findViewById(R.id.btn_Contract).setOnClickListener(this);

        findViewById(R.id.btn_Camera).setOnClickListener(this);

        findViewById(R.id.btn_Video).setOnClickListener(this);

        findViewById(R.id.btn_audio).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_SysCall1:
                EditText phoneNum1 = (EditText) findViewById(R.id.et_phone1);
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNum1.getText().toString()));
                startActivity(intent);
                break;

            case R.id.btn_SysCall2:
                checkSomePressmiss();
                break;

            case R.id.btn_Contract:
                intent.setClass(this, ContractCallActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_Camera:
                break;

            case R.id.btn_Video:
                break;

            case R.id.btn_audio:
                break;

        }
    }

    /**
     * 检查权限
     */
    private void checkSomePressmiss() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                DialogUtil.showHintDialog(this, "打电话必须赋予应用通话权限", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUtil.dismissDialog();
                        ActivityCompat.requestPermissions(SystemCallActivity.this, new String[]{Manifest.permission.CALL_PHONE}, Permission_Call);
                    }
                });
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, Permission_Call);
            }
        } else {
            testCall();
        }
    }

    private void testCall() {
        EditText phoneNum2 = (EditText) findViewById(R.id.et_phone2);
//        Intent intent = new Intent(Intent.ACTION_CALL);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNum2.getText().toString()));
        startActivity(intent);
    }

    /**
     * 权限操作回调
     * @param requestCode 自定义的权限请求区分码
     * @param permissions 申请的权限列表
     * @param grantResults 权限申请结果列表
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (Permission_Call == requestCode) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                testCall();
            } else {
                toast("未获得权限！");
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}

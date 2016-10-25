package com.wj.myhonour.demo.activity.systemcall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;

import com.wj.myhonour.R;
import com.wangj.baselibrary.basic.BaseActivity;
import com.wj.myhonour.util.DialogUtil;

public class ContractCallActivity extends BaseActivity implements View.OnClickListener {

    private final int REQUEST_SELECT_CONTRACT = 100;
    private final int REQUEST_WRITE_CONTRACT = 200;

    @Override
    public int getContentViewId() {
        return R.layout.activity_contract_call;
    }

    @Override
    public void setTitleBar() {
        setTitleWithString("通讯录相关");
    }

    @Override
    public void initView() {
        findViewById(R.id.btn_selectContract).setOnClickListener(this);

        findViewById(R.id.btn_writeContract).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_selectContract:
                checkMyPermission(Manifest.permission.READ_CONTACTS, REQUEST_SELECT_CONTRACT);
                break;

            case R.id.btn_writeContract:
                checkMyPermission(Manifest.permission.WRITE_CONTACTS, REQUEST_WRITE_CONTRACT);

//                EditText etName = (EditText) findViewById(R.id.et_contractName);
//                EditText etPhone = (EditText) findViewById(R.id.et_contractPhone);
//                EditText etMail = (EditText) findViewById(R.id.et_contractMail);

                break;
        }
    }

    private void checkMyPermission(final String permissionName, final int requestCode) {
        if (ActivityCompat.checkSelfPermission(this, permissionName) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissionName)) {
                DialogUtil.showHintDialog(this, "我真的需要权限", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUtil.dismissDialog();
                        ActivityCompat.requestPermissions(ContractCallActivity.this, new String[]{permissionName}, requestCode);
                    }
                });
            } else {
                ActivityCompat.requestPermissions(this, new String[]{permissionName}, requestCode);
            }
        } else {
            switch (requestCode) {
                case REQUEST_SELECT_CONTRACT:
                    gotoSelectContract();
                    break;
                case REQUEST_WRITE_CONTRACT:
                    toast("写入联系人权限——已拥有");
                    break;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_SELECT_CONTRACT:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    gotoSelectContract();
                } else {
                    toast("获取权限失败");
                }
                break;
            case REQUEST_WRITE_CONTRACT:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    toast("写入联系人权限——SUCCESS");
                } else {
                    toast("写入联系人权限——FAIL");
                }
                break;

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void gotoSelectContract() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, REQUEST_SELECT_CONTRACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_SELECT_CONTRACT:
                if (resultCode == RESULT_OK) {
                    // TODO 这么做是不是太繁琐了？
                    Cursor cursor = getContentResolver().query(data.getData(),
                            null, null, null, null);
                    int contactIdIndex = 0;
                    int nameIndex = 0;

                    if (cursor.getCount() > 0) {
                        contactIdIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID);
                        nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                    }
                    while (cursor.moveToNext()) {

                        StringBuilder stringBuild = new StringBuilder();

                        String contactId = cursor.getString(contactIdIndex);
                        String name = cursor.getString(nameIndex);
                        Log.i("WangJ", contactId);
                        Log.i("WangJ", name);
                        stringBuild.append(contactId).append("\n").append(name);

                        /*
                         * 查找该联系人的phone信息
                         */
                        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId,
                                null, null);
                        int phoneIndex = 0;
                        if (phones.getCount() > 0) {
                            phoneIndex = phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        }
                        while (phones.moveToNext()) {
                            String phoneNumber = phones.getString(phoneIndex);
                            Log.i("WangJ", phoneNumber);
                            stringBuild.append("\n").append(phoneNumber);
                        }

                        /*
                         * 查找该联系人的email信息
                         */
                        Cursor emails = getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                                null,
                                ContactsContract.CommonDataKinds.Email.CONTACT_ID + "=" + contactId,
                                null, null);
                        int emailIndex = 0;
                        if (emails.getCount() > 0) {
                            emailIndex = emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA);
                        }
                        while (emails.moveToNext()) {
                            String email = emails.getString(emailIndex);
                            Log.i("WangJ", email);
                            stringBuild.append("\n").append(email);
                        }

                        toast(stringBuild.toString());
                    }
                }
                break;
            case 0:
                break;
        }
    }
}

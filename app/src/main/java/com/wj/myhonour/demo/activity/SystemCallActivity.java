package com.wj.myhonour.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import com.wj.myhonour.R;
import com.wj.myhonour.basis.BaseActivity;

public class SystemCallActivity extends BaseActivity implements View.OnClickListener {

    private final int REQUEST_CONTRACT = 100;

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
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
                break;

            case R.id.btn_SysCall2:
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
                break;

            case R.id.btn_Contract:
                intent.setAction(Intent.ACTION_PICK);
                intent.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, REQUEST_CONTRACT);
                break;

            case R.id.btn_Camera:
                break;

            case R.id.btn_Video:
                break;

            case R.id.btn_audio:
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CONTRACT:
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
                        String contactId = cursor.getString(contactIdIndex);
                        String name = cursor.getString(nameIndex);
                        Log.i("WangJ", contactId);
                        Log.i("WangJ", name);

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
                        }

                    }
                }
                break;
            case 0:
                break;
        }
    }
}

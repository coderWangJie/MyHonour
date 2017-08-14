package com.wj.myhonour.basis;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * WangJ jie581825@yeah.net
 * Created on 2016/9/21
 * Modified:
 * Modified on
 */
public class MyHonourApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}

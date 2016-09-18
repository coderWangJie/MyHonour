package com.wj.myhonour.basis;

import android.app.Activity;
import android.os.Bundle;

/**
 * 普通基类
 * <p/>
 * WangJ jie581825@yeah.net
 * Created on 2016/9/14
 * Modified:
 * Modified on
 */
public abstract class BaseActivity extends Activity {


    /**
     * Activity界面布局ID
     *
     * @return 布局资源ID
     */
    public abstract int getContentViewId();

    /**
     *
     */
    public abstract void initView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewId() != 0) {
            setContentView(getContentViewId());
        }

        initView();
    }

    /**
     *
     */
    protected void requestHttp(){

    }
}

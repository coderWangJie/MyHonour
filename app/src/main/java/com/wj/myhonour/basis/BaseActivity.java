package com.wj.myhonour.basis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wj.myhonour.R;
import com.wj.myhonour.constant.AppConstant;

/**
 * 通用基类
 *
 * @author WangJ jie581825@yeah.net
 *         Created on 2016/9/14
 *         Modified:
 *         Modified on
 */
public abstract class BaseActivity extends Activity {

    private Toast toast;

    /**
     * 设置Activity界面布局ID
     *
     * @return 布局资源ID
     */
    public abstract int getContentViewId();

    /**
     * 代码规范，在此方法中设置标题栏
     */
    public abstract void setTitleBar();

    /**
     * 代码规范，由此方法开始功能初始化
     */
    public abstract void initView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewId() != 0) {
            setContentView(getContentViewId());
        }

        setTitleBar();
        initView();
    }

    /**
     * 设置标题栏左侧按钮方法1：无文字，默认点击后返回
     */
    protected void setTitleLeft() {
        LinearLayout titleLeft = (LinearLayout) findViewById(R.id.area_titleLeft);
        titleLeft.setPadding(15, 0, 80, 0); // 由于没有文字时返回图标小，需要加大响应区域
        titleLeft.setVisibility(View.VISIBLE);
        titleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(AppConstant.resultCode_DEFAULT);
                finish();
            }
        });

    }

    /**
     * 设置标题栏左侧按钮方法2：可设置文字，默认点击后返回
     */
    protected void setTitleLeft(String name) {
        LinearLayout titleLeft = (LinearLayout) findViewById(R.id.area_titleLeft);
        titleLeft.setVisibility(View.VISIBLE);
        TextView tvTitleleft = (TextView) findViewById(R.id.tv_titleLeft);
        tvTitleleft.setVisibility(View.VISIBLE);
        tvTitleleft.setText(name);
        titleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(AppConstant.resultCode_DEFAULT);
                finish();
            }
        });
    }

    /**
     * 设置标题栏左侧按钮方法3：可设置文字、点击响应
     */
    protected void setTitleLeft(String name, View.OnClickListener listener) {
        LinearLayout titleLeft = (LinearLayout) findViewById(R.id.area_titleLeft);
        titleLeft.setVisibility(View.VISIBLE);
        TextView tvTitleleft = (TextView) findViewById(R.id.tv_titleLeft);
        tvTitleleft.setVisibility(View.VISIBLE);
        tvTitleleft.setText(name);
        titleLeft.setOnClickListener(listener);
    }

    /**
     * 设置标题栏标题文字
     *
     * @param titleStr 标题文字
     */
    protected void setTitleWithString(String titleStr) {
        ((TextView) findViewById(R.id.tv_titleMiddle)).setText(titleStr);
    }

    /**
     * 设置标题栏标题文字
     *
     * @param stringId 标题文字ID
     */
    protected void setTitleWithId(int stringId) {
        ((TextView) findViewById(R.id.tv_titleMiddle)).setText(getResources().getString(stringId));
    }

    /**
     * 设置TitleBar右侧 文字显示、点击响应
     * @param rightStr 显示文字
     * @param listener 点击响应
     */
    protected void setTitleRight(String rightStr, View.OnClickListener listener) {
        TextView tvTitleRight = (TextView) findViewById(R.id.tv_titleRight);
        tvTitleRight.setVisibility(View.VISIBLE);
        tvTitleRight.setText(rightStr);
        findViewById(R.id.area_titleRight).setOnClickListener(listener);
    }

    /**
     * 设置TitleBar右侧 显示图片ID、点击响应
     * @param drawableId 图片资源ID
     * @param listener 点击响应
     */
    protected void setTitleRight(int drawableId, View.OnClickListener listener) {
        ImageView imgTitleRight = (ImageView) findViewById(R.id.img_titleRight);
        imgTitleRight.setVisibility(View.VISIBLE);
        imgTitleRight.setImageResource(drawableId);
        findViewById(R.id.area_titleRight).setOnClickListener(listener);
    }

    /**
     *
     */
    protected void requestHttp() {

    }

    /**
     * 自定义唯一Toast展示，当前有已存在的Toast时直接替换其文字
     *
     * @param message 内容
     */
    protected void toast(String message) {
        View toastView = getLayoutInflater().inflate(R.layout.toast, null);
        TextView tvToast = (TextView) toastView.findViewById(R.id.tv_toast);
        if (toast == null) {
            toast = new Toast(this);
        }
        tvToast.setText(new StringBuilder("\t\t").append(message));
        toast.setView(toastView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (event.getAction() == KeyEvent.ACTION_DOWN) {
//            switch (keyCode) {
//                case KeyEvent.KEYCODE_BACK:
//                    findViewById(R.id.area_titleLeft).performClick();
//                    break;
//
//                case KeyEvent.KEYCODE_HOME:
//                    toast("Home键");
//                    break;
//
//                case KeyEvent.KEYCODE_MENU:
//                    toast("Menu键");
//                    break;
//            }
//        }
//        return false;
//    }

    /**
     * 基类 BaseActivity 定制 Back 键响应
     * 若要改变 Back 键的功能，请在具体 Activity中重写 onBackPressed() 方法
     */
    @Override
    public void onBackPressed() {
        if (findViewById(R.id.area_titleLeft) != null) { // 有标题栏返回按钮时，Back键采用标题栏返回键响应
            findViewById(R.id.area_titleLeft).performClick();
        } else { // 无标题栏时，Back键默认返回
            setResult(AppConstant.resultCode_DEFAULT);
            finish();
        }

    }
}

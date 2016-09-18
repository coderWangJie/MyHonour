package com.wj.myhonour.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import com.wj.myhonour.R;

/**
 * 对话框显示工具类
 *
 * @author WangJ jie581825@yeah.net
 *         Created on 2016/9/14
 */
public class DialogUtil {

    private static Dialog dialog;

    public static void showHintDialog(){

    }

    /**
     * 创建对话框
     */
    private static Dialog createDialog(Context context, View view,
                                       boolean cancelable) {
        dialog = new Dialog(context, R.style.MyDialogStyle);
        dialog.setContentView(view);
        dialog.setCancelable(cancelable);
        return dialog;
    }
}

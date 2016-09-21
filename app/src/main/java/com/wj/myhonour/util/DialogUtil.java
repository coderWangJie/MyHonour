package com.wj.myhonour.util;

import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wj.myhonour.R;

/**
 * 对话框显示工具类
 *
 * @author WangJ jie581825@yeah.net
 *         Created on 2016/9/14
 */
public class DialogUtil {

    private static Dialog dialog;
    private static View hintView;

    public static void showHintDialog(Context context, String content) {
        showHintDialog(context, "温馨提示", content, "确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog();
            }
        });
    }

    public static void showHintDialog(Context context, String content, View.OnClickListener listener) {
        showHintDialog(context, "温馨提示", content, "确定", listener);
    }

    public static void showHintDialog(Context context, String title, String content, String btnString,
                                      View.OnClickListener listener) {
        prepareHintView(context, title, content, btnString, listener);
        dialog = createDialog(context, hintView, false);
        dialog.show();
    }

    /**
     * 创建对话框
     */
    private static Dialog createDialog(Context context, View view, boolean cancelable) {
        if (dialog == null) {
            dialog = new Dialog(context, R.style.MyDialogStyle);
        }
        dialog.setContentView(view);
        dialog.setCancelable(cancelable);
        return dialog;
    }

    /**
     * 准备提示框View（带按钮响应监听）
     */
    private static View prepareHintView(final Context context, String title, String content, String btnString,
                                        View.OnClickListener listener) {
        hintView = LayoutInflater.from(context).inflate(R.layout.dialog_hint, null);

        ((TextView) hintView.findViewById(R.id.tv_title)).setText(title);
        TextView tvContent = (TextView) hintView.findViewById(R.id.tv_content);
        tvContent.setMovementMethod(new ScrollingMovementMethod());

        tvContent.setText(content);
        Button btnIKnow = (Button) hintView.findViewById(R.id.btn_iknow);

        btnIKnow.setText(btnString);
        if (listener != null) {
            btnIKnow.setOnClickListener(listener);
        }

        return hintView;
    }

    public static void showDecideDialog(Context context,
                                        String content,
                                        View.OnClickListener cancelListener,
                                        View.OnClickListener confirmListener) {
        prepareDecideView(context, "温馨提示", content, "取消", cancelListener, "确定", confirmListener);
        dialog = createDialog(context, hintView, false);
        dialog.show();
    }

    public static void showDecideDialog(Context context,
                                        String title,
                                        String content,
                                        String confirmStr,
                                        View.OnClickListener confirmListener) {
        prepareDecideView(context, title, content, "取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog();
            }
        }, confirmStr, confirmListener);
        dialog = createDialog(context, hintView, false);
        dialog.show();
    }

    public static void showDecideDialog(Context context,
                                        String title,
                                        String content,
                                        String cancelStr,
                                        View.OnClickListener cancelListener,
                                        String confirmStr,
                                        View.OnClickListener confirmListener) {
        prepareDecideView(context, title, content, cancelStr, cancelListener, confirmStr, confirmListener);
        dialog = createDialog(context, hintView, false);
        dialog.show();
    }

    /**
     * 准备选择对话框View
     */
    private static View prepareDecideView(Context context,
                                          String title,
                                          String content,
                                          String cancelStr, View.OnClickListener cancelListener,
                                          String confirmStr, View.OnClickListener confirmListener) {
        hintView = LayoutInflater.from(context).inflate(
                R.layout.dialog_decide, null);
        TextView tvTitle = (TextView) hintView.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        TextView tvContent = (TextView) hintView
                .findViewById(R.id.tv_content);
        tvContent.setText(content);
        Button btnCancel = (Button) hintView.findViewById(R.id.btn_cancel);
        btnCancel.setText(cancelStr);
        btnCancel.setOnClickListener(cancelListener);
        Button btnConfirm = (Button) hintView.findViewById(R.id.btn_confirm);
        btnConfirm.setText(confirmStr);
        btnConfirm.setOnClickListener(confirmListener);
        return hintView;
    }

    public static void dismissDialog() {
        if (dialog != null
                && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }
}

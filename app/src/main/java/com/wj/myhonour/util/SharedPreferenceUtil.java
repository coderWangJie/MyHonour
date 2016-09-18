package com.wj.myhonour.util;

import android.content.Context;

/**
 * SharedPreference工具类
 *
 * @author WangJ
 *         2016.05.17
 */
public class SharedPreferenceUtil {
    private static String SP_FILE_NAME = ""; //SharePreference文件名

    private static String SP_USER_ID = "userId";
    private static String SP_ = ""; // 留用

	/*基础方法的封装*/

    /**
     * 向SP文件中 更新/添加 String变量
     *
     * @param context 上下文
     * @param name    String变量在SP文件中的变量名
     * @param value   字符串的值
     */
    private static void putSpString(Context context, String name, String value) {
        context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
                .edit().putString(name, value).commit();
    }

    /**
     * 从SP文件中获取String变量的值
     *
     * @param context 上下文
     * @param name    String变量在SP文件中的变量名
     * @return String
     */
    private static String getSpString(Context context, String name) {
        return context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
                .getString(name, "null");
    }

    /**
     * 向SP文件中 更新/添加 boolean变量
     *
     * @param context 上下文
     * @param name    boolean变量在SP文件中的变量名
     * @param value   boolean变量的值
     */
    private static void putSpBoolean(Context context, String name, boolean value) {
        context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
                .edit().putBoolean(name, value).commit();
    }

    /**
     * 从SP文件中获取boolean变量的值
     *
     * @param context 上下文
     * @param name    boolean变量在SP文件中的变量名
     * @return boolean
     */
    private static boolean getSpBoolean(Context context, String name) {
        return context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
                .getBoolean(name, false);
    }
	
	/*具体方法的实现*/
}

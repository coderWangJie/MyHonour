package com.wj.myhonour.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 日志打印工具类
 *
 * @author WangJ jie581825@yeah.net
 *         Created on 2016/9/14
 */
public class LogUtil {
    private static String TAG = "MyHonour";

    /**
     * 标准 Log 打印
     *
     * @param tag     Tag 标识
     * @param message 打印内容
     */
    public static void logStandard(String tag, String message) {
        Log.d(tag, message);
    }

    /**
     * Log 打印 String 信息
     *
     * @param message 打印内容
     */
    public static void log(String message) {
        Log.d(TAG, message);
    }

    /**
     * Log 打印 ArrayList<String> 类型数据
     *
     * @param list 源数据
     */
    public static void log(ArrayList<Object> list) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("size:").append(list.size());
        for (Object ob : list) {
            strBuilder.append("\n").append(list.indexOf(ob)).append(": ").append(ob);
        }
        Log.d(TAG, strBuilder.toString());
    }

    /**
     * Log 打印 HashMap 类型数据
     *
     * @param map HashMap<Object, Object>源数据
     */
    public static void log(HashMap<Object, Object> map) {
        StringBuilder strBuilder = new StringBuilder();
        for (HashMap.Entry entry : map.entrySet()) {
            strBuilder.append("\n").append(entry.getKey()).append(": ").append(entry.getValue());
        }
        Log.d(TAG, strBuilder.toString());
    }

}

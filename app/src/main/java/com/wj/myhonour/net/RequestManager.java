package com.wj.myhonour.net;

import android.os.AsyncTask;
import android.os.SystemClock;

import com.wj.myhonour.util.LogUtil;

import java.util.ArrayList;

/**
 * WangJ jie581825@yeah.net
 * Created on 2016/9/18
 */
public class RequestManager {
    private static RequestManager instance;
    private AsyncTask currentTask;
    private static ArrayList<AsyncTask> queue = new ArrayList<>();

    public static RequestManager getInstance() {
        if (instance == null) {
            synchronized (RequestManager.class) {
                if (instance == null) {
                    instance = new RequestManager();
                }
            }
        }
        return instance;
    }

    public void requestPost(String str) {
        currentTask = new HttpPostTask(str).execute("");
    }

    public void killCurrentTask() {
        if (currentTask != null) {
            currentTask.cancel(true);
            currentTask = null;
        }
    }

    public void killAll() {
        for (AsyncTask task : queue) {
            if (task != null) {
                task.cancel(true);
            }
        }
    }

    /**
     *
     */
    public static class HttpPostTask extends AsyncTask<String, String, String> {

        private String str;

        public HttpPostTask(String str) {
            this.str = str;
        }

        @Override
        protected void onPreExecute() {
            queue.add(this);
            super.onPreExecute();
            LogUtil.logE("Pre" + str);
            SystemClock.sleep(1000);
        }

        @Override
        protected String doInBackground(String... params) {
            SystemClock.sleep(1000);
            LogUtil.logE("doInBackground" + str);
            return "haha";
        }

        @Override
        protected void onPostExecute(String result) {
            SystemClock.sleep(1000);
            LogUtil.logE("result" + str);
            StringBuilder builder = new StringBuilder();
            builder.append("运行时个数：").append(queue.size());
            queue.remove(this);
            builder.append("完成后时个数：").append(queue.size());
            LogUtil.logE(builder.toString());
        }
    }

}

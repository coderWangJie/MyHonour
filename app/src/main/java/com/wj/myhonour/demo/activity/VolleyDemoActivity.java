package com.wj.myhonour.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wj.myhonour.R;
import com.wangj.baselibrary.basic.BaseActivity;
import com.wj.myhonour.util.DialogUtil;

public class VolleyDemoActivity extends BaseActivity implements View.OnClickListener {

    RequestQueue quenen;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, VolleyDemoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_http_demo;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {
        quenen = Volley.newRequestQueue(this); // 每个Activity创建一个RequestQueue足够用了

        findViewById(R.id.btn_stringRequest1).setOnClickListener(this);
        findViewById(R.id.btn_stringRequest2).setOnClickListener(this);
        findViewById(R.id.btn_imageRequest).setOnClickListener(this);
        findViewById(R.id.btn_imageLoader).setOnClickListener(this);
        findViewById(R.id.btn_networkImageView).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_stringRequest1:
                testStringRequest();
                break;
            case R.id.btn_stringRequest2:
                testStringRequest2();
                break;
            case R.id.btn_imageRequest:
                testImageRequest();
                break;
            case R.id.btn_imageLoader:
                testImageLoader();
                break;
            case R.id.btn_networkImageView:
                testNetworkImageView();
                break;
        }
    }

    private void testStringRequest() {
        StringRequest stringRequest = new StringRequest("https://www.baidu.com/", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                DialogUtil.showHintDialog(VolleyDemoActivity.this, s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                DialogUtil.showHintDialog(VolleyDemoActivity.this, volleyError.getMessage());
            }
        });
        quenen.add(stringRequest);
    }

    private void testStringRequest2() {
        // TODO POST时需要特殊处理
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                DialogUtil.showHintDialog(VolleyDemoActivity.this, volleyError.getMessage());
            }
        });
        quenen.add(stringRequest);
    }

    private void testImageRequest() {
        ImageRequest imageRequest = new ImageRequest("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1474435423460&di=74d5d3fdadf29b12d9846a2bd05291e9&imgtype=jpg&src=http%3A%2F%2Ffiles.jb51.net%2Fscimg%2Fpng%2F20100803%2FTango-Emote-05.png",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        ((ImageView) findViewById(R.id.img_request)).setImageBitmap(bitmap);
                    }
                },
                0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ALPHA_8,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });
        quenen.add(imageRequest);
    }

    private void testImageLoader() {
        ImageLoader imageLoader = new ImageLoader(quenen, new ImageLoader.ImageCache() { //TODO ImageLoader的优点在于缓存，但是这里还没学习
            @Override
            public Bitmap getBitmap(String s) {
                return null;
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {

            }
        });

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(
                (ImageView) findViewById(R.id.img_loader),
                R.mipmap.ic_launcher,
                R.drawable.ic_flower);
        imageLoader.get("http://img1.imgtn.bdimg.com/it/u=367740859,2357929488&fm=21&gp=0.jpg",
                listener,
                200, 200);

    }

    private void testNetworkImageView() {

    }
}

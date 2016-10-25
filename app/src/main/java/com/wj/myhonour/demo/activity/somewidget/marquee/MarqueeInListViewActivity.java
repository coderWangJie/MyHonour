package com.wj.myhonour.demo.activity.somewidget.marquee;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wj.myhonour.R;
import com.wangj.baselibrary.basic.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MarqueeInListViewActivity extends BaseActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MarqueeInListViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_marquee_in_list_view;
    }

    @Override
    public void setTitleBar() {

    }

    @Override
    public void initView() {
        ListView listView = (ListView) findViewById(R.id.list_marquee);
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map;
        for (int i = 0; i < 20; i++) {
            map = new HashMap<>();
            map.put("title", "TITLE" + i);
            map.put("content", "This is some description about TITLE" + i + ", to test whether Marquee can work!");
            list.add(map);
        }
        MyAdapter adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MyAdapter) parent.getAdapter()).setIndex(position);
            }
        });
    }


    class MyAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<HashMap<String, String>> list;
        private int index = 0;

        public MyAdapter(Context content, ArrayList<HashMap<String, String>> list) {
            this.context = content;
            this.list = list;
        }

        /**
         * 设置选中项
         * @param index 选中项的position
         */
        public void setIndex(int index) {
            this.index = index;
            //通知adapter数据改变需要重新加载
            notifyDataSetChanged(); //必须有的一步
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_marquee_list,
                        parent,
                        false);
                holder = new ViewHolder();
                holder.imgLogo = (ImageView) convertView.findViewById(R.id.img_logo);
                holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
                holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
                holder.imgSelected = (ImageView) convertView.findViewById(R.id.img_selected);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            HashMap<String, String> map = list.get(position);
            holder.imgLogo.setImageResource(R.drawable.ic_flower);
            holder.tvTitle.setText(map.get("title"));
            holder.tvContent.setText(map.get("content"));
            if (position == index) {
                holder.tvContent.setSelected(true);
                holder.imgSelected.setVisibility(View.VISIBLE);
            } else {
                holder.tvContent.setSelected(false);
                holder.imgSelected.setVisibility(View.INVISIBLE);
            }

            return convertView;
        }

        public class ViewHolder {
            private ImageView imgLogo;
            private TextView tvTitle;
            private TextView tvContent;
            private ImageView imgSelected;
        }
    }

}

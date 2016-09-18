package com.wj.myhonour.adapters;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private ArrayList<HashMap<String, String>> datas;
	private Context context;
	private int currentItem = -1; // 用于记录点击的 Item 的 position，是控制 item 展开隐藏部分的核心

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					999, parent, false);
			holder = new ViewHolder();
			holder.tvPhoneType = (TextView) convertView
					.findViewById(99);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		HashMap<String, String> item = datas.get(position);
		
		// 注意：我们在此给响应点击事件的区域（我的例子里是 showArea 的线性布局）添加Tag，为了记录点击的 position，我们正好用 position 设置 Tag
		holder.tvPhoneType.setTag(position);
		
		holder.tvPhoneType.setText(item.get("phoneType"));

		//根据 currentItem 记录的点击位置来设置"对应Item"的可见性（在list依次加载列表数据时，每加载一个时都看一下是不是需改变可见性的那一条）
		if (currentItem == position) {
			holder.tvPhoneType.setVisibility(View.VISIBLE);
		} else {
			holder.tvPhoneType.setVisibility(View.GONE);
		}

		holder.tvPhoneType.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				//用 currentItem 记录点击位置
				int tag = (Integer) view.getTag();
				if (tag == currentItem) { //再次点击
					currentItem = -1; //给 currentItem 一个无效值
				} else {
					currentItem = tag;
				}
				//通知adapter数据改变需要重新加载
				notifyDataSetChanged(); //必须有的一步
			}
		});
		
		return convertView;
	}

	private static class ViewHolder {
		private TextView tvPhoneType;
	}

}

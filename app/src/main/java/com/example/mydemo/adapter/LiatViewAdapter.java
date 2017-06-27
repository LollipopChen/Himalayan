package com.example.mydemo.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.mydemo.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TS-YFZX-CQE on 2017/6/12.
 */

public class LiatViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflate;
    private String[] text_arr = {"付费精品","分享赚钱","全民朗读","听友圈","大咖主播","问答","商城","游戏","活动"};
    private int[] icon = {R.drawable.ic_payfind,R.drawable.ic_sharemoney,
                            R.drawable.ic_mic,R.drawable.ic_listener,
                            R.drawable.ic_micpeople,R.drawable.ic_qa,
                            R.drawable.ic_mall,R.drawable.ic_game,
                            R.drawable.ic_activity};
    private Map<String,Integer> map = new HashMap<String, Integer>();

    public LiatViewAdapter(Context context) {
        this.mInflate = LayoutInflater.from(context);
        this.mContext = context;
        initData();
    }

    private void initData() {
        map.put(text_arr[0],icon[0]);
        map.put(text_arr[1],icon[1]);
        map.put(text_arr[2],icon[2]);
        map.put(text_arr[3],icon[3]);
        map.put(text_arr[4],icon[4]);
        map.put(text_arr[5],icon[5]);
        map.put(text_arr[6],icon[6]);
        map.put(text_arr[7],icon[7]);
        map.put(text_arr[8],icon[8]);
    }

    @Override
    public int getCount() {
        return text_arr.length;
    }

    @Override
    public Object getItem(int position) {
        return text_arr[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            //加载自定义布局
            convertView = mInflate.inflate(R.layout.listview_item,null);
            viewHolder.tittle = (TextView) convertView.findViewById(R.id.listview_tv);
            viewHolder.hint_tv = (TextView) convertView.findViewById(R.id.listview_hint);
            viewHolder.view = (View) convertView.findViewById(R.id.view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /* 设置内容 */
        viewHolder.tittle.setText(text_arr[position]);
//        Drawable drawable = mContext.getResources().getDrawable(map.get(text_arr[position]));
        Drawable drawable = mContext.getResources().getDrawable(icon[position]);
        //必须设置图片大小，否则不显示
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        viewHolder.tittle.setCompoundDrawablePadding(20);
        viewHolder.tittle.setCompoundDrawables(drawable,null,null,null);

        /* 设置提示信息 */
        if (position == 0){
            viewHolder.hint_tv.setHint("5折购课程，最后一天！");
        }else if (position == 2){
            viewHolder.hint_tv.setHint("如何用英文说爱你");
            drawable = mContext.getResources().getDrawable(R.drawable.ic_love);
            //必须设置图片大小，否则不显示
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            viewHolder.hint_tv.setCompoundDrawables(null,null,drawable,null);
            viewHolder.hint_tv.setCompoundDrawablePadding(10);
        }else if (position == 7){
            viewHolder.hint_tv.setHint("战斗暴龙兽再度现身！");
            drawable = mContext.getResources().getDrawable(R.drawable.ic_guaishou);
            //必须设置图片大小，否则不显示
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            viewHolder.hint_tv.setCompoundDrawables(null,null,drawable,null);
            viewHolder.hint_tv.setCompoundDrawablePadding(10);
        }
        //设置listview的间隔
        if (position == 1 || position == 3 || position == 5|| position == 7 || position == 8){
            viewHolder.view.setVisibility(View.GONE);
        }

        return convertView;
    }

    static class ViewHolder{
        public TextView tittle;//标题
        public TextView hint_tv;//提示信息
        public View view;//间隔
    }
}

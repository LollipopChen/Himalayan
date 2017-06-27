package com.example.mydemo.activity.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mydemo.R;
import com.example.mydemo.adapter.LiatViewAdapter;

public class FoundFragment extends Fragment implements AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    /** 整体view **/
    private View view;
    /** listview列表 **/
    private ListView mListview;
    /** 下拉刷新 **/
    private SwipeRefreshLayout mRefreshLayout;
    /** 适配器 **/
    private LiatViewAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_found, container, false);

        initView();
        initData();
        initEvent();
        return view;
    }

    /** 初始化控件 **/
    private void initView() {
        mListview = (ListView) view.findViewById(R.id.found_listview);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.found_swrefresh);
    }

    /** 初始化数据 **/
    private void initData(){
        mAdapter = new LiatViewAdapter(getActivity());
        mListview.setAdapter(mAdapter);
        //设置下拉进度条的背景颜色
        mRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.progressbar_bg);
        //设置下拉进度条转圈的颜色
        mRefreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.colorPrimary);
    }

    /** 交互事件处理 **/
    private void initEvent(){
        //设置item的点击事件
        mListview.setOnItemClickListener(this);
        //设置下拉刷新事件
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),"点击的是"+ mAdapter.getItem(position),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(),"刷新完毕",Toast.LENGTH_SHORT).show();
                //加载数据完毕后设为不刷新状态，将下拉进度条收起来
                mRefreshLayout.setRefreshing(false);
            }
        },1000);
    }
}

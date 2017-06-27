package com.example.mydemo.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mydemo.R;
import com.example.mydemo.fragment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TS-YFZX-CQE on 2017/6/9.
 */

public class HomeFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> mList = new ArrayList<>();
    private MyAdapter mAdapter;
    private String[] tittle = {"热门","分类","精品","直播","广播"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_layout, container, false);

        initView();

        return view;
    }

    /* 初始化控件和数据 */
    private void initView() {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        initData();
        mAdapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(mAdapter);
        //将导航栏和viewpager捆绑
//        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    private void initData() {
        tabLayout.addTab(tabLayout.newTab().setText(tittle[0]));
        tabLayout.addTab(tabLayout.newTab().setText(tittle[1]));
        tabLayout.addTab(tabLayout.newTab().setText(tittle[2]));
        tabLayout.addTab(tabLayout.newTab().setText(tittle[3]));
        tabLayout.addTab(tabLayout.newTab().setText(tittle[4]));


        mList.add(new HotFragment());//热门
        mList.add(new ClassificationFragment());//分类
        mList.add(new GoodsFragment());//精品
        mList.add(new LiveFragment());//直播
        mList.add(new RadioFragment());//广播
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);

        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {

            return tittle.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tittle[position];
        }
    }
}

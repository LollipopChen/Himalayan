package com.example.mydemo.com.example.mydemo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydemo.R;
import com.example.mydemo.activity.fragment.FoundFragment;
import com.example.mydemo.activity.fragment.HomeFragment;
import com.example.mydemo.activity.fragment.MineFragment;
import com.example.mydemo.activity.fragment.ReadFragment;
import com.example.mydemo.util.InfoUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /** 底部导航栏 **/
    private BottomNavigationView navigation;
    /** 顶部的工具条 **/
    private ActionBar actionBar;
    /** 信息 **/
    private ImageButton imgBtn_message;
    /** 离线 **/
    private ImageButton imgBtn_off_line;
    /** 下载 **/
    private ImageButton imgBtndownload;
    /** 搜索 **/
    private EditText ed_search;
    /** 标题 **/
    private TextView actionBar_tv;
    /** 扫一扫 **/
    private ImageButton imgBtn_scan;
    /** 搜索 layout **/
    private RelativeLayout acRellayout;;
    /** 用于放fragment的布局 **/
    private FrameLayout mFrameLayout;
    /** fragmentmanager 动态管理器**/
    private FragmentManager fm;
    /** BottomNavigationView当前的页码 **/
    private int pageNum = 0 ;

    /** 底部工具条的监听事件 **/
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home://首页
                    replaceFragment(new HomeFragment());
                    acRellayout.setVisibility(View.VISIBLE);
                    actionBar_tv.setVisibility(View.GONE);
                    imgBtndownload.setVisibility(View.VISIBLE);
                    imgBtn_scan.setVisibility(View.GONE);
                    imgBtn_off_line.setVisibility(View.VISIBLE);
                    return true;

                case R.id.navigation_read://订阅
                    replaceFragment(new ReadFragment());
                    actionBar_tv.setVisibility(View.VISIBLE);
                    acRellayout.setVisibility(View.GONE);
                    actionBar_tv.setText(R.string.title_read);
                    imgBtndownload.setVisibility(View.VISIBLE);
                    imgBtn_scan.setVisibility(View.GONE);
                    imgBtn_off_line.setVisibility(View.VISIBLE);;
                    return true;

                case R.id.navigation_start://播放

                    return true;

                case R.id.navigation_found://发现
                    replaceFragment(new FoundFragment());
                    actionBar_tv.setVisibility(View.VISIBLE);
                    acRellayout.setVisibility(View.GONE);
                    actionBar_tv.setText(R.string.title_found);
                    imgBtndownload.setVisibility(View.VISIBLE);
                    imgBtn_scan.setVisibility(View.GONE);
                    imgBtn_off_line.setVisibility(View.VISIBLE);
                    return true;

                case R.id.navigation_mine://我的
                    replaceFragment(new MineFragment());
                    actionBar_tv.setVisibility(View.INVISIBLE);
                    acRellayout.setVisibility(View.GONE);
                    imgBtndownload.setVisibility(View.GONE);
                    imgBtn_scan.setVisibility(View.VISIBLE);
                    imgBtn_off_line.setVisibility(View.INVISIBLE);

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    /** 更换Fragment **/
    private void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content,fragment);
//        ft.addToBackStack(null);
        ft.commit();
    }

    /** 初始化控件 **/
    private void initView() {
        mFrameLayout = (FrameLayout) findViewById(R.id.content);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
       //自定义actionBar的布局
        actionBar = getSupportActionBar();
        actionBar.show();//显示actionbar
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);
        imgBtn_message = (ImageButton) actionBar.getCustomView().findViewById(R.id.message);
        ed_search = (EditText) actionBar.getCustomView().findViewById(R.id.search_ed);
        acRellayout = (RelativeLayout) actionBar.getCustomView().findViewById(R.id.search_layout);
        imgBtn_off_line = (ImageButton) actionBar.getCustomView().findViewById(R.id.off_line);
        imgBtndownload = (ImageButton) actionBar.getCustomView().findViewById(R.id.download);
        actionBar_tv = (TextView) actionBar.getCustomView().findViewById(R.id.actionbar_tv);
        imgBtn_scan = (ImageButton) actionBar.getCustomView().findViewById(R.id.scan);

    }

    /** 交互事件处理 **/
    private void initEvent(){
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        imgBtn_message.setOnClickListener(this);
        imgBtn_off_line.setOnClickListener(this);
        imgBtndownload.setOnClickListener(this);
        imgBtn_scan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message://信息
                Toast.makeText(this,"信息",Toast.LENGTH_SHORT).show();
                break;

            case R.id.off_line://离线
                Toast.makeText(this,"离线",Toast.LENGTH_SHORT).show();
                break;

            case R.id.download://下载
                Toast.makeText(this,"下载",Toast.LENGTH_SHORT).show();
                break;

            case R.id.scan:     //扫一扫
                Toast.makeText(this,"扫一扫",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //默认显示HomeFragment
        replaceFragment(new HomeFragment());
    }
}

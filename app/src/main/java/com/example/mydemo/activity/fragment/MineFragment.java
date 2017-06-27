package com.example.mydemo.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mydemo.R;


public class MineFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView header_imv;
    private RelativeLayout login_layout;
    private ImageButton history_imb;
    private ImageButton su_imb;
    private ImageButton download_imb;
    private Button start_btn;
    private Button host_btn;
    private RelativeLayout shopping_layout;
    private RelativeLayout wallet_layout;
    private RelativeLayout coupons_layout;
    private RelativeLayout like_layout;
    private RelativeLayout trafficpackage_layout;
    private RelativeLayout more_layout;
    private RelativeLayout feedback_layout;
    private RelativeLayout setting_layout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, container, false);

        initView();
        initEvent();
        return view;
    }

    /* 初始化控件 */
    private void initView() {
        header_imv = (ImageView) view.findViewById(R.id.header_icon);
        login_layout = (RelativeLayout) view.findViewById(R.id.login_layout);

        history_imb = (ImageButton) view.findViewById(R.id.history);
        su_imb = (ImageButton) view.findViewById(R.id.subscribe);
        download_imb = (ImageButton) view.findViewById(R.id.mine_download);

        start_btn = (Button) view.findViewById(R.id.start);
        host_btn = (Button) view.findViewById(R.id.host);

        shopping_layout = (RelativeLayout) view.findViewById(R.id.shopping_layout);
        wallet_layout = (RelativeLayout) view.findViewById(R.id.wallet_layout);
        coupons_layout = (RelativeLayout) view.findViewById(R.id.coupons_layout);

        like_layout = (RelativeLayout) view.findViewById(R.id.like_layout);
        trafficpackage_layout = (RelativeLayout) view.findViewById(R.id.trafficpackage_layout);

        more_layout = (RelativeLayout) view.findViewById(R.id.more_layout);
        feedback_layout = (RelativeLayout) view.findViewById(R.id.feedback_layout);
        setting_layout = (RelativeLayout) view.findViewById(R.id.setting_layout);

    }

    /* 注册交互事件 */
    private void initEvent() {
        header_imv.setOnClickListener(this);
        login_layout.setOnClickListener(this);

        history_imb.setOnClickListener(this);
        su_imb.setOnClickListener(this);
        download_imb.setOnClickListener(this);

        start_btn.setOnClickListener(this);
        host_btn.setOnClickListener(this);

        shopping_layout.setOnClickListener(this);
        wallet_layout.setOnClickListener(this);
        coupons_layout.setOnClickListener(this);

        like_layout.setOnClickListener(this);
        trafficpackage_layout.setOnClickListener(this);

        more_layout.setOnClickListener(this);
        feedback_layout.setOnClickListener(this);
        setting_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.header_icon:
                Toast.makeText(getActivity(),"更换头像",Toast.LENGTH_SHORT).show();
                break;

            case R.id.login_layout:
                Toast.makeText(getActivity(),"登录",Toast.LENGTH_SHORT).show();
                break;

            case R.id.history:
                Toast.makeText(getActivity(),"历史记录",Toast.LENGTH_SHORT).show();
                break;

            case R.id.subscribe:
                Toast.makeText(getActivity(),"订阅",Toast.LENGTH_SHORT).show();
                break;

            case R.id.mine_download:
                Toast.makeText(getActivity(),"下载",Toast.LENGTH_SHORT).show();
                break;

            case R.id.start:
                Toast.makeText(getActivity(),"开始录音",Toast.LENGTH_SHORT).show();
                break;

            case R.id.host:
                Toast.makeText(getActivity(),"主播中心",Toast.LENGTH_SHORT).show();
                break;

            case R.id.shopping_layout:
                Toast.makeText(getActivity(),"我的已购",Toast.LENGTH_SHORT).show();
                break;

            case R.id.wallet_layout:
                Toast.makeText(getActivity(),"我的钱包",Toast.LENGTH_SHORT).show();
                break;

            case R.id.coupons_layout:
                Toast.makeText(getActivity(),"我的优惠券",Toast.LENGTH_SHORT).show();
                break;

            case R.id.like_layout:
                Toast.makeText(getActivity(),"我喜欢的",Toast.LENGTH_SHORT).show();
                break;

            case R.id.trafficpackage_layout:
                Toast.makeText(getActivity(),"免流量服务",Toast.LENGTH_SHORT).show();
                break;

            case R.id.more_layout:
                Toast.makeText(getActivity(),"更多",Toast.LENGTH_SHORT).show();
                break;

            case R.id.feedback_layout:
                Toast.makeText(getActivity(),"帮助与反馈",Toast.LENGTH_SHORT).show();
                break;

            case R.id.setting_layout:
                Toast.makeText(getActivity(),"设置",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

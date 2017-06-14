package com.jh.rental.user.view.actitity.home;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.internationnal.ChooseAdapter;
import com.jh.rental.user.view.adapter.internationnal.ChooseAdapter1;
import com.jh.rental.user.view.adapter.internationnal.SceneryAdapter;

/**
 * Created by 骏辉出行 on 2017/5/26.
 * 结伴拼车
 */

public class Carpooling_Act extends TitelBarAcitvity implements View.OnClickListener {

    private RecyclerView mRvList1;
    private RecyclerView mRvList2;
    private RelativeLayout mRlArea;
    private RelativeLayout mRlDay;
    private RelativeLayout mRlTheme;
    private TextView mTvArea;
    private TextView mTvDay;
    private TextView mTvTheme;
    private ImageView mIvArea;
    private ImageView mIvDay;
    private ImageView mIvTheme;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpooling_activity);
        setMyTitel(BaseContext.getResValue(R.string.GroupErrands));
        mRvList1 = (RecyclerView) findViewById(R.id.rv_list1);
        mRvList2 = (RecyclerView) findViewById(R.id.rv_list2);
        SceneryAdapter sceneryAdapter = new SceneryAdapter(this);
        mRvList1.setHasFixedSize(true);
        mRvList1.setLayoutManager(new GridLayoutManager(this, 1));
        mRvList1.setAdapter(sceneryAdapter);

        mRvList2.setHasFixedSize(true);
        mRvList2.setLayoutManager(new GridLayoutManager(this, 1));
        mRvList2.setAdapter(new ChooseAdapter(this));

        mRlArea = (RelativeLayout) findViewById(R.id.rl_area);
        mRlDay = (RelativeLayout) findViewById(R.id.rl_day);
        mRlTheme = (RelativeLayout) findViewById(R.id.rl_theme);
        mTvArea = (TextView) findViewById(R.id.tv_area);
        mTvDay = (TextView) findViewById(R.id.tv_day);
        mTvTheme = (TextView) findViewById(R.id.tv_theme);
        mIvArea = (ImageView) findViewById(R.id.iv_area);
        mIvDay = (ImageView) findViewById(R.id.iv_day);
        mIvTheme = (ImageView) findViewById(R.id.iv_theme);
        mRlArea.setOnClickListener(this);
        mRlDay.setOnClickListener(this);
        mRlTheme.setOnClickListener(this);

    }
    int flag1 = 0;
    int flag2 = 0;
    int flag3 = 0;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_area:
                if (flag1 == 0) {
                    mIvArea.setBackgroundResource(R.drawable.m_c_ffxxhdpi);
                    mIvDay.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mIvTheme.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mTvArea.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                    mTvDay.setTextColor(android.graphics.Color.parseColor("#424242"));
                    mTvTheme.setTextColor(android.graphics.Color.parseColor("#424242"));
//                    mRvList2.setVisibility(View.VISIBLE);
                    showPopupWindow();
                    flag1 = 1;
                    flag2 = 0;
                    flag3 = 0;
                } else {
                    mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
//                    mRvList2.setVisibility(View.GONE);
                    flag1 = 0;
                }
                break;
            case R.id.rl_day:
                if (flag2 == 0) {
                    mIvDay.setBackgroundResource(R.drawable.m_c_ffxxhdpi);
                    mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mIvTheme.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
                    mTvDay.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                    mTvTheme.setTextColor(android.graphics.Color.parseColor("#424242"));
                    mRvList2.setVisibility(View.VISIBLE);
                    flag1 = 0;
                    flag2 = 1;
                    flag3 = 0;
                } else {
                    mIvDay.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mTvDay.setTextColor(android.graphics.Color.parseColor("#424242"));
                    mRvList2.setVisibility(View.GONE);
                    flag2 = 0;
                }
                break;
            case R.id.rl_theme:
                if (flag3 == 0) {
                    mIvTheme.setBackgroundResource(R.drawable.m_c_ffxxhdpi);
                    mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mIvDay.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
                    mTvDay.setTextColor(android.graphics.Color.parseColor("#424242"));
                    mTvTheme.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                    mRvList2.setVisibility(View.VISIBLE);
                    flag1 = 0;
                    flag2 = 0;
                    flag3 = 1;
                } else {
                    mIvTheme.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mTvTheme.setTextColor(android.graphics.Color.parseColor("#424242"));
                    mRvList2.setVisibility(View.GONE);
                    flag3 = 0;
                }
                break;
        }

    }

    private void showPopupWindow() {
        if (mPopupWindow == null) {
            int width = 138;
            int height = 300;
            mPopupWindow = new PopupWindow(width, height);
//            RecyclerView tvView = new RecyclerView(this);
//            tvView.setHasFixedSize(true);
//            tvView.setLayoutManager(new GridLayoutManager(this, 1));
//            tvView.setAdapter(new ChooseAdapter(this));

            ListView listView = new ListView(this);
            listView.setAdapter(new ChooseAdapter1(this));


            mPopupWindow.setContentView(listView);
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setBackgroundDrawable(new ColorDrawable());
            mPopupWindow.setFocusable(true);

        }
    }

}

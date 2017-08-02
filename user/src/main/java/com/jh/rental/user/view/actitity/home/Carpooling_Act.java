package com.jh.rental.user.view.actitity.home;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.home.HotCircuits;
import com.jh.rental.user.model.NetResponData;
import com.jh.rental.user.model.postjson.PostHotCircuits;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.internationnal.SceneryAdapter;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;

/**
 * Created by 骏辉出行 on 2017/5/26.
 * 结伴拼车
 */

public class Carpooling_Act extends TitelBarAcitvity implements View.OnClickListener {
    private RecyclerView mRvList1;
//    private RecyclerView mRvList2;
    private RelativeLayout mRlArea,mRlDay,mRlTheme;
    private TextView mTvArea,mTvDay,mTvTheme;
    private ImageView mIvArea,mIvDay,mIvTheme;
    private PopupWindow mPopupWindow;
    private int tab;//标记选择
    private String choose;//标记选择类型
    private HotCircuits hotCircuits;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpooling_activity);
        hotCircuits = new HotCircuits();
        setMyTitel(BaseContext.getResValue(R.string.GroupErrands));
        mRvList1 = (RecyclerView) findViewById(R.id.rv_list1);
        SceneryAdapter sceneryAdapter = new SceneryAdapter(this,hotCircuits);
        mRvList1.setHasFixedSize(true);
        mRvList1.setLayoutManager(new GridLayoutManager(this, 1));
        mRvList1.setAdapter(sceneryAdapter);
        new PostHotCircuits().reqNetD(1, 10, 4, new NetResponData<HotCircuits>() {
            @Override
            public void responeData(HotCircuits object) {
//                hotCircuits.setList(object.getList());
                mRvList1.getAdapter().notifyDataSetChanged();
            }
        });
//        mRvList2.setHasFixedSize(true);
//        mRvList2.setLayoutManager(new GridLayoutManager(this, 1));
//        mRvList2.setAdapter(new ChooseAdapter(this));
        initView();
    }

    private void initView() {
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

    RecyclerView mRecyclerView;
    PopupWindow mP1,mP2,mP3;
    View view;
    ArrayList<String> list;
    @Override
    public void onClick(View v) {
        view = LayoutInflater.from(this).inflate(R.layout.view_spinner,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_spinner_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        final int[] point = {0,0};
        switch (v.getId()) {
            case R.id.rl_area:
                    list = new ArrayList<>();
                    list.add("港澳台");
                    list.add("东南亚");
                    list.add("日韩");
                    list.add("欧洲");
                    list.add("北美洲");
                    list.add("南美洲");
                    list.add("大洋洲");
                    list.add("非洲");
                    list.add("中东");
                    mRecyclerView.setAdapter(new SpinnerAdapter(list,mIvArea,mTvArea,1));
                    mP1 = new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    mP1.setFocusable(true);
                    mP1.setOutsideTouchable(true);
                    mP1.setBackgroundDrawable(new BitmapDrawable());
                    mRlArea.getLocationOnScreen(point);
                    mP1.showAtLocation(view, Gravity.TOP| Gravity.LEFT, point[0] - ViewGroup.LayoutParams.MATCH_PARENT / 2 + mRlArea.getWidth() / 2, point[1] +mRlArea.getHeight());
                    mP1.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
                        }
                    });
                    mIvArea.setBackgroundResource(R.drawable.m_c_ffxxhdpi);
                    mTvArea.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                break;
            case R.id.rl_day:
                    list = new ArrayList<>();
                    list.add("不限");
                    list.add("1天");
                    list.add("2天");
                    list.add("3天");
                    list.add("4天");
                    mRecyclerView.setAdapter(new SpinnerAdapter(list,mIvArea,mTvArea,2));
                    mP2 = new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    mP2.setFocusable(true);
                    mP2.setOutsideTouchable(true);
                    mP2.setBackgroundDrawable(new BitmapDrawable());
                    mRlDay.getLocationOnScreen(point);
                    mP2.showAtLocation(view, Gravity.TOP| Gravity.LEFT, point[0] - ViewGroup.LayoutParams.MATCH_PARENT / 2 + mRlArea.getWidth() / 2, point[1] + mRlArea.getHeight());
                    mP2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            mIvDay.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            mTvDay.setTextColor(android.graphics.Color.parseColor("#424242"));
                        }
                    });
                    mIvDay.setBackgroundResource(R.drawable.m_c_ffxxhdpi);
                    mTvDay.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                break;
            case R.id.rl_theme:
                    list = new ArrayList<>();
                    list.add("不限");
                    list.add("温泉");
                    list.add("亲子");
                    list.add("文化古迹");
                    list.add("摄影");
                    list.add("当地美食");
                    mRecyclerView.setAdapter(new SpinnerAdapter(list,mIvArea,mTvArea,3));
                    mP3 = new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    mP3.setFocusable(true);
                    mP3.setOutsideTouchable(true);
                    mP3.setBackgroundDrawable(new BitmapDrawable());
                    mRlTheme.getLocationOnScreen(point);
                    mP3.showAtLocation(view, Gravity.TOP| Gravity.LEFT, point[0] - ViewGroup.LayoutParams.MATCH_PARENT / 2 + mRlArea.getWidth() / 2, point[1] + mRlArea.getHeight());
                    mP3.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            mIvTheme.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            mTvTheme.setTextColor(android.graphics.Color.parseColor("#424242"));

                        }
                    });
                    mIvTheme.setBackgroundResource(R.drawable.m_c_ffxxhdpi);
                    mTvTheme.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                break;
        }

    }

    class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.MyViewHolder> {
        ArrayList<String> mDatas;
        ImageView mIvArea;
        TextView mTvArea;
        int mIn;
        public SpinnerAdapter(ArrayList<String> list, ImageView ivArea, TextView tvArea, int i) {
            mDatas= list;
            mIvArea=ivArea;
            mTvArea=tvArea;
            mIn=i;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    Carpooling_Act.this).inflate(R.layout.item_test, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            final int mPosition = position;
            holder.tv.setText(mDatas.get(position));
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choose = mDatas.get(mPosition);
                    tab = mIn;
                    Toast.makeText(Carpooling_Act.this, mDatas.get(mPosition), Toast.LENGTH_SHORT).show();
                    mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
                    if (mIn == 1){
                        mP1.dismiss();
                    } else if (mIn == 2){
                        mP2.dismiss();
                    }else if (mIn == 3){
                        mP3.dismiss();
                    }
                }
            });
        }
        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;
            View mView;
            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.test1);
                mView = view;
                AutoUtils.autoSize(mView);
            }
        }
    }
}

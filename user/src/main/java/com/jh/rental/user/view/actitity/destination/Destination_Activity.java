package com.jh.rental.user.view.actitity.destination;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.home.HotCircuits;
import com.jh.rental.user.model.NetResponData;
import com.jh.rental.user.model.postjson.PostHotCircuits;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.LoadDialog;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.internationnal.LandscapeAdapter;

/**
 * Created by俊辉出行 on 2017/5/19.
 */

public class Destination_Activity extends TitelBarAcitvity {
    private RecyclerView mRvList1;
    private TextView titlebar;
    private String cityName = null;
    private LandscapeAdapter landscapeAdapter;
    private HotCircuits hotCircuits;
    private int height = 640;
    private int overallXScroll = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_activity);
        setMyTitel(BaseContext.getResValue(R.string.destination));
        initView();
    }

    private void initView() {
        hotCircuits = new HotCircuits();
        mRvList1 = (RecyclerView) findViewById(R.id.rv_list1);
        titlebar = (TextView) findViewById(R.id.sub_title);
        if (getIntent().getStringExtra("cityName") != null) {
            cityName = getIntent().getStringExtra("cityName");
            ApiConstants.queryCity=cityName;
            OrderDetails.getOrderDetails().setCity(cityName);
            OrderDetails.getOrderDetails().setDescity(cityName);
        }
        landscapeAdapter = new LandscapeAdapter(this, cityName, hotCircuits);
        mRvList1.setHasFixedSize(true);
        mRvList1.setLayoutManager(new GridLayoutManager(this, 1));
        mRvList1.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (hotCircuits.getList()==null){
                    return;
                }
                if (((LinearLayoutManager)recyclerView.getLayoutManager()).findLastVisibleItemPosition()==hotCircuits.getList().size()){
                    if (isLoad&&dy>0){
                        loadData();
                    }
                }
                //标题透明渐变
                overallXScroll = overallXScroll + dy;
                if (overallXScroll <= 0) {
                    titlebar.setBackgroundColor(Color.argb(0, 255, 255, 255));
                } else if (overallXScroll > 0 && overallXScroll <= height) {
                    float scale = (float) overallXScroll / height;
                    float alpha = (255 * scale);
                    titlebar.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                } else {
                    titlebar.setBackgroundColor(Color.argb(255, 255, 255, 255));
                }
            }
        });
        mRvList1.setAdapter(landscapeAdapter);
        new PostHotCircuits().reqNetB(loadValue, 8, new NetResponData<HotCircuits>() {
            @Override
            public void responeData(HotCircuits object) {
                total=Integer.valueOf(object.getTotal());
                hotCircuits.setList(object.getList());
                mRvList1.getAdapter().notifyDataSetChanged();
            }
        });
    }
    private boolean  isLoad=true;
    private int loadValue=1;
    private int total=0;
    private void loadData() {
        isLoad = false;
        if (total > loadValue * 8) {
            loadValue++;
            LoadDialog.show(this, "加载数据...");
            new PostHotCircuits().reqNetB(loadValue, 8, new NetResponData<HotCircuits>() {
                @Override
                public void responeData(HotCircuits object) {
                    hotCircuits.getList().addAll(object.getList());
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            LoadDialog.dismiss(Destination_Activity.this);
                            mRvList1.getAdapter().notifyDataSetChanged();
                            isLoad=true;
                        }
                    });
                }
            });

        }
    }
}


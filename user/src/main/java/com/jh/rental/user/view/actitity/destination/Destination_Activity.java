package com.jh.rental.user.view.actitity.destination;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.internationnal.LandscapeAdapter;

/**
 * Created by俊辉出行 on 2017/5/19.
 */

public class Destination_Activity extends TitelBarAcitvity  {
    RecyclerView mRvList1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_activity);
        setMyTitel(BaseContext.getResValue(R.string.destination));
        initView();
    }

    private void initView() {
        mRvList1 = (RecyclerView) findViewById(R.id.rv_list1);
        LandscapeAdapter sceneryAdapter = new LandscapeAdapter(this);
        mRvList1.setHasFixedSize(true);
        mRvList1.setLayoutManager(new GridLayoutManager(this, 1));
        mRvList1.setAdapter(sceneryAdapter);
    }
}


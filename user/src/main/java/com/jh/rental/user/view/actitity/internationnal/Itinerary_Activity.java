package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.internationnal.ItineraryAdapter;

public class Itinerary_Activity extends TitelBarAcitvity implements View.OnClickListener {

    RelativeLayout mRlShutDown;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itinerary_activity);
        setMyTitel(BaseContext.getResValue(R.string.itinerary));
        initView();
    }

    private void initView() {
        RecyclerView rlvDay = (RecyclerView) findViewById(R.id.rlv_day);
        rlvDay.setHasFixedSize(true);
        rlvDay.setLayoutManager(new GridLayoutManager(this, 1));
        rlvDay.setAdapter(new ItineraryAdapter(this));

        mRlShutDown = (RelativeLayout) findViewById(R.id.rl_ShutDown);
        ImageView ivShutDown = (ImageView) findViewById(R.id.iv_ShutDown);
        ivShutDown.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_ShutDown:
                mRlShutDown.setVisibility(View.GONE);
                break;
        }
    }
}

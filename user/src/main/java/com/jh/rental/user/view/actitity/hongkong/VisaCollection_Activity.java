package com.jh.rental.user.view.actitity.hongkong;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.hongkong.VisaCollectionAdapter;

public class VisaCollection_Activity extends TitelBarAcitvity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visacollection_activity);
        setMyTitel(BaseContext.getResValue(R.string.PerfectInformation));
        initView();
    }

    private void initView() {
        RecyclerView rlvRecord = (RecyclerView) findViewById(R.id.rlv_visaphotos);
        rlvRecord.setHasFixedSize(true);
        rlvRecord.setLayoutManager(new GridLayoutManager(this, 1));
        rlvRecord.setAdapter(new VisaCollectionAdapter(this));
    }
}

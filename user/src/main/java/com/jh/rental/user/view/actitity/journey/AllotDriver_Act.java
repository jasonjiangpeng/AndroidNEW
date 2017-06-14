package com.jh.rental.user.view.actitity.journey;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

public class AllotDriver_Act extends TitelBarAcitvity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allotdriver_activity);
        setMyTitel(BaseContext.getResValue(R.string.myjoureny));
    }
}

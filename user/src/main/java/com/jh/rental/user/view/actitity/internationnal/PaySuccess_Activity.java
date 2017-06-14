package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;


/**
 * Created by 骏辉出行 on 2017/5/26.
 */

public class PaySuccess_Activity extends TitelBarAcitvity implements View.OnClickListener {
    int TAB = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paysuccess_activity);
        setMyTitel(BaseContext.getResValue(R.string.pay));
        initView();
    }
private Button payfinish;
    private void initView() {
        Button buttonPlanning = (Button) findViewById(R.id.button_planning);
         payfinish = (Button) findViewById(R.id.payfinish);
        payfinish.setOnClickListener(this);
        LinearLayout ll_conceal = (LinearLayout) findViewById(R.id.ll_conceal);
        buttonPlanning.setOnClickListener(this);
        if ( getIntent().getIntExtra("tab",TAB) != 1){
            ll_conceal.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_planning:
                ActivityUtils.nextActivity(AddTrip1_Activity.class);
                break;
            case R.id.payfinish:
                BaseApplication.getMainActivity();
                break;
        }
    }
}

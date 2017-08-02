package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

/**
 * Created by 骏辉出行 on 2017/5/26.
 */

public class AddTrip1_Activity extends TitelBarAcitvity implements View.OnClickListener {
    private TextView start,end;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtrip1_activity);
        setMyTitel(BaseContext.getResValue(R.string.addTrip));
        initView();
    }


    private void initView() {
        Button button = (Button) findViewById(R.id.button);
        start= (TextView) findViewById(R.id.start);
        end= (TextView) findViewById(R.id.end);
        start.setOnClickListener(this);
        end.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                ActivityUtils.nextActivity(AddTrip3_Activity.class);
                break;
            case R.id.start:
//                ActivityUtils.nextActivity(AddressLocation_Activity.class,"addrsslocation", OrderDetails.getOrderDetails().getCity());
                ActivityUtils.nextActivity(AddressLocationMid_Activity.class);
                break;
            case R.id.end:
//                ActivityUtils.nextActivity(AddressLocation_Activity.class,"addrsslocations", OrderDetails.getOrderDetails().getCity());

                break;

        }
    }
}

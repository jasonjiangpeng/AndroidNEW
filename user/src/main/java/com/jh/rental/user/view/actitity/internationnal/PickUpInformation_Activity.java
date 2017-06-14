package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

/**
 * Created by 骏辉出行 on 2017/5/26.
 */

public class PickUpInformation_Activity extends TitelBarAcitvity implements View.OnClickListener {
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    private PickupDetails  pickupDetails;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickup_activity);
        setMyTitel(BaseContext.getResValue(R.string.dingtrip));
        pickupDetails=PickupDetails.getOrderDetails();
        initView();
    }

    @Override
    public void handleManage(int value) {

        tv1.setText(pickupDetails.getDepartcity());
        tv3.setText(pickupDetails.getDescitys());
        tv4.setText(pickupDetails.getMancounts());
        tv5.setText(pickupDetails.getChild());
        tv6.setText(pickupDetails.getCarmessage());
        tv7.setText(pickupDetails.getLuggage());
        tv8.setText(pickupDetails.getTime());
    }

    private void initView() {
        tv1= (TextView) findViewById(R.id.pickabc1);
        tv2= (TextView) findViewById(R.id.pickabc2);
        tv3= (TextView) findViewById(R.id.pickabc3);
        tv4= (TextView) findViewById(R.id.pickabc4);
        tv5= (TextView) findViewById(R.id.pickabc5);
        tv6= (TextView) findViewById(R.id.pickabc6);
        tv7= (TextView) findViewById(R.id.pickabc7);
        tv8= (TextView) findViewById(R.id.pickabc8);
        tv9= (TextView) findViewById(R.id.pickabc9);
        handler.sendEmptyMessage(0);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                ActivityUtils.nextActivity(AddTrip2_Activity.class);
                break;
        }
    }
}

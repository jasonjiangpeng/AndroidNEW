package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

/**
 * Created by 骏辉出行 on 2017/5/26.
 */

public class MakeAppointment_Activity extends TitelBarAcitvity implements View.OnClickListener {

    public static String INDENT= "MakeAppointment";
private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeappointment_activity);
        setMyTitel(BaseContext.getResValue(R.string.SpecialistCar));
        initView();
    }

    private void initView() {
         tv1= (TextView) findViewById(R.id.ordertv1);
         tv2= (TextView) findViewById(R.id.ordertv2);
         tv3= (TextView) findViewById(R.id.ordertv3);
         tv4= (TextView) findViewById(R.id.ordertv4);
         tv5= (TextView) findViewById(R.id.ordertv5);
         tv6= (TextView) findViewById(R.id.ordertv6);
         tv7= (TextView) findViewById(R.id.ordertv7);
         tv8= (TextView) findViewById(R.id.ordertv8);
         tv9= (TextView) findViewById(R.id.ordertv9);
        setmText();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        tv9.setOnClickListener(this);
    }
   public void setmText(){  //设置文字
       tv1.setText(OrderDetails.getOrderDetails().getCity());
       tv2.setText(OrderDetails.getOrderDetails().getCitysub());
       tv3.setText(OrderDetails.getOrderDetails().getDescity());

   }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                ActivityUtils.nextActivity(OrderDetails_Activity.class,"indent",INDENT);
                break;
            case R.id.ordertv9:
                ActivityUtils.nextActivity(Passenger_Activity.class);
                break;
        }
    }
}

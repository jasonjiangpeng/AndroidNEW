package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

/**
 * Created by 骏辉出行 on 2017/5/26.
 */

public class MakeAppointment_Activity extends TitelBarAcitvity implements View.OnClickListener {
    public static String INDENT= "MakeAppointment";
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv_add,tv_delete1,tv_delete2;
    private LinearLayout mLlViapoint1,mLlViapoint2;
    private  int choose=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        choose=getIntent().getIntExtra("MakeAppointment_Activity",0);
        setContentView(R.layout.makeappointment_activity);
        setMyTitel(BaseContext.getResValue(R.string.SpecialistCar));
        initView();
    }
    private void initView() {
        mLlViapoint1 = (LinearLayout) findViewById(R.id.ll_viapoint1);
        mLlViapoint2 = (LinearLayout) findViewById(R.id.ll_viapoint2);
        tv1= (TextView) findViewById(R.id.ordertv1);
        tv2= (TextView) findViewById(R.id.ordertv2);
        tv3= (TextView) findViewById(R.id.ordertv3);
        tv4= (TextView) findViewById(R.id.ordertv4);
        tv5= (TextView) findViewById(R.id.ordertv5);
        tv6= (TextView) findViewById(R.id.ordertv6);
        tv7= (TextView) findViewById(R.id.ordertv7);
        tv8= (TextView) findViewById(R.id.ordertv8);
        tv9= (TextView) findViewById(R.id.ordertv9);
        tv_add= (TextView) findViewById(R.id.tv_add);
        tv_delete1= (TextView) findViewById(R.id.tv_delete1);
        tv_delete2= (TextView) findViewById(R.id.tv_delete2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        tv9.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (choose==999){
            setPickupText();
        }else {
            setmText();
        }
        tv_add.setOnClickListener(this);
        tv_delete1.setOnClickListener(this);
        tv_delete2.setOnClickListener(this);
        mLlViapoint1.setOnClickListener(this);
        mLlViapoint2.setOnClickListener(this);
    }

    /*来自专车*/
   public void setmText(){  //设置文字
       tv1.setText(OrderDetails.getOrderDetails().getCity());
       tv2.setText(OrderDetails.getOrderDetails().getCitysub());
       tv3.setText(OrderDetails.getOrderDetails().getDescity());
       tv4.setText(OrderDetails.getOrderDetails().getMan());
       tv5.setText(OrderDetails.getOrderDetails().getChild());
       tv6.setText(OrderDetails.getOrderDetails().getCar());
       tv7.setText(OrderDetails.getOrderDetails().getLuggage());
       tv8.setText(OrderDetails.getOrderDetails().getDate());
       tv9.setText(OrderDetails.getOrderDetails().getPassenger());
   }

   /*来自接送机*/


    public void setPickupText(){  //设置文字
        tv1.setText(PickupDetails.getOrderDetails().getDepartcity());
        tv3.setText(PickupDetails.getOrderDetails().getDescitys());
        tv4.setText(PickupDetails.getOrderDetails().getMancounts());
        tv5.setText(PickupDetails.getOrderDetails().getChild());
        tv6.setText(PickupDetails.getOrderDetails().getCarmessage());
        tv7.setText(PickupDetails.getOrderDetails().getLuggage());
        tv8.setText(PickupDetails.getOrderDetails().getDate());
    }

    int tag = 0;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Constant.COUPON = 0;
                ActivityUtils.nextActivity(OrderDetails_Activity.class,"indent",INDENT);
                break;
            case R.id.tv_add:
                if ( tag == 0){
                    mLlViapoint1.setVisibility(View.VISIBLE);
                    tag = 1;
                }else {
                    mLlViapoint2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_viapoint1:
                ActivityUtils.nextActivity(AddressLocation_Activity.class);
                break;
            case R.id.ll_viapoint2:
                ActivityUtils.nextActivity(AddressLocation_Activity.class);
                break;
            case R.id.tv_delete1:
                mLlViapoint1.setVisibility(View.GONE);
                tag = 0;
                break;
            case R.id.tv_delete2:
                mLlViapoint2.setVisibility(View.GONE);
                break;
            case R.id.ordertv9:
                ActivityUtils.nextActivity(Passenger_Activity.class);
                break;
        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}

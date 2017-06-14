package com.jh.rental.user.view.actitity.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.intent.FlightMessage;
import com.jh.rental.user.constants.IntentKeyName;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.actitity.TitelBarAbsAcitvity;
import com.jh.rental.user.view.actitity.internationnal.AddressLocation_Activity;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class FlightMessage_Act extends TitelBarAbsAcitvity implements View.OnClickListener {

    @Override
    public int resId() {
        return R.layout.flightmessage_act;
    }
private RelativeLayout  relativeLayout;
    private TextView  tv1,tv2,tv3,des;
    @Override
    public void initUI() {
         relativeLayout= (RelativeLayout) findViewById(R.id.flight_relative);
        IntentFilter intentFilter=new IntentFilter(IntentKeyName.FlighActionBroadreciver);
        myBroad =new MyBroad();
        registerReceiver(myBroad,intentFilter);
        tv1= (TextView) findViewById(R.id.flight_tv1);
        tv2= (TextView) findViewById(R.id.flight_tv2);
        tv3= (TextView) findViewById(R.id.flight_tv3);
        des= (TextView) findViewById(R.id.flight_des);
        des.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);

    }
FlightMessage  flightMessage=null;
    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {

             tv3.setVisibility(View.GONE);
         tv1.setText(flightMessage.getFlightNumber());
         tv2.setText(flightMessage.getDate());
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
      //  Logger.soutMessage(requestCode+"=="+resultCode);

    }

    @Override
    public String resTitel() {
        return BaseContext.getResValue(R.string.flightmessage);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(myBroad);
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.flight_relative:
                ActivityUtils.nextActivity(FlightMessageSub_Act.class);
                break;
            case R.id.flight_des:
                ActivityUtils.nextActivity(AddressLocation_Activity.class);
                break;
        }
    }
    MyBroad myBroad;
     class  MyBroad extends BroadcastReceiver{

         @Override
         public void onReceive(Context context, Intent intent) {

             Logger.soutMessage("onReceive");
             Logger.soutMessage(intent.getAction());
              if (intent.getAction().equals(IntentKeyName.FlighActionBroadreciver)&&intent.getSerializableExtra(IntentKeyName.flightmessage)!=null){
                      flightMessage= (FlightMessage) intent.getSerializableExtra(IntentKeyName.flightmessage);
                      handler.sendEmptyMessage(0);
              }
         }
     }
}

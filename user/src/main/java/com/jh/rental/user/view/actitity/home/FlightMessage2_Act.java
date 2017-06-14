package com.jh.rental.user.view.actitity.home;

import android.view.View;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAbsAcitvity;
import com.jh.rental.user.view.actitity.internationnal.AddressLocationPick_Activity;
import com.jh.rental.user.view.actitity.journey.Payment_Activity_;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCarTypeView;
import com.jh.rental.user.view.widget.PopJourneyCounterView;

//import org.greenrobot.eventbus.EventBus;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class FlightMessage2_Act extends TitelBarAbsAcitvity implements View.OnClickListener, PopJourneyCounterView.PopTime, PopCarTypeView.PopTime {
private PickupDetails pickupDetails;
    @Override
    public int resId() {
        return R.layout.flightmessage2_act;
    }
    private TextView  tv1,tv2,des;

    @Override
    public void initUI() {
        pickupDetails=PickupDetails.getOrderDetails();
        popCarTypeView=new PopCarTypeView(this);
        popCarTypeView.setTipa(this);
        popJourneyCounterView=new PopJourneyCounterView(this);
        popJourneyCounterView.setTipa(this);
        tv1= (TextView) findViewById(R.id.flight_tv1);
        tv2= (TextView) findViewById(R.id.flight_tv2);
        des= (TextView) findViewById(R.id.flight_des);
        des.setOnClickListener(this);
   /*     String str1 = PreferencesUtil.getString(this, Constant.Internationa.FLIGHTMESSAGE);
        String str2 = PreferencesUtil.getString(this, Constant.Internationa.FLIGHTTIME);*/
        handler.sendEmptyMessage(6);

    }
private PopJourneyCounterView popJourneyCounterView;
private PopCarTypeView popCarTypeView;
    @Override
    public void handleManage(int value) {
        if (value==5){
            des.setText(PickupDetails.getOrderDetails().getDescitys());
            PopwindowUtils.getPopwindowUtils().show(popJourneyCounterView,des,FlightMessage2_Act.this);
        }else if (value==6){
            tv1.setText(PickupDetails.getOrderDetails().getFlightNo());
            String a1 = recovrt(PickupDetails.getOrderDetails().getDate());
            String  vvv=a1+PickupDetails.getOrderDetails().getArriveTime()+PickupDetails.getOrderDetails().getArrive();
            descity=PickupDetails.getOrderDetails().getArrive().split(" ")[0];
            tv2.setText(vvv);
        }

    }
    public  String recovrt(String value){
        String[] split = value.split("-");
        String result=null;
       result =split[1]+"月"+split[2]+"日";
        return result;
    }
    @Override
    public String resTitel() {
        return BaseContext.getResValue(R.string.flightmessage);
    }
  private String descity;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.flight_des:
                if (descity!=null){
                    ActivityUtils.nextActivity(AddressLocationPick_Activity.class);
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
          if (PickupDetails.getOrderDetails().getDescitys()!=null){
              handler.sendEmptyMessage(5);
          }
    }
 /*人数选择，小孩人数*/

    @Override
    public void next(int man, int child) {
        pnum=man+child;
         PickupDetails.getOrderDetails().setMancounts(String.valueOf(man));
         PickupDetails.getOrderDetails().setChild(String.valueOf(child));
        PopwindowUtils.getPopwindowUtils().show(popCarTypeView,des,this);

    }
/*选择下个Activity*/
    @Override
    public void next() {
           sendNetRequet();
       ActivityUtils.nextActivity(Payment_Activity_.class);
    }
 private int pnum;
    @Override
    public void sendNetRequet() {
//        EventBus.getDefault().post();
        String  pnum=String.valueOf(pickupDetails.getMancounts()+pickupDetails.getChild());
       // HttpVolley.getInstance().postMapRequest(ApiPost.getCarPriceTransPort,getBaseMap(keyvalue,));
    }
    private String[] keyvalue={"cityId","startAddress","endAddress","sLng","sLat","pnum"};
}

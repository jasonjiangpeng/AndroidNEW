package com.jh.rental.user.view.actitity.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.home.GetCarPriceTransPort;
import com.jh.rental.user.bean.ordermessage.QueryFlightMsg;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.TitelBarAbsAcitvity;
import com.jh.rental.user.view.actitity.internationnal.AddressLocationPick_Activity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCarCircuitView;
import com.jh.rental.user.view.widget.PopJourneyCounterView;

import java.util.ArrayList;

//import org.greenrobot.eventbus.EventBus;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class FlightMessage2_Act extends TitelBarAbsAcitvity implements View.OnClickListener
       {
private PickupDetails pickupDetails;
    private TextView  tv1,tv2,des;
    private String[] key1={"flightNo","date"};

    @Override
    public void sendRequestData() {
        HttpVolley.getInstance().getRequestParamData(ApiGet.queryFlightMsg,getLinkdHashHap(key1,PickupDetails.getOrderDetails().getWriteflightNo(),PickupDetails.getOrderDetails().getWritedate()),
                new NetSucceed<>(QueryFlightMsg.class, new NetSucceed.HolderData<QueryFlightMsg>() {
                    @Override
                    public void holdData(QueryFlightMsg bean) {
                        if (bean.getArrive()==null){
                            SnakebarUtils.show(null,"没有航班");
                        }else {
                            PickupDetails.getOrderDetails().setArriveName(bean.getArrive());
                            PickupDetails.getOrderDetails().setFlightNo(bean.getFlightNo());
                            PickupDetails.getOrderDetails().setArriveTime(bean.getArriveTime());
                            PickupDetails.getOrderDetails().setDate(bean.getArriveDate());

                            handler.sendEmptyMessageDelayed(6,20);
                        }

                    }
                }),new NetError());
    }

    @Override
    public int resId() {
        return R.layout.flightmessage2_act;
    }
    @Override
    public void initUI() {
        pickupDetails=PickupDetails.getOrderDetails();
        popCarTypeView=new PopCarCircuitView(this);
     //   popCarTypeView.setTipa(this);
        popJourneyCounterView=new PopJourneyCounterView(this);

        tv1= (TextView) findViewById(R.id.flight_tv1);
        tv2= (TextView) findViewById(R.id.flight_tv2);
        tv1.setText(PickupDetails.getOrderDetails().getWriteflightNo());
        tv2.setText("没有查询该航班信息");
        des= (TextView) findViewById(R.id.flight_des);
        ImageView  img= (ImageView) findViewById(R.id.flight_img);
        if (ApiConstants.OrderlTpye ==1){
            des.setHint("选择出发点");
        }else {
            img.setBackground(getDrawable(R.drawable.w_g_dxxhdpi));
            des.setHint("选择目的地");
        }
        des.setOnClickListener(this);
    }
private PopJourneyCounterView popJourneyCounterView;
private PopCarCircuitView popCarTypeView;
    @Override
    public void handleManage(int value) {
       if (value==6){
           if (tv2==null){
               handler.sendEmptyMessageDelayed(6,50);
               return;
           }
            tv1.setText(PickupDetails.getOrderDetails().getFlightNo());
            String a1 = recovrt(PickupDetails.getOrderDetails().getDate());
            String  vvv=a1+PickupDetails.getOrderDetails().getArriveTime()+PickupDetails.getOrderDetails().getArriveName();
            descity=PickupDetails.getOrderDetails().getArriveName().split(" ")[0];
            tv2.setText(vvv);
        }else if (value==986){
         //  popCarTypeView.setGetCarPrices(getCarPriceTransPorts);
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
              des.setText(PickupDetails.getOrderDetails().getDescitys());
              PopwindowUtils.getPopwindowUtils().show(popJourneyCounterView,des,FlightMessage2_Act.this);
          }
    }
 /*人数选择，小孩人数*/



    private String[] keyvalue={"cityId","endAddress","sLng","sLat","pnum"};

    ArrayList<GetCarPriceTransPort>  getCarPriceTransPorts;



    @Override
    protected void onDestroy() {
        super.onDestroy();
        PopwindowUtils.closePopWin();
    }
}

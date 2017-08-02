package com.jh.rental.user.view.widget.jason;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.CarPriceSend;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.ordermessage.GetCarPrice;
import com.jh.rental.user.model.HttpVolley;

import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.oder.PickUpOrderPickUp;
import com.jh.rental.user.presenter.oder.PlaceOrder;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.DateUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.internationnal.Passenger_Activity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCarTypeView;
import com.jh.rental.user.view.widget.PopJourneyCounterView;

import com.jh.rental.user.view.widget.pickdate.PopTimeChoose;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 骏辉出行 on 2017/6/22.
 */

public class FlightSubCounter extends LinearLayout implements View.OnClickListener {
    private   View inflate;
    private TextView tv4,tv5,tv6,tv7,tv8,tv9;
    private Button buttonbus;
   // private PopTimeChoose popTimeView;
    private PopJourneyCounterView popJourneyCounterView;
    private PickupDetails pickupDetails;
  private   ShowCardView  showCardView;
    public FlightSubCounter(Context context) {
        super(context);
    }
    public FlightSubCounter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        pickupDetails=PickupDetails.getOrderDetails();
        inflate = LayoutInflater.from(context).inflate(R.layout.bussubcounter, this);
        tv4= (TextView) inflate.findViewById(R.id.ordertv4);
        tv5= (TextView) inflate.findViewById(R.id.ordertv5);
        showCardView= (ShowCardView) inflate.findViewById(R.id.ShowCardView);
        if (ApiConstants.OrderlTpye==0){
            showCardView.setVisibility(VISIBLE);
        }else {
            showCardView.setVisibility(GONE);
        }
        buttonbus= (Button)inflate.findViewById(R.id.buttonbus);
        initParmramer();
        tv6= (TextView) inflate.findViewById(R.id.ordertv6);
        tv7= (TextView) inflate.findViewById(R.id.ordertv7);
        tv8= (TextView)  inflate.findViewById(R.id.ordertv8);
        tv9= (TextView) inflate.findViewById(R.id.ordertv9);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);
        buttonbus.setOnClickListener(this);
    }
    private  final String  time=PickupDetails.getOrderDetails().getArriveTime();

    public void refreshData(){
        if (pickupDetails.getMancounts()!=null){
            tv4.setText(pickupDetails.getMancounts());
        }
        if (pickupDetails.getChild()!=null){
            tv5.setText(pickupDetails.getChild());
        }
        if (pickupDetails.getCarmessage()!=null){
            tv6.setText(pickupDetails.getCarmessage());
        }

        if (pickupDetails.getArriveTime()!=null){
            if (ApiConstants.OrderlTpye==1){
                  //  tv8.setText(newTimeS);
            }else {
                tv8.setText(time);
            }
        }
        if (OrderDetails.getOrderDetails().getPassenger()!=null){
            tv9.setText(OrderDetails.getOrderDetails().getPassenger());
        }
    }
    private PopTimeChoose popTimeView;
    public void showTimeView(){
        if (ApiConstants.OrderlTpye==1){
            if (isNull(tv4)){
                SnakebarUtils.show(null,"选择出行人数");
            }else {
                PopwindowUtils.getPopwindowUtils().show(popTimeView,tv4, BaseApplication.currentActivity());
            }
        }

    }
    @Override
    public void onClick(View v) {
              switch (v.getId()){
                  case R.id.ordertv4:
                      showManView();
                      break;
                  case R.id.ordertv5:
                      showManView();
                      break;
                  case R.id.ordertv6:
                      if (isNull(tv8)){
                          SnakebarUtils.show(null,"输入日期");
                      }else {
                          showCarView();
                      }
                      break;
                  case R.id.ordertv7:
                      if (isNull(tv6)){
                          SnakebarUtils.show(null,"请选择车型");
                      }else {
                          showPopluggum();
                      }
                      break;
                  case R.id.ordertv8:
                      showTimeView();


                      break;
                  case R.id.ordertv9:
                      ActivityUtils.nextActivity(Passenger_Activity.class);
                      break;
                  case R.id.buttonbus:
                      int man=Integer.valueOf(PickupDetails.getOrderDetails().getMancounts());
                      if (man>OrderDetails.getOrderDetails().getSeatNum()){
                          SnakebarUtils.showToast("出行人数不能大于车座，请重新选择",getContext());
                          return;
                      }
                      if (ApiConstants.OrderlTpye==0){
                          if (showCardView.getStatus()){
                              if (showCardView.showCard()){
                                  PickupDetails.getOrderDetails().setBannerContent(showCardView.showCardContext());
                              }else {
                                  SnakebarUtils.showToast("请输入举牌内容,字符在20之内");
                                  return;
                              }
                          }else {
                              PickupDetails.getOrderDetails().setBannerContent(null);
                          }
                      }
                      busCallBack.btncallback(tv4,tv5,tv6,tv7,tv8);

                      break;
              }
    }
    private final  long  TIME=3600000;

   public void  initParmramer(){
       if (ApiConstants.OrderlTpye==1){
           popTimeView=new PopTimeChoose(getContext());
           popTimeView.setCallBack(new PopTimeChoose.CallBack() {
               @Override
               public void getTime(String value) {
                   try {
                       long oldTime = DateUtils.stringToLong(time, "yyyy-MM-dd HH:mm");
                       long newTime = DateUtils.stringToLong(value, "yyyy-MM-dd HH:mm");
                       if (oldTime-newTime>TIME){
                           tv8.setText(value);
                       }else {
                           SnakebarUtils.showToast("请选择起飞一小时前的时间");
                       }
                       if (isAll){
                           showCarView();
                       }
                   } catch (ParseException e) {
                       e.printStackTrace();
                   }
               }
           });
       }
       popJourneyCounterView=new PopJourneyCounterView(getContext());
       popJourneyCounterView.setTipa(new PopJourneyCounterView.PopTime() {
           @Override
           public void next(int man, int child) {
               CarPriceSend.getCarPriceSend().setPnum(String.valueOf(man));
               PickupDetails.getOrderDetails().setMancounts(String.valueOf(man));
               PickupDetails.getOrderDetails().setChild(String.valueOf(child));
               refreshData();
               if (isAll){
                   if (ApiConstants.OrderlTpye==1){
                       showTimeView();
                   }else {
                       showCarView();
                   }
               }
           }
       });
       popCarTypeView=new PopCarTypeView(getContext());
       popCarTypeView.setTipa(new PopCarTypeView.CarCallback() {
           @Override
           public void callBack(String name,String luggage,int price) {
               PickupDetails.getOrderDetails().setCarmessage(name);
               PickupDetails.getOrderDetails().setPrice(price);
               PickupDetails.getOrderDetails().setLuggage(luggage);
               refreshData();
               if (isAll){
                   showPopluggum();
               }
           }
       });
   }
      private PopCarTypeView  popCarTypeView;
    public void showManView(){
        PopwindowUtils.getPopwindowUtils().show(popJourneyCounterView,tv4, BaseApplication.currentActivity());
    }
    public void showCarView(){
        if (CarPriceSend.getCarPriceSend().getPnum()==null){
            SnakebarUtils.showToast("请设置人数");
            return;
        }
        getCarMessage();
        PopwindowUtils.getPopwindowUtils().show(popCarTypeView,tv4, BaseApplication.currentActivity());
    }
    public Boolean isNull(TextView textView){
        if (TextUtils.isEmpty(textView.getText())){
            return  true;
        }
        return false;

    }
    public  void getCarMessage(){
        HttpVolley.getInstance().postMapRequest(ApiPost.getCarPriceTransPort,getMap(),new NetJsonArraySucceed<>(GetCarPrice.class, new NetJsonArraySucceed.HolderData<GetCarPrice>() {
            @Override
            public void holdData(ArrayList<GetCarPrice> bean) {
                popCarTypeView.setGetCarPrices(bean);

            }
        }),new NetError());
    }
    private Map<String,String> getMap(){
        Map<String,String>  map=new HashMap<>();
          if (ApiConstants.OrderlTpye==0){
            map.put("startCityName",PickupDetails.getOrderDetails().getArriveName());
            map.put("endCityName",CarPriceSend.getCarPriceSend().getEndCityName());
            map.put("pnum",CarPriceSend.getCarPriceSend().getPnum());
            map.put("startAddress",PickupDetails.getOrderDetails().getArriveAddress());
            map.put("eLng",CarPriceSend.getCarPriceSend().getSLng());
            map.put("eLat",CarPriceSend.getCarPriceSend().getSLat());
        }else if (ApiConstants.OrderlTpye==1){
              map.put("endCityName",PickupDetails.getOrderDetails().getArriveName());
              map.put("startCityName",CarPriceSend.getCarPriceSend().getEndCityName());
              map.put("pnum",CarPriceSend.getCarPriceSend().getPnum());
            map.put("endAddress",PickupDetails.getOrderDetails().getArriveAddress());
            map.put("sLng",CarPriceSend.getCarPriceSend().getSLng());
            map.put("sLat",CarPriceSend.getCarPriceSend().getSLat());

        }
        return map;
    }
    public void showPopluggum(){
        new PopluggumView(getContext()).show(tv4, new PopluggumView.CallBack() {
            @Override
            public void CallBack() {
                if (OrderDetails.getOrderDetails().getLuggage()!=null){
                    tv7.setText(OrderDetails.getOrderDetails().getLuggage());
                }
                if (isAll){
                    isAll=false;
                    showCarView();
                }
            }
        },Integer.valueOf(PickupDetails.getOrderDetails().getLuggage()));

    }
    private boolean  isAll=true;
    private BusCallBack busCallBack;
    public BusCallBack getBusCallBack() {
        return busCallBack;
    }
    public void setBusCallBack(BusCallBack busCallBack) {
        this.busCallBack = busCallBack;
    }
    public   interface   BusCallBack{
     void btncallback(TextView... textViews);
 }
}

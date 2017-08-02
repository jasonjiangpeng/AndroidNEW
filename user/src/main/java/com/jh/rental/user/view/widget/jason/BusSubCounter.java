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
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.ordermessage.GetCarPrice;
import com.jh.rental.user.model.NetResponArrayData;
import com.jh.rental.user.model.homemodel.RespCarPrice;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.internationnal.Passenger_Activity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCarCircuitView;
import com.jh.rental.user.view.widget.PopCarTypeView;
import com.jh.rental.user.view.widget.PopJourneyCounterView;
import com.jh.rental.user.view.widget.pickdate.PopTimeChoose;

import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/22.
 */

public class BusSubCounter extends LinearLayout implements View.OnClickListener {
    private   View inflate;
    private TextView tv4,tv5,tv6,tv7,tv8,tv9;
    private Button buttonbus;
    private PopTimeChoose popTimeView;
    private PopJourneyCounterView popJourneyCounterView;
    public BusSubCounter(Context context) {
        super(context);
    }
    public BusSubCounter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate = LayoutInflater.from(context).inflate(R.layout.bussubcounter, this);
        tv4= (TextView) inflate.findViewById(R.id.ordertv4);
        tv5= (TextView) inflate.findViewById(R.id.ordertv5);
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

    public void refreshData(){
        Logger.soutTestMessage("啊实打实大");
        if (OrderDetails.getOrderDetails().getMan()!=null){
            tv4.setText(OrderDetails.getOrderDetails().getMan());
        }
        if (OrderDetails.getOrderDetails().getChild()!=null){
            tv5.setText(OrderDetails.getOrderDetails().getChild());
        }
        if (OrderDetails.getOrderDetails().getCar()!=null){
            tv6.setText(OrderDetails.getOrderDetails().getCar());
        }

        if (OrderDetails.getOrderDetails().getDate()!=null){
            tv8.setText(OrderDetails.getOrderDetails().getDate());
        }
        if (OrderDetails.getOrderDetails().getPassenger()!=null){
            tv9.setText(OrderDetails.getOrderDetails().getPassenger());
        }
    }

    @Override
    public void onClick(final View v) {
              switch (v.getId()){
                  case R.id.ordertv4:
                      showManView();
                      break;
                  case R.id.ordertv5:
                      showManView();
                      break;
                  case R.id.ordertv6:
                      if (isNull(tv8)){
                          SnakebarUtils.show(null,"请选择日期");
                          return;
                      }
                      showCarView();

                      break;
                  case R.id.ordertv7:
                      if (isNull(tv6)){
                          SnakebarUtils.show(null,"选择车型");
                      }else {
                          showPopluggum();
                      }
                      break;
                  case R.id.ordertv8:
                      if (isNull(tv4)){
                          SnakebarUtils.show(null,"输入行李数");
                      }else {
                          showTimeView();
                      }
                      break;
                  case R.id.ordertv9:
                      ActivityUtils.nextActivity(Passenger_Activity.class);
                      break;
                  case R.id.buttonbus:
                      int man=Integer.valueOf(OrderDetails.getOrderDetails().getMan());
                      if (man>OrderDetails.getOrderDetails().getSeatNum()){
                          SnakebarUtils.showToast("出行人数不能大于车座，请重新选择",getContext());
                          return;
                      }
                       busCallBack.btncallback(tv4,tv5,tv6,tv7,tv8);
                      break;
              }
    }
   public void  initParmramer(){
       popTimeView=new PopTimeChoose(getContext());
       popJourneyCounterView=new PopJourneyCounterView(getContext());
       popTimeView.setCallBack(new PopTimeChoose.CallBack() {
           @Override
           public void getTime(String value) {
            //   value=getNewData(value);
               if (isAll){
                   showCarView();
                      }
               OrderDetails.getOrderDetails().setDate(value);
               refreshData();
           }
       });
       popJourneyCounterView.setTipa(new PopJourneyCounterView.PopTime() {
           @Override
           public void next(int man, int child) {
               if (isAll){
                   showTimeView();
               }
               OrderDetails.getOrderDetails().setMan(String.valueOf(man));
               OrderDetails.getOrderDetails().setChild(String.valueOf(child));
               refreshData();
           }
       });
       popCarTypeView=new PopCarTypeView(getContext());
       popCarTypeView.setTipa(new PopCarTypeView.CarCallback() {
           @Override
           public void callBack(String name,String s,int price) {
               if (isAll){
                 showPopluggum();
               }
               tv6.setText(name);
               OrderDetails.getOrderDetails().setCar(name);
               OrderDetails.getOrderDetails().setPrice(price);

              }
       });

   }

   private PopCarTypeView  popCarTypeView;
   public void showTimeView(){
       PopwindowUtils.getPopwindowUtils().show(popTimeView,tv4, BaseApplication.currentActivity());
   }
    public void showManView(){
        PopwindowUtils.getPopwindowUtils().show(popJourneyCounterView,tv4, BaseApplication.currentActivity());
    }
    public void showCarView(){
        if (ApiConstants.OrderlTpye==4){
            new PopCarCircuitView(getContext()).show(tv4, new PopCarCircuitView.CallBack() {
                @Override
                public void textSet(String value) {
                    tv6.setText(value);
                    if (isAll){
                        showPopluggum();
                    }
                }
            });
        }else {
            getCarPrice();
            PopwindowUtils.getPopwindowUtils().show(popCarTypeView,tv4, BaseApplication.currentActivity());
        }


    }
    public Boolean isNull(TextView textView){

        return TextUtils.isEmpty(textView.getText());
    }
    public void showPopluggum(){
        new PopluggumView(getContext()).show(tv4, new PopluggumView.CallBack() {
            @Override
            public void CallBack() {
                if (isAll){
                    isAll=false;
                //    showCarView();
                }
                if (OrderDetails.getOrderDetails().getLuggage()!=null){
                    tv7.setText(OrderDetails.getOrderDetails().getLuggage());
                }

            }
        },Integer.valueOf(OrderDetails.getOrderDetails().getCarShowLuggmu()));
    }
    public  void getCarPrice(){
        new RespCarPrice().netResq(new NetResponArrayData<GetCarPrice>() {
            @Override
            public void responeData(List<GetCarPrice> values) {
                popCarTypeView.setGetCarPrices(values);
            }
        });

    }

    private boolean  isAll=true;
    private BusCallBack busCallBack;
 /*   private String  getNewData(String  value){
        String  valuess=value.split(" ")[0];
        for (int i = 0; i <value.split(" ")[1].split(":").length ; i++) {
            String  na=value.split(" ")[1].split(":")[i];
            if (na.length()<2){
                na=0+na;
            }
            valuess+=na;
        }

        return valuess;
    }*/
    public BusCallBack getBusCallBack() {
        return busCallBack;
    }

    public void setBusCallBack(BusCallBack busCallBack) {
        this.busCallBack = busCallBack;
    }

    public   interface   BusCallBack{
     void btncallback(TextView...textViews);
 }
}

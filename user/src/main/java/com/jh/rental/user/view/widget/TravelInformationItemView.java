package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.CarPriceSend;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.order.OrderInfoBean;


public class TravelInformationItemView extends LinearLayout {
    public TravelInformationItemView(Context context) {
        this(context, null);
    }
    public TravelInformationItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private LinearLayout lasu2,lasu1,layoutAll,layoutitem;
    private TextView starttv1,starttv2,starttv3,starttv4,tvone,tvtwo;
    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sub_item_travelinformation, this);
        tvone= (TextView) findViewById(R.id.tvone);
        layoutAll= (LinearLayout) findViewById(R.id.layoutAll);
        layoutitem= (LinearLayout) findViewById(R.id.layoutitem);
        lasu1= (LinearLayout) findViewById(R.id.lasu1);
        lasu2= (LinearLayout) findViewById(R.id.lasu2);
        lasu1.setVisibility(GONE);
        lasu2.setVisibility(GONE);
        starttv1= (TextView) findViewById(R.id.starttv1);
        starttv2= (TextView) findViewById(R.id.starttv2);
        starttv3= (TextView) findViewById(R.id.starttv3);
        starttv4= (TextView) findViewById(R.id.starttv4);
         tvtwo= (TextView) findViewById(R.id.tvtwo);
        //setOrderTpye();

    }
    public void setVaue(OrderInfoBean object){
        starttv1.setText(object.getBeginAdr());
        starttv4.setText(object.getEndAdr());
        if (object.getOrderWay()!=null){
            int a=object.getOrderWay().size();
            if (a==1){
                lasu1.setVisibility(VISIBLE);
                starttv2.setText(object.getOrderWay().get(0).getAdrs());
            }
            if (a==2){
                lasu1.setVisibility(VISIBLE);
                lasu2.setVisibility(VISIBLE);
                starttv2.setText(object.getOrderWay().get(0).getAdrs());
                starttv3.setText(object.getOrderWay().get(1).getAdrs());
            }
        }
    }
    public void setOrderTpye(){
           if (callback!=null){
               callback.calllbback();
           }
           if (ApiConstants.OrderlTpye==2){
               setZhuanche();
           }else if (ApiConstants.OrderlTpye==3){
               layoutAll.setVisibility(GONE);
               layoutitem.setVisibility(VISIBLE);
               String  value=String.format(OrderDetails.getOrderDetails().getCity()+"%d天游",ApiConstants.Day);
               tvone.setText(value);
               String  value2=OrderDetails.getOrderDetails().getDate()+" ("+String.format("%d天",ApiConstants.Day)+")";
               tvtwo.setText(value2);
           }else {
               setPickCar();
           }
    }
    private void setPickCar() {
        if (lasu1!=null){
            lasu1.setVisibility(GONE);
        }
        if (lasu2!=null){
            lasu2.setVisibility(GONE);
        }
        starttv1.setText(PickupDetails.getOrderDetails().getArriveAddress());
        starttv4.setText(CarPriceSend.getCarPriceSend().getEndAddress());


    }

    public void setZhuanche(){
        setValue=OrderDetails.getOrderDetails();
        int size= setValue.getSize();
        if (size==3){
            lasu2.setVisibility(GONE);
            starttv2.setText(setValue.getWaycity1());
        }else if (size==2){
            if (lasu1!=null){
                lasu1.setVisibility(GONE);
            }
            if (lasu2!=null){
                lasu2.setVisibility(GONE);
            }
        }else if (size==4){
            starttv2.setText(setValue.getWaycity1());
            starttv3.setText(setValue.getWaycity2());
        }
        starttv1.setText(setValue.getCitysub());

        starttv4.setText(setValue.getDescity()+setValue.getEndAdrName());
    }
private OrderDetails  setValue;

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    private Callback  callback;
  public   interface  Callback{
        void  calllbback();

    }
}

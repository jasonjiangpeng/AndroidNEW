package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.CarPriceSend;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.TextsUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.actitity.hongkong.UploadData_Activity;
import com.jh.rental.user.view.actitity.journey.AfterPayment_Activity_;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by 骏辉出行 on 2017/5/26.
 */

public class PaySuccess_Activity extends TitelBarAcitvity implements View.OnClickListener {
   // int TAB = 1;
    private TextView  lookOrder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paysuccess_activity);
        setMyTitel(BaseContext.getResValue(R.string.pay));
        initView();
    }
private Button payfinish;
    private EditText payfinishedt1;
    private void initView() {
        Button buttonPlanning = (Button) findViewById(R.id.button_planning);
        payfinish = (Button) findViewById(R.id.payfinish);
        payfinishedt1 = (EditText) findViewById(R.id.payfinishedt1);
        payfinish.setOnClickListener(this);
        LinearLayout ll_conceal = (LinearLayout) findViewById(R.id.ll_conceal);
        LinearLayout ll_HongKong = (LinearLayout) findViewById(R.id.ll_HongKong);
        Button uploadData = (Button) findViewById(R.id.uploadData);
         lookOrder = (TextView) findViewById(R.id.lookOrder);
        lookOrder.setOnClickListener(this);
        buttonPlanning.setOnClickListener(this);
        uploadData.setOnClickListener(this);
        isNeedVisa(ll_HongKong);
         if (ApiConstants.OrderlTpye==3||ApiConstants.OrderlTpye==4){
            ll_conceal.setVisibility(View.VISIBLE);
        }
    }
    private String cityVisa="香港";
    private void isNeedVisa(LinearLayout  linearLayout){
   if (!TextUtils.equals(PickupDetails.getOrderDetails().getArriveName(),CarPriceSend.getCarPriceSend().getEndCityName())&&TextUtils.equals(CarPriceSend.getCarPriceSend().getEndCityName(),cityVisa)){
       linearLayout.setVisibility(View.VISIBLE);
   }

   if (!TextUtils.equals(OrderDetails.getOrderDetails().getCitysub(),OrderDetails.getOrderDetails().getDescity())&&TextUtils.equals(OrderDetails.getOrderDetails().getDescity(),cityVisa)){
            linearLayout.setVisibility(View.VISIBLE);
        }



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_planning:
                ActivityUtils.nextActivity(AddTrip1_Activity.class);
                break;
            case R.id.payfinish:
                if (payfinishedt1.getText().toString().length()>0){
                    reqNet();
                }
                BaseApplication.getLoginActivity();

                break;
            case R.id.uploadData:
               ActivityUtils.nextActivity(UploadData_Activity.class);
                break;
            case R.id.lookOrder:
                ActivityUtils.nextActivity(AfterPayment_Activity_.class, "order1", OrderDetails.getOrderDetails().getOrderId());
                break;
        }

    }
    private void reqNet(){
        HttpVolley.getInstance().postMapRequest(ApiPost.addOrderRemark, getmap(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



            }
        });
    }
   private Map<String,String> getmap(){
       Map<String,String>  map=new HashMap<>();
       map.put("orderId",OrderDetails.getOrderDetails().getOrderId());
       map.put("remark",payfinishedt1.getText().toString());

       return map;
   }


}

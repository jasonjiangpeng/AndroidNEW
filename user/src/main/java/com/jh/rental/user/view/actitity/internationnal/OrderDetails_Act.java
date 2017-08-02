package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.model.order.OrderList;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

/**
 * Created by 骏辉出行 on 2017/5/26.
 * 专车接送
 */

public class OrderDetails_Act extends  TitelBarAcitvity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    String indent = null;
    public static int TAB = 1;
    private CheckBox checkBox1,checkBox2;
    private PickupDetails pickupDetails;
    private TextView orderi1,orderi2,orderi3,orderi4,orderi5,orderi6,orderi7,orderi8;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderdetails_activity);
        pickupDetails =PickupDetails.getOrderDetails();
        setMyTitel(BaseContext.getResValue(R.string.OrderDetails));
        initText();
        init();
    }
    @Override
    protected void onResume() {
        super.onResume();
        setTextValue();
    }
    public void initText(){
        orderi1= (TextView) findViewById(R.id.orderi1);
        orderi2= (TextView) findViewById(R.id.orderi2);
        orderi3= (TextView) findViewById(R.id.orderi3);
        orderi4= (TextView) findViewById(R.id.orderi4);
        orderi5= (TextView) findViewById(R.id.orderi5);
        orderi6= (TextView) findViewById(R.id.orderi6);
        orderi7= (TextView) findViewById(R.id.orderi7);
        orderi8= (TextView) findViewById(R.id.orderi8);
    }
    public void setTextValue(){
        orderi1.setText(pickupDetails.getMancounts());
        orderi2.setText(pickupDetails.getChild());
        orderi3.setText(pickupDetails.getCarmessage());
        orderi4.setText(pickupDetails.getLuggage());
        orderi5.setText("￥"+String.valueOf(pickupDetails.getPrice()));
        if (ApiConstants.coupow>0){
            orderi6.setText("-￥"+String.valueOf(ApiConstants.coupow));
        }else {
            orderi6.setText("0");
        }
        int allrulst= (int) (pickupDetails.getPrice()-ApiConstants.coupow);
        orderi7.setText("￥"+String.valueOf(allrulst));
        orderi8.setText(String.valueOf(allrulst));
    }
    private void init() {
        LinearLayout ll_tiiv = (LinearLayout) findViewById(R.id.ll_tiiv);
        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        //   TextView tv_tiiv = (TextView) findViewById(R.id.tv_tiiv);
        if ( getIntent().getStringExtra("indent")!=null){
            indent=getIntent().getStringExtra("indent");
            if ("CharteredBu".equals(indent)){
                ll_tiiv.setVisibility(View.GONE);
                TAB = 2;
            }else {
                TAB = 1;
            }
        }
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    @Override
    public void handleManage(int value) {

    }
    String  tpye="1";
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (checkBox1.isChecked()){
                    tpye="5";
                }else {
                    tpye="2";
                }
                if (tpye.equals("2")){
                    new Thread(){
                        @Override
                        public void run() {
                            Logger.soutMessage(System.currentTimeMillis());
                            OrderList orderList = new OrderList();
                            orderList.getPayDatas(OrderDetails.getOrderDetails().getOrderId(), tpye,"0");
                        }
                    }.start();
                }else if (tpye.equals("5")){
                    new OrderList().getPayWx(OrderDetails.getOrderDetails().getOrderId(),tpye,"0");
                }
             //   ActivityUtils.nextActivity(PaySuccess_Activity.class);
                break;
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.checkbox2:
                if(isChecked) checkBox1.setChecked(false);
                else checkBox1.setChecked(true);
                checkBox1.setClickable(true);
                checkBox2.setClickable(false);
                break;
            case R.id.checkbox1:
                if(isChecked) checkBox2.setChecked(false);
                else checkBox2.setChecked(true);
                checkBox1.setClickable(false);
                checkBox2.setClickable(true);
                break;
        }
    }
}

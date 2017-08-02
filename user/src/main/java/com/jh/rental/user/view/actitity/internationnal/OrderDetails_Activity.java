package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.order.OrderInfoBean;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.model.NetResponData;
import com.jh.rental.user.model.order.OrderInfo;
import com.jh.rental.user.model.order.OrderList;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.actitity.person.Coupons_Activity_;
import com.jh.rental.user.view.actitity.person.UserAgreement_Activity_;
import com.jh.rental.user.view.widget.TravelInformationItemView;

import java.text.DecimalFormat;

import static com.jh.rental.user.api.ApiConstants.orderId;

/**
 * Created by 骏辉出行 on 2017/5/26.
 * 专车接送
 */

public class OrderDetails_Activity extends TitelBarAcitvity implements View.OnClickListener/*, CompoundButton.OnCheckedChangeListener*/ {
    String indent = null;
    public static int TAB, TAB2 = 1;
    private ImageView agreed, WeChat, pay;
    //    private CheckBox checkBox1, checkBox2;
    private LinearLayout userCouponId, addpoint3, addpoint2, addpoint1, llAgreed, llWeChat, llPay;
    TravelInformationItemView informationItemView;
    private TextView orderi1, orderi2, orderi3, orderi4, orderi5, orderi6, orderi7, orderi8, wayPrice, nightPrice, bannerPrice, rules;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApiConstants.coupow = 0;
        setContentView(R.layout.orderdetails_activity);
        setMyTitel(BaseContext.getResValue(R.string.OrderDetails));
        initText();
        init();
        new OrderInfo().reqNet(new NetResponData<OrderInfoBean>() {
            @Override
            public void responeData(final OrderInfoBean object) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setTextValue(object);
                    }
                }, 10);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ApiConstants.coupow > 0) {
            if (ApiConstants.coupow - ApiConstants.limitUseMax >= 0) {
                if (priceSum - ApiConstants.limitUseMax < 0) {
                    orderi6.setText("" + priceSum);
                } else {
                    orderi6.setText("" + ApiConstants.limitUseMax);
                }
            } else {
                orderi6.setText("" + ApiConstants.coupow);
            }
            getAllPrice();
        }
        //   setTextValue();
    }

    public void initText() {
        orderi1 = (TextView) findViewById(R.id.orderi1);
        orderi2 = (TextView) findViewById(R.id.orderi2);
        orderi3 = (TextView) findViewById(R.id.orderi3);
        orderi4 = (TextView) findViewById(R.id.orderi4);
        orderi5 = (TextView) findViewById(R.id.orderi5);
        orderi6 = (TextView) findViewById(R.id.orderi6);
        orderi7 = (TextView) findViewById(R.id.orderi7);
        informationItemView = (TravelInformationItemView) findViewById(R.id.routevalue);
        orderi8 = (TextView) findViewById(R.id.orderi8);
        wayPrice = (TextView) findViewById(R.id.wayPrice);
        agreed = (ImageView) findViewById(R.id.agreed);
        WeChat = (ImageView) findViewById(R.id.WeChat);
        pay = (ImageView) findViewById(R.id.pay);
        rules = (TextView) findViewById(R.id.rules);
        nightPrice = (TextView) findViewById(R.id.nightPrice);
        bannerPrice = (TextView) findViewById(R.id.bannerPrice);
        userCouponId = (LinearLayout) findViewById(R.id.userCouponId);
        addpoint3 = (LinearLayout) findViewById(R.id.addpoint3);
        addpoint2 = (LinearLayout) findViewById(R.id.addpoint2);
        addpoint1 = (LinearLayout) findViewById(R.id.addpoint1);
        llAgreed = (LinearLayout) findViewById(R.id.ll_agreed);
        llWeChat = (LinearLayout) findViewById(R.id.ll_WeChat);
        llPay = (LinearLayout) findViewById(R.id.ll_pay);
        userCouponId.setOnClickListener(this);
        llAgreed.setOnClickListener(this);
        llWeChat.setOnClickListener(this);
        llPay.setOnClickListener(this);
        rules.setOnClickListener(this);
    }

    private void setTextValue(OrderInfoBean object) {
        orderId = object.getOrderId();
        informationItemView.setVaue(object);
        orderi1.setText(object.getNumber() + "人");
        if (object.getChildrenNumber() == "") {    //小孩
            orderi2.setText("0人");
        } else {
            orderi2.setText(object.getChildrenNumber() + "人");
        }
        orderi3.setText(object.getModelName());
        if (object.getLuggleNum() != "") {
            orderi4.setText(object.getLuggleNum() + "件");
        } else {
            orderi4.setText("0件");
        }
        orderi5.setText("￥" + object.getLxPrice());
        if (!"0.0".equals(object.getYhPrice())) {
            orderi6.setText("-￥" + object.getYhPrice());
        } else {
            orderi6.setText("0");
        }
        priceSum = Double.valueOf(object.getPriceSum());
        orderi7.setText("￥" + priceSum);
        if (object.getWayPrice() > 0) {
            addpoint1.setVisibility(View.VISIBLE);
            wayPrice.setText("￥" + String.valueOf(object.getWayPrice()));
        }
        if (object.getNightPrice() > 0) {
            addpoint2.setVisibility(View.VISIBLE);
            nightPrice.setText("￥" + String.valueOf(object.getNightPrice()));
        }
        if (object.getBannerPrice() > 0) {
            addpoint3.setVisibility(View.VISIBLE);
            bannerPrice.setText("￥" + String.valueOf(object.getBannerPrice()));
        }
        getAllPrice();
    }

    //   private double coupon=0;
    private double priceSum;
    Double result;

    private void getAllPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("#####0.00");
        if (priceSum - ApiConstants.limitUseMax > 0) {
            if (ApiConstants.limitUseMax > ApiConstants.coupow) {
                result = priceSum - ApiConstants.coupow;
            } else {
                result = priceSum - ApiConstants.limitUseMax;
            }
        } else {
            result = priceSum - ApiConstants.coupow;
        }
        if (result < 0) {
            orderi8.setText(decimalFormat.format(0));
        } else {
            orderi8.setText(decimalFormat.format(result));
        }

    }

    private String tpye = "5";

    private void init() {
       /* checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);*/
        if (getIntent().getStringExtra("indent") != null) {
            indent = getIntent().getStringExtra("indent");
            if ("CharteredBu".equals(indent)) {
                TAB = 2;
            } else {
                TAB = 1;
            }
        }
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void handleManage(int value) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (TAB2 != 2) {
                   /*if (checkBox1.isChecked()) {
                        tpye = "5";
                    } else {
                        tpye = "2";
                    }*/
                    if (tpye.equals("2")) {
                        new Thread() {
                            @Override
                            public void run() {
                                Logger.soutMessage(System.currentTimeMillis());
                                OrderList orderList = new OrderList();
                                orderList.getPayDatas(OrderDetails.getOrderDetails().getOrderId(), tpye, OrderDetails.getOrderDetails().getUserCouponId());
                                if (result < 0) {
                                    ActivityUtils.nextActivity(PaySuccess_Activity.class);
                                    finish();
                                }
                            }
                        }.start();
                    } else if (tpye.equals("5")) {
                        new OrderList().getPayWx(OrderDetails.getOrderDetails().getOrderId(), tpye, OrderDetails.getOrderDetails().getUserCouponId());
                        if (result < 0) {
                            ActivityUtils.nextActivity(PaySuccess_Activity.class);
                            finish();
                        }
                    }
                } else {
                    SnakebarUtils.showToast("请阅读用户协议。");
                }
                //   ActivityUtils.nextActivity(PaySuccess_Activity.class);
                break;
            case R.id.userCouponId:
                if (Constant.COUPON == 0) {
                    ActivityUtils.nextActivity(Coupons_Activity_.class, "Coupons_Activity_", priceSum);
                }
                break;
            case R.id.ll_agreed:
                if (TAB2 == 1) {
                    TAB2 = 2;
                    agreed.setBackgroundResource(R.drawable.jinggaoicon);
                } else {
                    agreed.setBackgroundResource(R.drawable.tongyiicon);
                    TAB2 = 1;
                }
                break;
            case R.id.rules:
                ActivityUtils.nextActivity(UserAgreement_Activity_.class);
                break;
            case R.id.ll_WeChat:
                WeChat.setBackgroundResource(R.drawable.xuanzhongxxhdpi);
                pay.setBackgroundResource(R.drawable.w_p_dxxhdpi);
                tpye = "5";
                break;
            case R.id.ll_pay:
                pay.setBackgroundResource(R.drawable.xuanzhongxxhdpi);
                WeChat.setBackgroundResource(R.drawable.w_p_dxxhdpi);
                tpye = "2";
                break;
        }
    }

   /* @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.checkbox2:
                if (isChecked) checkBox1.setChecked(false);
                else checkBox1.setChecked(true);
                checkBox1.setClickable(true);
                checkBox2.setClickable(false);
                break;
            case R.id.checkbox1:
                if (isChecked) checkBox2.setChecked(false);
                else checkBox2.setChecked(true);
                checkBox1.setClickable(false);
                checkBox2.setClickable(true);
                break;
        }
    }*/
}

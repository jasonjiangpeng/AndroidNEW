package com.jh.rental.user.view.actitity.journey;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.login.ModifyLsign;
import com.jh.rental.user.bean.order.EveryDay;
import com.jh.rental.user.bean.order.FindOrderDetailBean;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.presenter.huanxin.HxChat;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.AppUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.journey.CustomLineAdapter;
import com.jh.rental.user.view.adapter.journey.VisaAdapter;
import com.jh.rental.user.view.dialog.MyDialog2;
import com.jh.rental.user.view.widget.TravelInformationItemView2;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.jh.rental.user.R.id.totalAmount;

@EActivity(R.layout.afterpayment_activity)
public class AfterPayment_Activity extends TitelBarAcitvity {
    @ViewById(R.id.iv_img1)
    ImageView mIvImg1;
    @ViewById(R.id.iv_img2)
    ImageView mIvImg2;
    @ViewById(R.id.iv_img3)
    ImageView mIvImg3;
    @ViewById(R.id.ll_click1)
    LinearLayout mLlClick1;
    @ViewById(R.id.ll_click2)
    LinearLayout mLlClick2;
    @ViewById(R.id.ll_click3)
    LinearLayout mLlClick3;
    @ViewById(R.id.information)
    LinearLayout mInformation;
    @ViewById(R.id.cost)
    LinearLayout mCost;
    @ViewById(R.id.rv_visa)
    RecyclerView mRvVisa;
    @ViewById(R.id.routevalue)
    TravelInformationItemView2 routevalue;
    @ViewById(R.id.tv_city)
    TextView mTvCity;
    /* @ViewById(R.id.starttv4)
     TextView mStarttv4;*/
    @ViewById(R.id.time)
    TextView mTime;
    @ViewById(R.id.adult)
    TextView mAdult;
    @ViewById(R.id.child)
    TextView mChild;
    @ViewById(totalAmount)
    TextView mTotalAmount;
    @ViewById(R.id.coupons)
    TextView mCoupons;
    @ViewById(R.id.text1)
    TextView mText1;
    @ViewById(R.id.text2)
    TextView mText2;
    @ViewById(R.id.text3)
    TextView mText3;
    @ViewById(R.id.text4)
    TextView mText4;
    @ViewById(R.id.models)
    TextView mModels;
    @ViewById(R.id.luggage)
    TextView mLuggage;
    @ViewById(R.id.amount)
    TextView mAmount;
    @ViewById(R.id.ll_city)
    LinearLayout mLlCity;
    @ViewById(R.id.wayPrice)
    TextView mWayPrice;
    @ViewById(R.id.nightPrice)
    TextView mNightPrice;
    @ViewById(R.id.bannerPrice)
    TextView mBannerPrice;
    @ViewById(R.id.ll_wayPrice)
    LinearLayout mLlWayPrice;
    @ViewById(R.id.ll_nightPrice)
    LinearLayout mLlNightPrice;
    @ViewById(R.id.ll_bannerPrice)
    LinearLayout mLlBannerPrice;
    @ViewById(R.id.ll_ShutDown1)
    LinearLayout mLlShutDown1;
    @ViewById(R.id.ll_ShutDown2)
    LinearLayout mLlShutDown2;
    @ViewById(R.id.Pickup)
    LinearLayout mPickup;
    @ViewById(R.id.rv_PickUp)
    RecyclerView mRvPickUp;
    int flag1, flag2, flag3 = 0;
    String mOrder1;
    Gson gson;
    private List<FindOrderDetailBean> listOrder;
    private List<EveryDay> list;
    int tap = 0;

    @AfterViews
    public void afterview() {
        gson = new Gson();
        setMyTitel(BaseContext.getResValue(R.string.myjoureny));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvVisa.setLayoutManager(linearLayoutManager);
        mRvVisa.setAdapter(new VisaAdapter(this));
        listOrder = new ArrayList<>();
        sendRequestData();
        mRvPickUp.setHasFixedSize(true);
        mRvPickUp.setLayoutManager(new GridLayoutManager(this, 1));
       /* mRvPickUp.setAdapter(new CustomLineAdapter(this, list));*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        sendRequestData();
    }

    public void sendRequestData() {
        if (getIntent() != null && getIntent().getStringExtra("order1") != null) {
            mOrder1 = getIntent().getStringExtra("order1");
        }
        HttpVolley.getInstance().getRequestIdData(ApiGet.findOrderDetail, mOrder1, new NetSucceed<>(FindOrderDetailBean.class, new NetSucceed.HolderData<FindOrderDetailBean>() {
            @Override
            public void holdData(FindOrderDetailBean bean) {
                if (bean == null) {
                    return;
                }
                listOrder.add(bean);
                if (bean.getBase().getDayRemark() != "") {
                    list = gson.fromJson(bean.getBase().getDayRemark(), new TypeToken<List<EveryDay>>() {
                    }.getType());
                    Collections.sort(list, new Comparator<EveryDay>() {
                        @Override
                        public int compare(EveryDay lhs, EveryDay rhs) {
                            return Integer.parseInt(lhs.getDay()) - Integer.parseInt(rhs.getDay());
                        }
                    });
                    mRvPickUp.setAdapter(new CustomLineAdapter(AfterPayment_Activity.this, list));
                }
                handler.sendEmptyMessage(10);
            }
        }), new NetError());
    }

    public Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 10) {
                FindOrderDetailBean.BaseBean base = listOrder.get(0).getBase();
                FindOrderDetailBean.PriceBean base2 = listOrder.get(0).getPrice();

                if (base.getOrderKind() == "1" & base.getIsExistL() == "0" & base.getBegin_address().indexOf("香港") == -1 & base.getEnd_address().indexOf("香港") != -1) {
                    mLlShutDown2.setVisibility(View.VISIBLE);
                    modifyL();
                } else {
                    if (!"".equals(base.getDayNum())) {
                        if ("".equals(base.getDayRemark())) {
                            Constant.DAY = 1;
                            tap = 1;
                            mLlShutDown1.setVisibility(View.VISIBLE);
                        } else {
                            if (Integer.parseInt(base.getDayNum()) > list.size()) {
                                Constant.DAY = list.size() + 1;
                                tap = 0;
                                mLlShutDown1.setVisibility(View.VISIBLE);
                            }
                            mPickup.setVisibility(View.VISIBLE);
                        }
                    }
                }
                int type = Integer.parseInt(base.getService_type());
                switch (type) {
                    case 1:
                    case 5:
                    case 6:
                        mTvCity.setVisibility(View.VISIBLE);
                        mLlCity.setVisibility(View.GONE);
                        mTvCity.setText(base.getCircuitName());
                        break;
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                        routevalue.setVaue(base);
                        /*mStarttv1.setText(base.getBegin_adr());
                        mStarttv4.setText(base.getEnd_adr());*/
                        break;
                }
                mTime.setText(base.getBegin_time());
                if (base.getChildren_number() == "") {
                    mChild.setText("0人");//小孩数
                    mAdult.setText(base.getNumber() + "人");//成人数
                } else {
                   /* int n = Integer.parseInt(base.getNumber());
                    int c = Integer.parseInt(base.getChildren_number());
                    mAdult.setText((n - c) + "人");//成人数*/
                    mAdult.setText(base.getNumber() + "人");//成人数
                    mChild.setText(base.getChildren_number() + "人");//小孩数
                }
                if ("".equals(base.getBrand())) {//车型
                    mModels.setText(base.getModel());
                } else {
                    mModels.setText(base.getBrand() + "-" + base.getModel());
                }
                if (!"".equals(base.getBaggage_num())) {
                    mLuggage.setText(base.getBaggage_num() + "件");
                } else {
                    mLuggage.setText("0件");
                }
                mText1.setText(base.getNick_name());
                mText2.setText(base.getCcrMobile());
                mText3.setText(base.getCreateTime());
                mText4.setText(base.getCode());
                mAmount.setText("￥" + base2.getFare_price());
                if (Double.parseDouble(base2.getAmtPrice()) != 0) {
                    mCoupons.setText("-￥" + base2.getAmtPrice());
                } else {
                    mCoupons.setText("0");
                }
                if (Double.parseDouble(base2.getWayPrice()) != 0) {
                    mLlWayPrice.setVisibility(View.VISIBLE);
                    mWayPrice.setText("￥" + base2.getWayPrice());
                }
                if (Double.parseDouble(base2.getNightPrice()) != 0) {
                    mLlNightPrice.setVisibility(View.VISIBLE);
                    mNightPrice.setText("￥" + base2.getNightPrice());
                }
                if (Double.parseDouble(base2.getBannerPrice()) != 0) {
                    mLlBannerPrice.setVisibility(View.VISIBLE);
                    mBannerPrice.setText("￥" + base2.getBannerPrice());
                }
                mTotalAmount.setText("￥" + base2.getPriceSum());

                if (!"".equals(base.getFlowId())) {
                    Constant.LINEID = base.getFlowId();
                }
                Constant.ORDERID = base.getId();
            }
        }
    };

    private void modifyL() {
        ModifyLsign modifyLsign = new ModifyLsign(mOrder1, "1");
        String body = GsonUtlis.getIntance().toJson(modifyLsign, ModifyLsign.class);
        HttpVolley.getInstance().postJson(ApiPost.updateIsExistL, body, new HttpVolley.CallBack() {
            @Override
            public void callback(JSONObject response) {
            }

            @Override
            public void failCallback(JSONObject response) {
                try {
                    if (response.getString("msg") != null) {
                        SnakebarUtils.showToast(response.getString("msg"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //    private int totalDay = 3;
    @Click({R.id.planning, R.id.button, R.id.ll_click1, R.id.ll_click2, R.id.ll_click3, R.id.refund, /*R.id.share, */R.id.consult})
    void ClickOnTheJumpPage(View v) {
        switch (v.getId()) {
            case R.id.refund://退单
                final MyDialog2 myDialog = new MyDialog2(this);
                myDialog.getWindow().setLayout(AppUtils.getScreenWH(0) * 5 / 6, AppUtils.getScreenWH(1) / 5);
                myDialog.setTitel(BaseContext.getResValue(R.string.CancelTheOrder));
                myDialog.setOnNegativeListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                myDialog.setOnPositiveListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cancelOrder(listOrder.get(0).getBase().getId());
                        finish();
                        myDialog.dismiss();
                    }
                });
                myDialog.show();
                break;
           /* case R.id.share://分享

                break;*/
            case R.id.consult://咨询
                HxChat.session(this);
                break;
            case R.id.planning:
                FindOrderDetailBean.BaseBean base = listOrder.get(0).getBase();
                int totalDay = Integer.parseInt(base.getDayNum());
                Constant.TOTALDAY = totalDay;
                if (totalDay == Constant.DAY) {
                    if (base.getDayRemark() != "") {
                        SnakebarUtils.showToast(list.size() + "");
                        if (list.size() != 0) {
                            Constant.DAY = list.size() + 1;
                        }
                    }
                    ActivityUtils.nextActivity(AddLine3_Activity.class);
                } else {
                    if (tap != 1) {
                        Constant.DAY = list.size() + 1;
                    }
                    ActivityUtils.nextActivity(AddLine1_Activity.class);
                }
                finish();
                break;
            case R.id.button:
                ActivityUtils.nextActivity(OtherNeed_Activity.class);
                break;
            case R.id.ll_click1:
                if (flag1 == 0) {
                    mIvImg1.setBackgroundResource(R.drawable.w_g_sbxxhdpi);
                    mInformation.setVisibility(View.VISIBLE);
                    flag1 = 1;
                } else {
                    mIvImg1.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mInformation.setVisibility(View.GONE);
                    flag1 = 0;
                }
                break;
            case R.id.ll_click2:
                if (flag2 == 0) {
                    mIvImg2.setBackgroundResource(R.drawable.w_g_sbxxhdpi);
                    mCost.setVisibility(View.VISIBLE);
                    flag2 = 1;
                } else {
                    mIvImg2.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mCost.setVisibility(View.GONE);
                    flag2 = 0;
                }
                break;
            case R.id.ll_click3:
                if (flag3 == 0) {
                    mIvImg3.setBackgroundResource(R.drawable.w_g_sbxxhdpi);
                    mRvPickUp.setVisibility(View.VISIBLE);
                    flag3 = 1;
                } else {
                    mIvImg3.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mRvPickUp.setVisibility(View.GONE);
                    flag3 = 0;
                }
                break;
        }
    }

    private void cancelOrder(String id) {
        HttpVolley.getInstance().getRequestIdData(ApiGet.cancelOrder, id, new NetSucceed<>(String.class, new NetSucceed.HolderData<String>() {
            @Override
            public void holdData(String bean) {
            }
        }), new NetError());
    }
}

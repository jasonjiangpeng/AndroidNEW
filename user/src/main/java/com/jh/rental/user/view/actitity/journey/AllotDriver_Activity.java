package com.jh.rental.user.view.actitity.journey;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.order.FindOrderDetailBean;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import java.util.ArrayList;
import java.util.List;

public class AllotDriver_Activity extends TitelBarAcitvity implements View.OnClickListener {

    int flag1 = 0;
    int flag2 = 0;
    ImageView mIvImg1,mIvImg2;
    LinearLayout mLlShutDown,mLlClick1,mLlClick2,mInformation,mCost,mLlCity;
    TextView mStart,mEnd,mTime,mAdult,mChild,mModels,mLuggage,mAmount,mCoupons,mTotalAmount,mText1,mText2,mText3,mText4,mTvCity;
    String mOrder1,statusName;
    private List<FindOrderDetailBean> listOrder ;
    @Override
    public void initParameter() {
        listOrder =new ArrayList<>();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allotdriver_activity);
        setMyTitel(BaseContext.getResValue(R.string.travel));
        initView();
    }

    private void initView() {
        mIvImg1 = (ImageView)findViewById(R.id.iv_img1);
        mIvImg2 = (ImageView)findViewById(R.id.iv_img2);

        mLlShutDown = (LinearLayout)findViewById(R.id.ll_ShutDown);
        mLlClick1 = (LinearLayout)findViewById(R.id.ll_click1);
        mLlClick2 = (LinearLayout)findViewById(R.id.ll_click2);
        mInformation = (LinearLayout)findViewById(R.id.information);
        mCost = (LinearLayout)findViewById(R.id.cost);
        mStart = (TextView)findViewById(R.id.starttv1);
        mLlCity = (LinearLayout)findViewById(R.id.ll_city);
        mTvCity = (TextView)findViewById(R.id.tv_city);
        mEnd = (TextView)findViewById(R.id.starttv4);
        mTime= (TextView)findViewById(R.id.time);
        mAdult= (TextView)findViewById(R.id.adult);
        mChild= (TextView)findViewById(R.id.child);
        mModels= (TextView)findViewById(R.id.models);
        mLuggage= (TextView)findViewById(R.id.luggage);
        mAmount= (TextView)findViewById(R.id.amount);
        mCoupons= (TextView)findViewById(R.id.coupons);
        mTotalAmount= (TextView)findViewById(R.id.totalAmount);
        mText1= (TextView)findViewById(R.id.text1);
        mText2= (TextView)findViewById(R.id.text2);
        mText3= (TextView)findViewById(R.id.text3);
        mText4= (TextView)findViewById(R.id.text4);
        mLlClick1.setOnClickListener(this);
        mLlClick2.setOnClickListener(this);
    }

    @Override
    public void sendRequestData() {
        if (getIntent()!=null&&getIntent().getStringExtra("order1")!=null){
            mOrder1 = getIntent().getStringExtra("order1");
        }
        HttpVolley.getInstance().getRequestIdData(ApiGet.findOrderDetail,mOrder1,new NetSucceed<>(FindOrderDetailBean.class, new NetSucceed.HolderData<FindOrderDetailBean>() {
            @Override
            public void holdData(FindOrderDetailBean bean) {
                if (bean==null){return;}
                listOrder.add(bean);
                handler.sendEmptyMessage(10);
            }
        }),new NetError());
    }

    @Override
    public void handleManage(int value) {
        if (value==10){
            FindOrderDetailBean.BaseBean base = listOrder.get(0).getBase();
            statusName = base.getStatusName();
            int type =  Integer.parseInt(base.getService_type());
            switch (type){
                case 1:
                case 5:
                case 6:
                    mLlCity.setVisibility(View.GONE);
                    mTvCity.setVisibility(View.VISIBLE);
                    mTvCity.setText(base.getBegin_adr()+"");
                    break;
                case 0:
                case 2:
                case 3:
                case 4:
                    mStart.setText(base.getBegin_adr()+"");
                    mEnd.setText(base.getEnd_adr()+"");
                    break;
            }
            mTime.setText(base.getBegin_time()+"");
            if (base.getChildren_number()=="") {
                mChild.setText("0人");//小孩数
                mAdult.setText(base.getNumber()+"人");//成人数
            }else {

                int n = Integer.parseInt(base.getNumber());
                int c = Integer.parseInt(base.getChildren_number());
                mAdult.setText((n-c)+"人");//成人数
                mChild.setText(base.getChildren_number()+"人");//小孩数
            }
            mTotalAmount.setText("￥"+ listOrder.get(0).getPrice().getPay_price());
            mText1.setText(base.getNick_name());
            mText3.setText(base.getCreateTime());
            mText4.setText(base.getId());

            Logger.showMessage(base.getBegin_adr()+"-=-=-"+base.getEnd_adr()+"=-=-=-="+base.getNumber()+"人");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
        }
    }
}

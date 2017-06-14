package com.jh.rental.user.view.actitity.journey;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.payment_activity)
public class Payment_Activity extends TitelBarAcitvity {
    @ViewById(R.id.iv_ShutDown)
    ImageView mIvShutDown;
    @ViewById(R.id.iv_img1)
    ImageView mIvImg1;
    @ViewById(R.id.iv_img2)
    ImageView mIvImg2;
    @ViewById(R.id.ll_ShutDown)
    LinearLayout mLlShutDown;
    @ViewById(R.id.ll_click1)
    LinearLayout mLlClick1;
    @ViewById(R.id.ll_click2)
    LinearLayout mLlClick2;
    @ViewById(R.id.information)
    LinearLayout mInformation;
    @ViewById(R.id.cost)
    LinearLayout mCost;
    int flag1 = 0;
    int flag2 = 0;
    @AfterViews
    public void afterview(){
        setMyTitel(BaseContext.getResValue(R.string.myjoureny));
    }

    @Click({R.id.iv_ShutDown, R.id.ll_click1, R.id.ll_click2})
    void ClickOnTheJumpPage(View v) {
        switch (v.getId()) {
            case R.id.iv_ShutDown:
                mLlShutDown.setVisibility(View.GONE);
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
        }
    }
}

package com.jh.rental.user.view.actitity.person;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.Response;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.jason.CouponBean;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.person.CouponsAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.coupons_activity)
public class Coupons_Activity extends TitelBarAcitvity {
    @ViewById(R.id.lv_coupons)
    ListView lvCoupons;
    @ViewById(R.id.NotCoupons)
    RelativeLayout mNotCoupons;
    private int size = 20;
    private CouponBean couponBean;
    private Double counPrice;

    private void reqNet() {
        String url = ApiGet.queryCoupon + "?start=1&size=" + size;
        HttpVolley.getInstance().getRequestData(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Logger.soutTestMessage(response);
                CouponBean couponBeans = GsonUtlis.getJson(response, CouponBean.class);
                if (couponBeans==null||couponBeans.getList()==null){
                    return;
                }
                couponBean.setSize(couponBeans.getSize());
                couponBean.setList(couponBeans.getList());
                if (couponBean.getList().size() > 0) {
                    mNotCoupons.setVisibility(View.GONE);
                }
                couponsAdapter.notifyDataSetChanged();
            }
        });
    }

    private CouponsAdapter couponsAdapter;
    private boolean isTrun = true;

    @AfterViews
    public void afterview() {
        if (getIntent().getDoubleExtra("Coupons_Activity_", 0) > 0) {
            counPrice = getIntent().getDoubleExtra("Coupons_Activity_", 0);
            isTrun = false;
        }
        couponBean = new CouponBean();
        couponsAdapter = new CouponsAdapter(this, couponBean);

        if (ApiConstants.localCookie!=null){
            reqNet();
            lvCoupons.setAdapter(couponsAdapter);
            lvCoupons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    double value = Double.valueOf(couponBean.getList().get(position).getLimitMinMoney());
                    if (!isTrun && counPrice > value) {
                        ApiConstants.coupow = Double.valueOf(couponBean.getList().get(position).getMoney());
                        ApiConstants.limitUseMax = Double.valueOf(couponBean.getList().get(position).getLimitUseMax());
                        OrderDetails.getOrderDetails().setUserCouponId(couponBean.getList().get(position).getId());
                        onBackPressed();
                    }else {
                        SnakebarUtils.showToast("总金额未满使用要求。");
                    }
                }
            });
        }
        setMyTitel(BaseContext.getResValue(R.string.discountcoupon));
    }


}

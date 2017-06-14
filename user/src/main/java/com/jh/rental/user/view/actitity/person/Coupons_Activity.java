package com.jh.rental.user.view.actitity.person;

import android.widget.ListView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.person.CouponsAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.coupons_activity)
public class Coupons_Activity extends TitelBarAcitvity{
    @ViewById(R.id.lv_coupons)
    ListView lvCoupons;

    @AfterViews
    public void afterview(){
        lvCoupons.setAdapter(new CouponsAdapter(this));
        setMyTitel(BaseContext.getResValue(R.string.discountcoupon));
    }

}

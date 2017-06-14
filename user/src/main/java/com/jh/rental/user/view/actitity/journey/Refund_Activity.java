package com.jh.rental.user.view.actitity.journey;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.refund_activity)
public class Refund_Activity extends TitelBarAcitvity {

    @AfterViews
    public void afterview(){
        setMyTitel(BaseContext.getResValue(R.string.Refund));
    }

}

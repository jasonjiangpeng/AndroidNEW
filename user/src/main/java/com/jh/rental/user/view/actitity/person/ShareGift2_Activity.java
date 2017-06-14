package com.jh.rental.user.view.actitity.person;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.share_gift2_activity)
public class ShareGift2_Activity extends TitelBarAcitvity{


    @AfterViews
    public void afterview(){
        setMyTitel(BaseContext.getResValue(R.string.sharegift));
    }

}

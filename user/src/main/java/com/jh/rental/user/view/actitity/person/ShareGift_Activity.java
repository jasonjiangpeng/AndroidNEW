package com.jh.rental.user.view.actitity.person;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.share_gift_activity)
public class ShareGift_Activity extends TitelBarAcitvity{
    @ViewById(R.id.tv3)
    TextView mTv3;
    @ViewById(R.id.button)
    Button mButton;

    @AfterViews
    public void afterview(){
        setMyTitel(BaseContext.getResValue(R.string.sharegift));
    }
    @Click({R.id.tv3, R.id.button})
    void ClickOnTheJumpPage(View v) {
        switch (v.getId()) {
            case R.id.tv3:
                ActivityUtils.nextActivity(RewardRules_Activity_.class);
                break;
            case R.id.button:
                ActivityUtils.nextActivity(ShareGift2_Activity_.class);
                break;
        }
    }

}

package com.jh.rental.user.view.actitity.person;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.user.ShareCodePage;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.presenter.share.PopShareView;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.popview.PopwindowUtils;

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
    /*@ViewById(R.id.ImageView)
    ImageView imageView;
    @ViewById(R.id.tv1)
    TextView mTv1;
    @ViewById(R.id.tv2)
    TextView mTv2;*/
    @ViewById(R.id.button)
    Button mButton;
    @AfterViews
    public void afterview(){
//        reqNet();
        setMyTitel(BaseContext.getResValue(R.string.sharegift));

    }
   private void reqNet(){
        HttpVolley.getInstance().getRequestData(ApiGet.sendShare, new NetSucceed<>(ShareCodePage.class, new NetSucceed.HolderData<ShareCodePage>() {
            @Override
            public void holdData(ShareCodePage bean) {
               /* mTv1.setText(bean.getTitle());
                mTv2.setText(bean.getContent());
                PhotoUtils.isHasToImg(bean.getShareImg(), imageView);*/
            }
        }));
    }

    @Click({R.id.tv3, R.id.button})
    void ClickOnTheJumpPage(View v) {
        switch (v.getId()) {
            case R.id.tv3:
                ActivityUtils.nextActivity(RewardRules_Activity_.class);
       //         PopwindowUtils.getPopwindowUtils().show(new PopShareView(this),v,ShareGift_Activity.this);
                break;
            case R.id.button:
                PopwindowUtils.getPopwindowUtils().show(new PopShareView(this),v,ShareGift_Activity.this);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        PopwindowUtils.closePopWin();
        super.onDestroy();
    }
}

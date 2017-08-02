package com.jh.rental.user.view.actitity.person;

import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

import com.jh.rental.user.R;
import com.jh.rental.user.model.usermodel.HotCircuitUrlTpye;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.useragreement_activity)
public class UserAgreement_Activity extends TitelBarAcitvity{
    @ViewById(R.id.wv_agreement)
    WebView webView;
    @AfterViews
    public void afterview(){
        setMyTitel(BaseContext.getResValue(R.string.userporocpol));
        webView = (WebView) findViewById(R.id.wv_agreement);
        initView();
    }

    private void initView() {
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ((WebView) v).requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        new HotCircuitUrlTpye().reqNet(4, new HotCircuitUrlTpye.CallBackUrl() {
            @Override
            public void callBackurl(String url) {
                webView.loadUrl(url);
            }
        });
    }
}

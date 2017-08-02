package com.jh.rental.user;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.jh.rental.user.model.usermodel.HotCircuitUrlTpye;
import com.jh.rental.user.presenter.photo.PhotoUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.actitity.BaseActvity;
import com.jh.rental.user.view.fragment.home.DriverStoryFragment;
import com.jh.rental.user.view.fragment.home.HotDestinationsFragment;
import com.jh.rental.user.view.fragment.home.HotRouteFragment;
import com.jh.rental.user.view.fragment.home.UserVoiceFragment;
import com.jh.rental.user.view.widget.jason.HomeTextFour;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;


import java.util.List;


/**
 * Created by 骏辉出行 on 2017/5/18.
 */
public class TestActivity extends BaseActvity {
private WebView  webView;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_activity);
        webView= (WebView) findViewById(R.id.wv_agreement);
        initView();
       // initScenHodler();
    }
    private void initView() {
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ((WebView) v).requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        new HotCircuitUrlTpye().reqNet(2, new HotCircuitUrlTpye.CallBackUrl() {
            @Override
            public void callBackurl(String url) {
                Logger.newTestMessage(url);
                webView.loadUrl(url);
            }
        });
    }
    private class TestNormalAdapter extends StaticPagerAdapter {

        private List<String> stringList;
        public TestNormalAdapter(List<String>  stringList) {
            Logger.newTestMessage(stringList.size());
            this.stringList=stringList;

        }
        @Override
        public View getView(ViewGroup container, final int position) {
            View  view = LayoutInflater.from(container.getContext()).inflate(R.layout.sub_item_simpleimage2,container,false);
            ImageView imgTv10 = (ImageView) view.findViewById(R.id.imgTv10);
            PhotoUtils.isHasToImg(stringList.get(position),imgTv10);
            return view;
        }
        @Override
        public int getCount() {
            return stringList.size();
        }
    }

        private HomeTextFour secenText;
        private RollPagerView rollPagerView;
        public void  initScenHodler() {
            secenText= (HomeTextFour) findViewById(R.id.secenText);
            rollPagerView= (RollPagerView) findViewById(R.id.roll_view_pager);
         //   rollPagerView.setPlayDelay(3000);
            //设置透明度
     //       rollPagerView.setAnimationDurtion(500);
         //   rollPagerView.setAdapter(new TestNormalAdapter(null));
            swithFrament(new HotDestinationsFragment());
            secenText.setTextChooseCallBack(new HomeTextFour.TextChooseCallBack() {
                @Override
                public void textchoosecallback(int position) {
                    switch (position){
                        case 0:
                            swithFrament(new HotDestinationsFragment());
                            break;
                        case 1:
                            swithFrament(new HotRouteFragment());
                            break;
                        case 2:
                            swithFrament(new DriverStoryFragment());
                            break;
                        case 3:
                            swithFrament(new UserVoiceFragment());
                            break;
                    }
                }
            });

    }
    private void swithFrament(Fragment  fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.myfrg,fragment);
        transaction.commit();
    }

}

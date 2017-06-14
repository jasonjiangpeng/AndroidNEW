package com.jh.rental.user;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.BaseActvity;
import com.jh.rental.user.view.factory.FragmentFactory;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;





@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActvity{
    @ViewById(R.id.bottom_bar)
    BottomBar mBottomBar;
    FragmentTransaction fragmentTransaction;
    FragmentManager  mSupportFragmentManager;
    Handler  handler =new Handler(Looper.myLooper()){
      @Override
      public void handleMessage(Message msg) {
               mBottomBar.setOnTabSelectListener(   new OnTabSelectListener(){
              @Override
              public void onTabSelected(@IdRes int tabId) {
                  fragmentTransaction = mSupportFragmentManager.beginTransaction();
                  fragmentTransaction.replace(R.id.fragment_container, FragmentFactory.getInstance().getFragment(tabId));
                  fragmentTransaction.commit();
              }
          });
      }
  };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @AfterViews
    public void init() {
        mSupportFragmentManager=getSupportFragmentManager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentswitch();
    }

    @UiThread(delay = 500)
    public void  upUi(){
        fragmentswitchs();
    }
    public void fragmentswitch(){
              handler.sendEmptyMessage(0);
    }
    public void fragmentswitchs(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        FragmentFactory.getInstance().setIsupdata(true);
        fragmentTransaction.replace(R.id.fragment_container, FragmentFactory.getInstance().getFragment(FragmentFactory.getInstance().getTabid()));
        fragmentTransaction.commit();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
       BaseApplication.exit();
    }
}
package com.jh.rental.user.view.actitity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;
import com.jh.rental.user.model.receive.PickupData;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 骏辉出行 on 2017/5/12.
 */

public class BaseActvity extends AutoLayoutActivity implements PickupData {
 public     PickupData pickupData=this;
    public Object  myobject;
public Handler  handler=new Handler(Looper.getMainLooper()){
    @Override
    public void handleMessage(Message msg) {
         handleManage(msg.what);
    }

};
public void handleManage(int value){

}

    public Object getMyobject() {
        return myobject;
    }

    public void setMyobject(Object myobject) {
        this.myobject = myobject;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
        Logger.soutMessage(this.getClass().getName());

        new Thread(){
            @Override
            public void run() {
                initParameter();

                pickupData.sendRequestData();

            }
        }.start();
        BaseApplication.addActivity(this);
    }
    /*初始化参数*/
   public void initParameter(){

   }
    @Override
    protected void onResume() {
        super.onResume();
        Logger.soutMessage("目前activities数量"+BaseApplication.activities.size()+"==");
        System.gc();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    protected void onStart() {
        if (PopwindowUtils.getPopwindowUtils().getPopupWindow()!=null&&PopwindowUtils.getPopwindowUtils().getPopupWindow().isShowing()){
            PopwindowUtils.getPopwindowUtils().getPopupWindow().dismiss();
        }
        super.onStart();
    }

    @Override
    protected void onDestroy() {
      /*  if (PopwindowUtils.getPopwindowUtils().getPopupWindow()!=null&&PopwindowUtils.getPopwindowUtils().getPopupWindow().isShowing()){
            PopwindowUtils.getPopwindowUtils().getPopupWindow().dismiss();
        }*/
        Logger.soutMessage("onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
       if (PopwindowUtils.getPopwindowUtils().getPopupWindow()!=null&&PopwindowUtils.getPopwindowUtils().getPopupWindow().isShowing()){
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void exit(){
        BaseApplication.exit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        BaseApplication.finishActivity();
    }
/*主要用途网络请求数据*/
    public  Map<String ,String> getBaseMap(String[] strings,String... ab){

        if (ab.length<1&&strings.length!=ab.length){
            return null;
        }
        Map<String ,String> baseMap =new HashMap<>();
        for (int i = 0; i <strings.length ; i++) {
            baseMap.put(strings[i],ab[i]);
        }
             return baseMap;
    }

    @Override
    public void getAreaAddressList(GetAreaAddressList GetAreaAddressList) {

    }
/*w网络请求*/
    @Override
    public void sendRequestData() {
    }
    public Map<String,String> getMap(String[] key,String[] value){
         if (key.length!=value.length||key==null||value==null){
             return null;
         }
        Map<String,String>  map=new HashMap<>();
        for (int i = 0; i <value.length ; i++) {
              map.put(key[i],value[i]);
        }
        return map;
}
/*返回linked数据*/
    public LinkedHashMap<String,String > getLinkdHashHap(String[] efg,String...abc){
        LinkedHashMap<String,String > linkedHashMap=new LinkedHashMap<>();
        for (int i = 0; i <efg.length ; i++) {
            linkedHashMap.put(efg[i],abc[i]);
        }

        return linkedHashMap;
    }
}

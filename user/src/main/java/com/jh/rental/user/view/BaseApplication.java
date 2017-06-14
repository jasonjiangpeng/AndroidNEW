package com.jh.rental.user.view;

import android.app.Activity;
import android.app.Application;

import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.utils.jason.BaseContext;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.Stack;



/**
 * Created by 骏辉出行 on 2017/5/12.
 */

public class BaseApplication extends Application {
  public static   Stack<Activity>  activities=null;
    @Override
    public void onCreate() {
        super.onCreate();
        if (activities==null){
               activities=new Stack<Activity>();
        }
        if (BaseContext.context==null){
            BaseContext.context=BaseApplication.this.getApplicationContext();
        }
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
    public  static void finishActivity(){
           activities.pop().finish();
    }

    public  static void addActivity(Activity context){
                if (activities==null){
                    activities=new Stack<>();
                }
                activities.push(context);
    }
    public static Activity currentActivity(){

                return activities.lastElement();
    }
    public  static void exit(){
        HttpVolley.getInstance().cancelPendingRequests();
        if (activities==null){
            return;
        }
        for (int i = 0; i <activities.size() ; i++) {
             activities.get(i).finish();
        }
        activities=null;
        System.exit(0);
    }
    public static void getMainActivity(){
        if (activities==null){
            return;
        }
        for (int i = activities.size()-1; i>0 ; i--) {
            activities.pop().finish();
        }
    }

}

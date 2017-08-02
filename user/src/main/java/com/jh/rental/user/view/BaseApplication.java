package com.jh.rental.user.view;

import android.app.Activity;
import android.app.Application;

import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.ShareCirle;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.huanxin.HxChat;
import com.jh.rental.user.presenter.qiniu.QnUpDown;
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
            HxChat.initContext(BaseContext.context);
            QnUpDown.init();
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
    public static synchronized Activity currentActivity(){

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
      OrderDetails.destroy();
        PickupDetails.destroy();
        System.exit(0);
    }
    public static void getMainActivity(){
        if (activities==null){
            return;
        }
        for (int i = activities.size()-1; i>1 ; i--) {
            activities.pop().finish();
        }
    }
    public static void getLoginActivity(){
        if (activities==null){
            return;
        }
        for (int i = activities.size()-1; i>0 ; i--) {
            if (!activities.lastElement().getClass().getName().equals("com.jh.rental.user.MainActivity")){
                activities.pop().finish();
            }else {
                activities.lastElement();
                break;
            }

        }


    }

}

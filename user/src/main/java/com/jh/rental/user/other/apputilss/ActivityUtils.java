package com.jh.rental.user.other.apputilss;

import android.app.Activity;
import android.content.Intent;



/**
 * Created by LostJason on 2017/4/11.
 */

public class ActivityUtils {
    public static void nextActivity(Activity activity,Class c){
        Intent intent =new Intent(activity,c);
        activity.startActivity(intent);
    }
    public static void nextActivity(Class c){
        Intent intent =new Intent(My_ActivityManager.getCurrentAcitvity(),c);
        My_ActivityManager.getCurrentAcitvity().startActivity(intent);
    }
    public static void nextActivity(Class c,String data){
        Intent intent =new Intent(My_ActivityManager.getCurrentAcitvity(),c);
        intent.putExtra("data",data);
        My_ActivityManager.getCurrentAcitvity().startActivity(intent);
    }
    public static void nextActivity(Class c,int data){
        Intent intent =new Intent(My_ActivityManager.getCurrentAcitvity(),c);
        intent.putExtra("device_boot",data);
        My_ActivityManager.getCurrentAcitvity().startActivity(intent);
    }
}

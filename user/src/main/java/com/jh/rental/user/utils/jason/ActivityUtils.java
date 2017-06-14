package com.jh.rental.user.utils.jason;

import android.app.Activity;
import android.content.Intent;

import com.jh.rental.user.view.BaseApplication;

import java.io.Serializable;


/**
 * Created by LostJason on 2017/4/11.
 */

public class ActivityUtils {
    public static void nextActivity(Class c){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        BaseApplication.currentActivity().startActivity(intent);
    }
    public static void nextActivity(Class c, String keyname, Serializable serializable){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        intent.putExtra(keyname,serializable);
        BaseApplication.currentActivity().startActivity(intent);
    }
    public static void nextActivity( Class c,String name,String value){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        intent.putExtra(name,value);
        BaseApplication.currentActivity().startActivity(intent);
    }
    public static void nextActivity(Class c,String name,int value){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        intent.putExtra(name,value);
        BaseApplication.currentActivity().startActivity(intent);
    }

}

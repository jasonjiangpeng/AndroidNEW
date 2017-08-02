package com.jh.rental.user.utils.jason;

import android.content.Intent;
import android.os.Parcelable;

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
    public static void nextActivity(Class c, Parcelable value,String name){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        intent.putExtra(name,value);
        BaseApplication.currentActivity().startActivity(intent);
    }
    public static void nextActivity(Class c,String keyname, Serializable serializable){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        intent.putExtra(keyname,serializable);
        BaseApplication.currentActivity().startActivity(intent);
    }
    public static void nextActivity( Class c,String name,String value){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        intent.putExtra(name,value);
        BaseApplication.currentActivity().startActivity(intent);
    }
    public static void nextActivity( Class c,String name,String value,String name2,String value2){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        intent.putExtra(name,value);
        intent.putExtra(name2,value2);
        BaseApplication.currentActivity().startActivity(intent);
    }
    public static void nextActivity(Class c,String name,int value){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        intent.putExtra(name,value);
        BaseApplication.currentActivity().startActivity(intent);
    }
    public static void nextActivity(Class c,String name,int value,String name2,int value2){
        Intent intent =new Intent(BaseApplication.currentActivity(),c);
        intent.putExtra(name,value);
        intent.putExtra(name2,value2);
        BaseApplication.currentActivity().startActivity(intent);
    }
}

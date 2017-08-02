package com.jh.rental.user.utils.jason;

import android.content.Context;
import android.os.Build;
import android.view.Window;

/**
 * Created by 骏辉出行 on 2017/5/12.
 */

public class BaseContext {
    public static Context context=null;

    public  static String  getResValue(int id){
        if (context==null){
            return "Error";
        }
      return  context.getResources().getString(id);
    }
    public  static int  getResIntValue(int id){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return  context.getResources().getColor(id);
        }
        return  context.getResources().getColor(id,null);
    }
    public  static String[]  getResArraysValue(int id){
        return  context.getResources().getStringArray(id);
    }

}

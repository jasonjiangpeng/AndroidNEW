package com.jh.rental.user.utils.jason;

import android.util.Log;

/**
 * Created by 骏辉出行 on 2017/5/12.
 */

public class Logger {
    public static boolean isdug=true;
    public static String dugTag="outData:";
    public static void showMessage(String message){
        if (isdug){
            Log.v(dugTag,message);
        }
    }
    public static void showMessage(int message){
        if (isdug){
            Log.v(dugTag,message+"");
        }
    }
    public static void soutMessage(Object message){
        System.out.println("messageOut=========:"+message);
    }
    public static void netSoutMessage(Object message){
        System.out.println("netSoutMessage=========:"+message);
    }
}

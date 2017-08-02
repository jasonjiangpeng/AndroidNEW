package com.jh.rental.user.utils.jason;

import android.util.Log;

import com.jh.rental.user.view.BaseApplication;

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
        if (isdug){
            if (BaseApplication.activities.size()>0){
                System.out.println("messageOut=========:"+ BaseApplication.currentActivity().getClass().getName()+":::"+message);
            }
        }


    }
    public static void netSoutMessage(Object message){
        if (isdug){
            System.out.println("netSoutMessage=========:"+ BaseApplication.currentActivity().getClass().getName()+":::"+message);
        }

    }
    public static void soutTestMessage(Object message){
        if (isdug){
            System.out.println("soutTestMessage=========:"+ BaseApplication.currentActivity().getClass().getName()+":::"+message);
        }

    }
    public static void newTestMessage(Object message){
        if (isdug){
            System.out.println("newTestMessage=========:"+ BaseApplication.currentActivity().getClass().getName()+":::"+message);
        }

    }

}

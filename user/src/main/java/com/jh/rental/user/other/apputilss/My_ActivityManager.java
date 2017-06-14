package com.jh.rental.user.other.apputilss;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by LostJason on 2017/4/11.
 */

public class My_ActivityManager {
  public  static   Stack<Activity>  activities =new Stack<>();

    public static void exit(){
        try {
            for (int i = 0; i <activities.size() ; i++) {
                activities.pop().finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
    public static Activity getCurrentAcitvity(){

        return activities.peek();
    }

}

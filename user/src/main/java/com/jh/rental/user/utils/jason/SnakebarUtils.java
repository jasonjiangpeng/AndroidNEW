package com.jh.rental.user.utils.jason;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.jh.rental.user.view.BaseApplication;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class SnakebarUtils {
    private static boolean isdug=true;
    public static void show(View view,String message){
        if (isdug){
            if (view==null){
                view = BaseApplication.currentActivity().getWindow().getDecorView();
            }
            Snackbar.make(view,message,Snackbar.LENGTH_SHORT).show();
        }

    }
    public static void showView(String message){
        View    view = BaseApplication.currentActivity().getWindow().getDecorView();
        if (isdug){
                    Snackbar.make(view,message,Snackbar.LENGTH_SHORT).show();
        }

    }
    public static void show(String message){
        if (isdug){
            show(null,message);
        }
    }

    public static void showToast(String message){
//        if (isdug){
        Toast  toast=    Toast.makeText(BaseApplication.currentActivity(),message,Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);

            toast.show();
//        }

    }
    public static void showToast(String message, Context context){
        if (isdug){
             Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }

    }
}

package com.jh.rental.user.utils.jason;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class SnakebarUtils {
    public static void show(View view,String message){
        Snackbar.make(view,message,Snackbar.LENGTH_SHORT).show();
    }

    public static void showToast(String message){
        Toast.makeText(BaseContext.context,message,Toast.LENGTH_SHORT).show();
    }
}

package com.jh.rental.user.other.apputilss;

/**
 * Created by LostJason on 2017/4/19.
 */

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class InputMethodUtils {
    public InputMethodUtils() {

    }

    public static void showInputMethod(View view) {
        InputMethodManager imm = (InputMethodManager)view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null) {
            imm.showSoftInput(view, 1);
        }

    }

    public static void showInputMethod(Context context) {  //输入法 开关
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, 2);
    }

    public static void showInputMethod(final View view, long delayMillis) {   //输入法延迟开关
        if(view != null) {
            view.postDelayed(new Runnable() {
                public void run() {
                    InputMethodUtils.showInputMethod(view);
                }
            }, delayMillis);
        }
    }
}
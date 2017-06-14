package com.jh.rental.user.view.popview;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.jh.rental.user.utils.jason.Logger;

/**
 * Created by 骏辉出行 on 2017/5/27.
 */

public class PopwindowUtils {
    private    PopupWindow  popupWindow;
    private  static PopwindowUtils popwindowUtils;

    private PopwindowUtils() {
        if (popupWindow==null){
            popupWindow=new PopupWindow();
        }
    }
    public static PopwindowUtils getPopwindowUtils(){
        if (popwindowUtils==null){
            popwindowUtils=new PopwindowUtils();
        }
        return popwindowUtils;
    }

    private PopwindowUtils setPopupWindow(final View view, final Activity activity){
        popupWindow.setContentView(view);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
              setBackgroundAlpha(activity,1);
            }
        });
        return this;
    }
     public PopwindowUtils show(View view,View position,Activity a){
         if (popupWindow.isShowing()){
             Logger.soutMessage("================");
             popupWindow.dismiss();
         }
        setPopupWindow(view,a);
        setBackgroundAlpha(a,0.5f);
        popupWindow.showAtLocation(position, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
        return this;
    }
    public PopupWindow getPopupWindow(){
        if (popupWindow==null){
            return null;
        }
        return popupWindow;
    }
    public  PopwindowUtils setBackgroundAlpha(Activity activity, float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        if (bgAlpha == 1) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//不移除该Flag的话,在有视频的页面上的视频会出现黑屏的bug
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//此行代码主要是解决在华为手机上半透明效果无效的bug
        }
        activity.getWindow().setAttributes(lp);

        return this;
    }
}

package com.jh.rental.user.other.apputilss.dialog;/*
package com.aotome202.lostjason.x103aotom.apputilss.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ShowDialog {
    public  static void showDiglog(Context context,String message,DialogInterface.OnClickListener onClickListener){
        final AlertDialog.Builder  builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setNegativeButton("确定",onClickListener);
        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
            }
        });
        builder.show();

    }
  public  static    PopupWindow popupWindow;
    public static     PopupWindow getpopupWindow(Context context,  View.OnClickListener v){
         if (popupWindow==null){
             showPoPwindow(context,v);
         }
        if (popupWindow.isShowing()){
            popupWindow.dismiss();
        }
         return popupWindow;
    }
    public static void closepopupWindow(){
        if (popupWindow==null){
            return;
        }

        popupWindow.dismiss();
    }
    public static void showPoPwindow(Context context,  View.OnClickListener v){
         popupWindow =new PopupWindow(context);
         View  view1 =LayoutInflater.from(context).inflate(R.layout.popview_device,null);
        TextView  reset_action= (TextView) view1.findViewById(R.id.reset_action);
        TextView  colse_action= (TextView) view1.findViewById(R.id.colse_action);
        TextView  cancel_action= (TextView) view1.findViewById(R.id.cancel_action);
        reset_action.setTag("reset");
        colse_action.setTag("close");
        cancel_action.setTag("cancel");
         reset_action.setOnClickListener(v);
        colse_action.setOnClickListener(v);
        cancel_action.setOnClickListener(v);

  */
/*      view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height=v.findViewById(R.id.text).getTop();
                Logshow.logShow(height+"popupWindowheight");
                int y = (int) event.getY();
                Logshow.logShow(height+"popupWindowheightYYYYYYYY");
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                }
                return true;

            }
        });*//*

        popupWindow.setContentView(view1);

        popupWindow.setWidth(FrameLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(FrameLayout.LayoutParams.WRAP_CONTENT);
    */
/*    popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(false);*//*

        ColorDrawable dw = new ColorDrawable(0xb0000000);
    //    popupWindow.
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               // Logshow.logShow(event.getY()+"popupWindowheightYYYYYYYY");
                return false;
            }
        });


     //   popupWindow.showAtLocation(view, Gravity.BOTTOM,0,0);
    }
}
*/

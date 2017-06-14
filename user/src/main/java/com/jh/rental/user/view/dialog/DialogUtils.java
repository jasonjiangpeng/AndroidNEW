package com.jh.rental.user.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jh.rental.user.R;

/**
 * Created by 骏辉出行 on 2017/5/19.
 */

public class DialogUtils {
  public static   AlertDialog alertDialog;
    public static AlertDialog createShowCardDialog(Context context){
        AlertDialog.Builder  builder =new AlertDialog.Builder(context);
        builder.setView(R.layout.sub_dialog_showcard);
        alertDialog = builder.create();
        return alertDialog;
    }
    public static AlertDialog createShowPayFailDialog(Context context){
        AlertDialog.Builder  builder =new AlertDialog.Builder(context);
        builder.setView(R.layout.sub_dialog_payfail);
        alertDialog = builder.create();
        return alertDialog;
    }
    public static AlertDialog createShowReminderDialog(Context context,String m1,String m2,String m3,String m4){
        AlertDialog.Builder  builder =new AlertDialog.Builder(context);
        View view= LayoutInflater.from(context).inflate(R.layout.sub_dialog_reminder,null);
        TextView  tv1= (TextView) view.findViewById(R.id.reminder1);
        TextView  tv2= (TextView) view.findViewById(R.id.reminder2);
        TextView  tv3= (TextView) view.findViewById(R.id.reminder3);
        TextView  tv4= (TextView) view.findViewById(R.id.reminder4);
        tv1.setText(m1);
        tv2.setText(m2);
        tv3.setText(m3);
        tv4.setText(m4);
        builder.setView(view);
        alertDialog = builder.create();
        return alertDialog;
    }
    public static AlertDialog showMessage(Context context,String message){
        AlertDialog.Builder  builder =new AlertDialog.Builder(context);
        builder.setMessage(message);
        alertDialog = builder.create();
        return alertDialog;
    }
    public static AlertDialog getInstance(Context context){
        if (alertDialog==null){
            return showMessage(context,"No Message");
        }
        return alertDialog;
    }
    public static AlertDialog showPermissonSet(Context context){
        if (alertDialog==null){
            return showMessage(context,"No Message");
        }

        return alertDialog;
    }

}

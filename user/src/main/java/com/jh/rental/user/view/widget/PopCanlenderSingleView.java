package com.jh.rental.user.view.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;

import com.jh.rental.user.view.popview.PopwindowUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class PopCanlenderSingleView extends LinearLayout implements View.OnClickListener {
   private CallBackData callBackData;
    Context mContext;
    public PopCanlenderSingleView(Context context) {
        this(context, null);
    }

    public PopCanlenderSingleView(Context context, AttributeSet attrs ) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public CallBackData getCallBackData() {
        return callBackData;
    }

    public void setCallBackData(CallBackData callBackData) {
        this.callBackData = callBackData;
    }

    private CalendarView calendarView;

    private String value=null;
    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_singlecanlender, this);
        calendarView= (CalendarView) inflate.findViewById(R.id.pop_singlecanlender);
        TextView     textView= (TextView) inflate.findViewById(R.id.cancel_btn);
        TextView     pop_cancel= (TextView) inflate.findViewById(R.id.sure_btn);
        TextView   poptvs = (TextView) inflate.findViewById(R.id.poptvs);
        poptvs.setText("请选择出发日期");
        textView.setOnClickListener(this);
        pop_cancel.setOnClickListener(this);
        calendarView.setMinDate(System.currentTimeMillis());
        long date = calendarView.getDate();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
               value=year+"-"+(month+1)+"-"+dayOfMonth;
            }
        });
    }

    public String getValue() {
        if (value==null){
            value=getCurrdate(calendarView.getDate());
        }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrdate(long time){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date(time);
        String format = simpleDateFormat.format(date);
        return format;
    }

    @Override
    public void onClick(View v) {
          switch (v.getId()){
              case R.id.cancel_btn:
                  PopwindowUtils.closePopWin();
                  break;
              case R.id.sure_btn:
                  PopwindowUtils.closePopWin();
                  callBackData.callbackData(getValue(),v);
                  break;
          }
    }
    public interface  CallBackData{
        void callbackData(String value,View view);
    }

    private  boolean isCallback=true;

    public boolean isCallback() {
        return isCallback;
    }

    public void setCallback(boolean callback) {
        isCallback = callback;
    }
}

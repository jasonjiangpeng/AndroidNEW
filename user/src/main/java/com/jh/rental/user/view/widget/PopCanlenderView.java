package com.jh.rental.user.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.calendarview.CalendarUtils;
import com.jh.rental.user.view.calendarview.DatePickerController;
import com.jh.rental.user.view.calendarview.DayPickerView;
import com.jh.rental.user.view.calendarview.SimpleMonthAdapter;
import com.jh.rental.user.view.fragment.home.HotRouteFragment;
import com.jh.rental.user.view.popview.PopwindowUtils;


import java.util.Calendar;
import java.util.List;
import static com.jh.rental.user.utils.jason.BaseContext.context;


public class PopCanlenderView extends LinearLayout implements View.OnClickListener {

    public PopCanlenderView(Context context) {
        this(context, null);
    }
    public PopCanlenderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private  boolean isChoose=false;
  private   DayPickerView dayPickerView;
    private String startdate;
    private String enddate;

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_canlenderview, this);
        TextView  cancel_btn = (TextView) inflate.findViewById(R.id.cancel_btn);
        TextView  sure_btn = (TextView) inflate.findViewById(R.id.sure_btn);
        TextView   poptvs = (TextView) inflate.findViewById(R.id.poptvs);
        poptvs.setText("请选择出发日期");
        cancel_btn.setOnClickListener(this);
        sure_btn.setOnClickListener(this);
        dayPickerView = (DayPickerView) inflate.findViewById(R.id.pickerView);
        DayPickerView.DataModel dataModel = new DayPickerView.DataModel();
        dataModel.yearStart = Calendar.getInstance().get(Calendar.YEAR);
        dataModel.monthStart =  Calendar.getInstance().get(Calendar.MONTH);
        dataModel.monthCount = 4;
        dataModel.defTag = "";
      //  dataModel.leastDaysNum = 1;
        dataModel.mostDaysNum = 30;

        dayPickerView.setParameter(dataModel, new DatePickerController() {
            @Override
            public void onDayOfMonthSelected(SimpleMonthAdapter.CalendarDay calendarDay) {
                    isChoose=false;
            String    value = String.format("%d/%d/%d", calendarDay.year, calendarDay.month+1, calendarDay.day);
                if (startdate==null){
                    startdate=value;
                }else if (startdate.equals(value)){
                    enddate=value;
                    isChoose=true;
                }
            }
            @Override
            public void onDateRangeSelected(List<SimpleMonthAdapter.CalendarDay> selectedDays) {
                    if (selectedDays.size()>1){
                        SimpleMonthAdapter.CalendarDay calendarDay = selectedDays.get(0);
                        SimpleMonthAdapter.CalendarDay endcalendarDay = selectedDays.get(selectedDays.size()-1);
                        ApiConstants.Day =selectedDays.size();
                        startdate = String.format("%d/%d/%d", calendarDay.year, calendarDay.month+1, calendarDay.day);
                        enddate = String.format("%d/%d/%d", endcalendarDay.year, endcalendarDay.month+1, endcalendarDay.day);
                        isChoose=true;
                    }
            }
            @Override
            public void alertSelectedFail(FailEven even) {
            Logger.soutMessage(even+"eveneveneveneven");
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.cancel_btn:
                PopwindowUtils.closePopWin();
                break;
            case  R.id.sure_btn:
                if (startdate.equals(enddate)){
                    ApiConstants.Day =1;
                }

                    if (isNull()&&callBack!=null){
                        callBack.callback(startdate,enddate);
                    }
                break;

        }
    }

    public CallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    CallBack  callBack;
    public boolean  isNull(){
        if (startdate==null||enddate==null){
            return false;
        }
      if (    TextUtils.isEmpty(startdate)||TextUtils.isEmpty(startdate)){
          return false;
      }
      return true;
    }
  public   interface CallBack{
          void callback(String start,String end);
    }
}

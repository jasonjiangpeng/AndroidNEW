package com.jh.rental.user.view.actitity.internationnal;

import android.widget.Toast;

import com.jh.rental.user.R;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.calendarview.DatePickerController;
import com.jh.rental.user.view.calendarview.DayPickerView;
import com.jh.rental.user.view.calendarview.SimpleMonthAdapter;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/22.
 */
@EActivity(R.layout.calender_activity)
public class CalendarActivity extends TitelBarAcitvity {
    DayPickerView  dayPickerView;
  @AfterViews
    public void init(){
      dayPickerView= (DayPickerView) findViewById(R.id.pickerView);
     setMyTitel("我是撒旦");
      DayPickerView.DataModel dataModel = new DayPickerView.DataModel();
      dataModel.yearStart = 2017;
      dataModel.monthStart = 6;
      dataModel.monthCount = 16;
     // dataModel.defTag = "￥100";
      dataModel.defTag = "";
      dataModel.leastDaysNum = 2;
      dataModel.mostDaysNum = 100;

      List<SimpleMonthAdapter.CalendarDay> invalidDays = new ArrayList<>();
      SimpleMonthAdapter.CalendarDay invalidDay1 = new SimpleMonthAdapter.CalendarDay(2016, 8, 10);
      SimpleMonthAdapter.CalendarDay invalidDay2 = new SimpleMonthAdapter.CalendarDay(2016, 8, 11);
      SimpleMonthAdapter.CalendarDay invalidDay3 = new SimpleMonthAdapter.CalendarDay(2016, 8, 12);
      invalidDays.add(invalidDay1);
      invalidDays.add(invalidDay2);
      invalidDays.add(invalidDay3);
      dataModel.invalidDays = invalidDays;

      List<SimpleMonthAdapter.CalendarDay> busyDays = new ArrayList<>();
      SimpleMonthAdapter.CalendarDay busyDay1 = new SimpleMonthAdapter.CalendarDay(2016, 8, 20);
      SimpleMonthAdapter.CalendarDay busyDay2 = new SimpleMonthAdapter.CalendarDay(2016, 8, 21);
      SimpleMonthAdapter.CalendarDay busyDay3 = new SimpleMonthAdapter.CalendarDay(2016, 8, 22);
      busyDays.add(busyDay1);
      busyDays.add(busyDay2);
      busyDays.add(busyDay3);
      dataModel.busyDays = busyDays;

//        SimpleMonthAdapter.CalendarDay startDay = new SimpleMonthAdapter.CalendarDay(2016, 6, 5);
//        SimpleMonthAdapter.CalendarDay endDay = new SimpleMonthAdapter.CalendarDay(2016, 6, 20);
//        SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays = new SimpleMonthAdapter.SelectedDays<>(startDay, endDay);
//        dataModel.selectedDays = selectedDays;

      SimpleMonthAdapter.CalendarDay tag = new SimpleMonthAdapter.CalendarDay(2016, 7, 15);
      tag.setTag("标签1");

      SimpleMonthAdapter.CalendarDay tag2 = new SimpleMonthAdapter.CalendarDay(2016, 8, 15);
      tag2.setTag("标签2");
      List<SimpleMonthAdapter.CalendarDay> tags = new ArrayList<>();
      tags.add(tag);
      tags.add(tag2);
      dataModel.tags = tags;

      dayPickerView.setParameter(dataModel, new DatePickerController() {
          @Override
          public void onDayOfMonthSelected(SimpleMonthAdapter.CalendarDay calendarDay) {
              Toast.makeText(CalendarActivity.this, "onDayOfMonthSelected", Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onDateRangeSelected(List<SimpleMonthAdapter.CalendarDay> selectedDays) {
              Toast.makeText(CalendarActivity.this, "onDateRangeSelected", Toast.LENGTH_SHORT).show();
          }

          @Override
          public void alertSelectedFail(FailEven even) {
              Toast.makeText(CalendarActivity.this, "alertSelectedFail", Toast.LENGTH_SHORT).show();
          }
      });
  }




}

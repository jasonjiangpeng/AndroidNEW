package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jh.rental.user.R;
import com.jh.rental.user.view.calendarview.DatePickerController;
import com.jh.rental.user.view.calendarview.DayPickerView;
import com.jh.rental.user.view.calendarview.SimpleMonthAdapter;
import com.jh.rental.user.view.popview.PopwindowUtils;
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
    DayPickerView dayPickerView;
    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_canlenderview, this);
        TextView  cancel_btn = (TextView) inflate.findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(this);
        dayPickerView = (DayPickerView) inflate.findViewById(R.id.pickerView);
        DayPickerView.DataModel dataModel = new DayPickerView.DataModel();
        dataModel.yearStart = 2017;
        dataModel.monthStart = 6;
        dataModel.monthCount = 16;
        dataModel.defTag = "";
        dataModel.leastDaysNum = 2;
        dataModel.mostDaysNum = 30;

        dayPickerView.setParameter(dataModel, new DatePickerController() {
            @Override
            public void onDayOfMonthSelected(SimpleMonthAdapter.CalendarDay calendarDay) {
                Toast.makeText(context, "onDayOfMonthSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateRangeSelected(List<SimpleMonthAdapter.CalendarDay> selectedDays) {
                Toast.makeText(context, "onDateRangeSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void alertSelectedFail(FailEven even) {
                Toast.makeText(context, "alertSelectedFail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.cancel_btn:
                PopwindowUtils.getPopwindowUtils().getPopupWindow().dismiss();
                break;
        }
    }
}

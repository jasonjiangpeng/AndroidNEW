package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.popview.PopwindowUtils;

import com.jh.rental.user.view.widget.pickdate.PickViewSingle;

import java.util.ArrayList;
import java.util.List;


public class PopJourneyCounterView extends LinearLayout implements View.OnClickListener {
    public PopJourneyCounterView(Context context) {
        this(context, null);
    }

    public PopJourneyCounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
          init();
    }

    private TextView poptvs;

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_joureycouter, this);
        TextView cancel_btn = (TextView) inflate.findViewById(R.id.cancel_btn);
        TextView sure_btn = (TextView) inflate.findViewById(R.id.sure_btn);
        cancel_btn.setOnClickListener(this);
        sure_btn.setOnClickListener(this);
        pickViewm1 = (PickViewSingle) inflate.findViewById(R.id.pickview1);
        pickViewm2 = (PickViewSingle) inflate.findViewById(R.id.pickview2);
        pickViewm1.startUi(initList(1,12));
        pickViewm2.startUi(initList(0,7));
        poptvs = (TextView) inflate.findViewById(R.id.poptvs);
        poptvs.setText("请选择出行人数");
    }

    private PickViewSingle pickViewm1, pickViewm2;
  //  private int countr = 8;

    private List<Integer> initList(int start,int end) {
        List list1 = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list1.add(i);
        }
        return list1;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel_btn:
                PopwindowUtils.getPopwindowUtils().getPopupWindow().dismiss();
                break;
            case R.id.sure_btn:
                if (pickViewm1.getCounts()>pickViewm2.getCounts()){
                    PopwindowUtils.closePopWin();
                    if (popTime != null) {
                        popTime.next(pickViewm1.getCounts(), pickViewm2.getCounts());
                    }
                }else if (pickViewm2.getCounts()==pickViewm1.getCounts()){
                    SnakebarUtils.showToast("出行总人数不能全部是小孩");
                }else {
                    SnakebarUtils.showToast("小孩数不能大于出行总人数");
                }

                break;
        }
    }

    public void setTipa(PopTime popTime) {
        this.popTime = popTime;
    }

    private PopTime popTime;

    public interface PopTime {
        void next(int man, int child);
    }

}

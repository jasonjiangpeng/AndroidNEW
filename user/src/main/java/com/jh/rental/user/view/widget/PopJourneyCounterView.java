package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.pickdate.PickViewSingle;
import com.jh.rental.user.view.widget.pickdate.PickViewm;

import java.util.ArrayList;
import java.util.List;


public class PopJourneyCounterView extends LinearLayout implements View.OnClickListener {

    public PopJourneyCounterView(Context context) {
        this(context, null);
    }

    public PopJourneyCounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initList();
        init();
    }
    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_joureycouter, this);
        TextView  cancel_btn= (TextView) inflate.findViewById(R.id.cancel_btn);
        TextView  sure_btn= (TextView) inflate.findViewById(R.id.sure_btn);
        cancel_btn.setOnClickListener(this);
        sure_btn.setOnClickListener(this);
         pickViewm1 = (PickViewSingle) inflate.findViewById(R.id.pickview1);
         pickViewm2 = (PickViewSingle) inflate.findViewById(R.id.pickview2);
        pickViewm1.startUi(list1);
        pickViewm2.startUi(list1);
    }
    PickViewSingle pickViewm1,pickViewm2;
    private  int countr=8;
   public void initList() {
       list1=new ArrayList<>();
       for (int i = 0; i <countr ; i++) {
           list1.add(i);
       }

   }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    //     list1.clear();
    }

    private List<Integer> list1;
   private List<Integer> list2;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.cancel_btn:
                PopwindowUtils.getPopwindowUtils().getPopupWindow().dismiss();
                break;
            case  R.id.sure_btn:
                if (popTime!=null){
                    popTime.next(pickViewm1.getCounts(),pickViewm2.getCounts());
                }
                break;
        }
    }
    public void setTipa( PopTime popTime){
        this.popTime =  popTime;
    }

    PopTime popTime;
    public interface  PopTime{
        void  next(int man,int child);
    }

}

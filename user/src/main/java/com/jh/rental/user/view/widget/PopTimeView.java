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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class PopTimeView extends LinearLayout implements View.OnClickListener {
private  Context context;
    public PopTimeView(Context context) {
        this(context, null);
    }

    public PopTimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

   private WheelView wva1,wva2,wva3,wva4,wva5,wva6;
    private void init() {
        Calendar calendar =Calendar.getInstance();
        int i = calendar.get(Calendar.YEAR);
        int j = calendar.get(Calendar.MONTH);
        list.clear();
        list.add("");
        list.add(String.format("%d年",i));
        list.add(String.format("%d年",i+1));
        list.add(String.format("%d年",i+2));
      /*  list.add(String.format("%d年",i+2));
        list.add(String.format("%d年",i+3));*/
        for (int k = 0; k <12 ; k++) {
            list1.add(String.format("%d月",i+1));
        }
        for (int k = 0; k <31 ; k++) {
            list2.add(String.format("%d日",i+1));
        }
        for (int k = 0; k <31 ; k++) {
            list2.add(String.format("%d日",i+1));
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_time, this);
        TextView  cancel_btn= (TextView) inflate.findViewById(R.id.cancel_btn);
        TextView  sure_btn= (TextView) inflate.findViewById(R.id.sure_btn);
        cancel_btn.setOnClickListener(this);
        sure_btn.setOnClickListener(this);
         wva1 = (WheelView) inflate.findViewById(R.id.wheel1);
        wva1.setOffset(1);
        wva1.setItems(list);
         wva2 = (WheelView) inflate.findViewById(R.id.wheel2);
         wva2.setOffset(1);
        wva2.setItems(list);
         wva3 = (WheelView) inflate.findViewById(R.id.wheel3);
        wva3.setOffset(1);
        wva3.setItems(list);
        wva4 = (WheelView) inflate.findViewById(R.id.wheel4);
        wva4.setOffset(1);
        wva4.setItems(list);
        wva5 = (WheelView) inflate.findViewById(R.id.wheel5);
        wva5.setOffset(1);
        wva5.setItems(list);
        wva6 = (WheelView) inflate.findViewById(R.id.wheel6);
        wva6.setOffset(1);
        wva6.setItems(list);
    }
    List<String>  list=new ArrayList<>();
    List<String>  list1=new ArrayList<>();
    List<String>  list2=new ArrayList<>();
    List<String>  list3=new ArrayList<>();
    List<String>  list4=new ArrayList<>();
    List<String>  list5=new ArrayList<>();

    @Override
    protected void onAttachedToWindow() {


        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        list.clear();
        list1.clear();
        list2.clear();
        list3.clear();
        list4.clear();
        list5.clear();

        super.onDetachedFromWindow();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.cancel_btn:
                Logger.soutMessage(""+wva1.getSeletedItem()+"SS"+wva2.getSeletedItem()+"SS"+wva3.getSeletedItem()+"SS"
                        +wva4.getSeletedItem()+"SS"+wva5.getSeletedItem()+"SS"+wva6.getSeletedItem()+"SS");
                PopwindowUtils.getPopwindowUtils().getPopupWindow().dismiss();
                break;
            case  R.id.sure_btn:
//                PopwindowUtils.getPopwindowUtils().show(new PopCarTypeView(getContext()),v,this.getActivity());
//       Activity activity= (Activity) context;
                popTime.next();
                break;
        }
    }
    public void setTipa( PopTime popTime){
        this.popTime =  popTime;
    }

  private   PopTime  popTime;
     public interface  PopTime{
         void  next();
     }

}

package com.jh.rental.user.view.widget.pickdate;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.jh.rental.user.R;


/**
 * Created by 骏辉出行 on 2017/6/10.
 */

public class MyLinerlayout extends LinearLayout {
    public MyLinerlayout(Context context) {
        super(context);
    }
    public MyLinerlayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
     View   inflate =  LayoutInflater.from(context).inflate(R.layout.pickdate, this);
        PickViewm2 pickViewm1= (PickViewm2) inflate.findViewById(R.id.jason1);
        PickViewm pickViewm5= (PickViewm) inflate.findViewById(R.id.jason5);
        PickViewm pickViewm6= (PickViewm) inflate.findViewById(R.id.jason6);
        pickViewm1.startUi("s");
        pickViewm5.startUi(Type.HOUR,"H");
        pickViewm6.startUi(Type.TIME,"分");
  }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}

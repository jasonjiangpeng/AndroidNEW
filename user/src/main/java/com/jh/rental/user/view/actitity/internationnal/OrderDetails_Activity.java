package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

/**
 * Created by 骏辉出行 on 2017/5/26.
 * 专车接送
 */

public class OrderDetails_Activity extends TitelBarAcitvity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    String indent = null;
    public static int TAB = 1;
    private CheckBox checkBox1,checkBox2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderdetails_activity);
        setMyTitel(BaseContext.getResValue(R.string.OrderDetails));
        init();
    }
    private void init() {
        LinearLayout ll_tiiv = (LinearLayout) findViewById(R.id.ll_tiiv);
        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        TextView tv_tiiv = (TextView) findViewById(R.id.tv_tiiv);
        if ( getIntent().getStringExtra("indent")!=null){
            indent=getIntent().getStringExtra("indent");
            if ("CharteredBu".equals(indent)){
                ll_tiiv.setVisibility(View.GONE);
                tv_tiiv.setVisibility(View.VISIBLE);
                TAB = 2;
            }else {
                TAB = 1;
            }
        }
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    @Override
    public void handleManage(int value) {
      /*   if (checkBox1.isChecked()){
             checkBox2.setChecked(false);
         }else {
             checkBox2.setChecked(true);
         }*/
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                ActivityUtils.nextActivity(PaySuccess_Activity.class,"tab",TAB);
                break;
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
             switch (buttonView.getId()){
                 case R.id.checkbox2:
                     if(isChecked) checkBox1.setChecked(false);
                     else checkBox1.setChecked(true);
                     break;
                 case R.id.checkbox1:
                     if(isChecked) checkBox2.setChecked(false);
                     else checkBox2.setChecked(true);
                     break;
             }
    }
}

package com.jh.rental.user.view.actitity.home;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.intent.FlightMessage;
import com.jh.rental.user.constants.IntentKeyName;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAbsAcitvity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCanlenderSingleView;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class FlightMessageSub_Act extends TitelBarAbsAcitvity implements View.OnClickListener {

    @Override
    public int resId() {
        return R.layout.flightmessagesub_act;
    }
private TextView flight_choosetime;
    private EditText  flight_edt1;
    private Button flight_commit;
    @Override
    public void initUI() {
        flight_choosetime = (TextView) findViewById(R.id.flight_choosetime);
        flight_edt1 = (EditText) findViewById(R.id.flight_edt1);
        flight_commit = (Button) findViewById(R.id.flight_commit);
        flight_commit.setOnClickListener(this);
        popCanlenderSingleView =new PopCanlenderSingleView(this);
        popCanlenderSingleView.setCallBackData(new PopCanlenderSingleView.CallBackData() {
            @Override
            public void callbackData(String value) {
                flight_choosetime.setText(value);

            }
        });
        flight_choosetime.setOnClickListener(this);
    }

    @Override
    public String resTitel() {
        return BaseContext.getResValue(R.string.flightmessage);
    }
    PopCanlenderSingleView   popCanlenderSingleView;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.flight_choosetime:
                if (TextUtils.isEmpty(flight_edt1.getText().toString())){
                    SnakebarUtils.show(v,"请输入航班号");
                }else PopwindowUtils.getPopwindowUtils().show(popCanlenderSingleView,v,this);
                break;
            case R.id.flight_commit:
                if (!TextUtils.isEmpty(flight_edt1.getText().toString())&&!TextUtils.isEmpty(flight_choosetime.getText())) {
                     String  date=flight_choosetime.getText().toString();
                    String value=flight_edt1.getText().toString();

                   /*    ActivityUtils.nextActivity(FlightMessage_Act.class,IntentKeyName.flightmessage,new FlightMessage(date,value));
                    onBackPressed();*/
                    Intent  intent =new Intent();
                    intent.setAction(IntentKeyName.FlighActionBroadreciver);
                    intent.putExtra(IntentKeyName.flightmessage,new FlightMessage(date,value));
                    BaseApplication.currentActivity().sendBroadcast(intent);
                    onBackPressed();

                }else {
                    SnakebarUtils.show(v,"请输入完整信息");
                }
                break;
        }
    }

}

package com.jh.rental.user.view.actitity.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.ordermessage.QueryFlightMsg;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.utils.tom.PreferencesUtil;
import com.jh.rental.user.view.actitity.TitelBarAbsAcitvity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCanlenderSingleView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class FlightMessage1_Act extends TitelBarAbsAcitvity implements TextWatcher, View.OnClickListener {

    private LinearLayout mLlFlightNum;
    private EditText mEtFlightNum;
    private TextView mTvFlightNum;
    PopCanlenderSingleView popCanlenderSingleView;
    String str;
    @Override
    public int resId() {
        return R.layout.flightmessage1_act;
    }

    @Override
    public void initUI() {
        mEtFlightNum = (EditText) findViewById(R.id.et_flightNum);
        mLlFlightNum = (LinearLayout) findViewById(R.id.ll_flightNum);
        mTvFlightNum = (TextView) findViewById(R.id.tv_flightNum);
        mEtFlightNum.addTextChangedListener(this);
        mTvFlightNum.setOnClickListener(this);
        popCanlenderSingleView = new PopCanlenderSingleView(this);
        popCanlenderSingleView.setCallBackData(new PopCanlenderSingleView.CallBackData() {
            @Override
            public void callbackData(String value) {
                        sendMRequestData(value);
            }
        });
    }
    @Override
    public String resTitel() {
        return BaseContext.getResValue(R.string.flightmessage);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        str = s.toString().toUpperCase();
        mTvFlightNum.setText(str);
        if (s.length() >= 3 ){
            mLlFlightNum.setVisibility(View.VISIBLE);
        }else {
            mLlFlightNum.setVisibility(View.GONE);
        }
    }
    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_flightNum:
                PopwindowUtils.getPopwindowUtils().show(popCanlenderSingleView,v,this);
                break;
        }
    }

//9C8509
    public void sendMRequestData( String va) {
        Logger.soutMessage(va);
        flightNo=mTvFlightNum.getText().toString();
        HttpVolley.getInstance().getRequestParamData(ApiGet.queryFlightMsg,getLinkdHashHap(key1,flightNo,va),
                new NetSucceed<>(QueryFlightMsg.class, new NetSucceed.HolderData<QueryFlightMsg>() {
                    @Override
                    public void holdData(QueryFlightMsg bean) {
                       if (bean.getArrive()==null){
                           SnakebarUtils.showToast("没有查询到航班");
                       }else {
                           PickupDetails.getOrderDetails().setArrive(bean.getArrive());
                           PickupDetails.getOrderDetails().setFlightNo(bean.getFlightNo());
                           PickupDetails.getOrderDetails().setArriveTime(bean.getArriveTime());
                           PickupDetails.getOrderDetails().setDate(bean.getArriveDate());
                           PopwindowUtils.getPopwindowUtils().getPopupWindow().dismiss();
                           if (!PopwindowUtils.getPopwindowUtils().getPopupWindow().isShowing()){
                               ActivityUtils.nextActivity(FlightMessage2_Act.class);
                           }



                       }
                    }
                }),null);
    }
  private String[] key1={"flightNo","date"};
  private String flightNo;
  private String date;
    public String getCurrdate(){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yy-MM-dd");
        Date date=new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        return format;
    }
}

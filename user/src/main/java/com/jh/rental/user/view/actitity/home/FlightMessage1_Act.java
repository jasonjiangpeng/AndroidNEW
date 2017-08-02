package com.jh.rental.user.view.actitity.home;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.CarPriceSend;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.location.WayPointOne;
import com.jh.rental.user.bean.location.WayPointTwo;
import com.jh.rental.user.db.flight.DBFlight;
import com.jh.rental.user.db.flight.FlightMessage;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.actitity.FlightList;
import com.jh.rental.user.view.actitity.TitelBarAbsAcitvity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCanlenderSingleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class FlightMessage1_Act extends TitelBarAbsAcitvity implements TextWatcher, View.OnClickListener {
    private LinearLayout mLlFlightNum;
    private EditText mEtFlightNum;
    private TextView mTvFlightNum;
    private PopCanlenderSingleView popCanlenderSingleView;
    private String str;
    private LinearLayout imgclear;
    private ListView listView;
    private DBFlight dbFlight;
    private List<FlightMessage> dataValue;
    private SimpleAdapter simpleAdapter;

    @Override
    public int resId() {
        return R.layout.flightmessage1_act;
    }

    public void saveToDb() {
        String string = mTvFlightNum.getText().toString();
        long time = System.currentTimeMillis();
        FlightMessage message = new FlightMessage(time, string);
        dbFlight.replaceLove(message);
   /*   dataValue.clear();
      dataValue.addAll(dbFlight.qureyAllData());
     // simpleAdapter.notifyDataSetChanged();*/
    }

    @Override
    public void handleManage(int value) {
        if (value == 0) {
            if (simpleAdapter != null) {
                simpleAdapter.notifyDataSetChanged();
            } else {
                handler.sendEmptyMessageDelayed(0, 30);
            }
        }

    }

    @Override
    public void initUI() {
        PickupDetails.crePickupDetails();
        CarPriceSend.createInit();
        WayPointOne.creOredeDetails();
        WayPointTwo.creOredeDetails();
        OrderDetails.creOredeDetails();
        dataValue = new ArrayList<>();
        dbFlight = new DBFlight();
        Logger.soutMessage(dbFlight.qureyAllData().size());
        dataValue.addAll(dbFlight.qureyAllData());
        simpleAdapter = new SimpleAdapter();
        mEtFlightNum = (EditText) findViewById(R.id.et_flightNum);
        listView = (ListView) findViewById(R.id.showdata);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mEtFlightNum.setText(dataValue.get(position).getValue());
                PopwindowUtils.getPopwindowUtils().show(popCanlenderSingleView, view, FlightMessage1_Act.this);
            }
        });
        mLlFlightNum = (LinearLayout) findViewById(R.id.ll_flightNum);
        mTvFlightNum = (TextView) findViewById(R.id.tv_flightNum);
        imgclear = (LinearLayout) findViewById(R.id.imgclear);
        imgclear.setVisibility(View.GONE);
        imgclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtFlightNum.setText("");
            }
        });
        mEtFlightNum.addTextChangedListener(this);
        mTvFlightNum.setOnClickListener(this);
        popCanlenderSingleView = new PopCanlenderSingleView(this);
        popCanlenderSingleView.setCallBackData(new PopCanlenderSingleView.CallBackData() {
            @Override
            public void callbackData(final String value, View view) {
                ActivityUtils.nextActivity(FlightList.class);
                new Thread() {
                    @Override
                    public void run() {
                        saveToDb();
                        PickupDetails.getOrderDetails().setWriteflightNo(mTvFlightNum.getText().toString());
                        PickupDetails.getOrderDetails().setWritedate(value);

                    }
                }.start();

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
        if (s.length() >= 3) {
            mLlFlightNum.setVisibility(View.VISIBLE);
            imgclear.setVisibility(View.VISIBLE);
        } else {
            imgclear.setVisibility(View.GONE);
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
                PopwindowUtils.getPopwindowUtils().show(popCanlenderSingleView, v, this);
                break;
        }
    }

    class SimpleAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return dataValue.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SimpleText simpleText = null;
            if (convertView == null) {
                simpleText = new SimpleText();
                convertView = LayoutInflater.from(FlightMessage1_Act.this).inflate(R.layout.item_test, null);
                simpleText.tv = (TextView) convertView.findViewById(R.id.test1);
                simpleText.cleardata = (TextView) convertView.findViewById(R.id.cleardata);
                simpleText.flightlayout = (LinearLayout) convertView.findViewById(R.id.flightlayout);
                convertView.setTag(simpleText);
            }
            simpleText = (SimpleText) convertView.getTag();
            if (position == dataValue.size() - 1) {
                simpleText.cleardata.setVisibility(View.VISIBLE);
                simpleText.flightlayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                simpleText.cleardata.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dbFlight.clearData();
                        dataValue.clear();
                        simpleAdapter.notifyDataSetChanged();
                    }
                });
            } else {
                simpleText.cleardata.setVisibility(View.GONE);
            }

            simpleText.tv.setText(dataValue.get(position).getValue());
            return convertView;
        }
    }

    class SimpleText {
        private TextView tv;
        private TextView cleardata;
        private LinearLayout flightlayout;
    }

    public void setDataValue() {

    }
}

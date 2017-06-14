package com.jh.rental.user.view.fragment.internationnal;

import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.actitity.home.FlightMessage1_Act;

/**
 * Created by 骏辉出行 on 2017/5/26.
 */
public class PickUpAirport extends com.jh.rental.user.view.fragment.BaseFragment implements View.OnClickListener {

    @Override
    public View setView() {
    View  view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_pickupairport,null);
        init(view);
        return view;
    }

    @Override
    protected void init(View view) {
        TextView  pickup_tv1= (TextView) view.findViewById(R.id.pickup_tv1);
        TextView  pickup_tv2= (TextView) view.findViewById(R.id.pickup_tv2);
        pickup_tv1.setOnClickListener(this);
        pickup_tv2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pickup_tv1:
                ActivityUtils.nextActivity(FlightMessage1_Act.class);
                break;
            case R.id.pickup_tv2:
                Snackbar.make(v,"请输入航班号",Snackbar.LENGTH_SHORT).show();
                break;
        }
    }
}

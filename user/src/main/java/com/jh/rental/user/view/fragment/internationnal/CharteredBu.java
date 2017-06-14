package com.jh.rental.user.view.fragment.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.KeyboardCtrol;
import com.jh.rental.user.utils.jason.KeyboardUtils;
import com.jh.rental.user.view.actitity.internationnal.OrderDetails_Activity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCanlenderView;
import com.jh.rental.user.view.widget.PopCarTypeView;
import com.jh.rental.user.view.widget.PopJourneyCounterView;
import com.jh.rental.user.view.widget.SelectBoxItemView;

/**
 * Created by 俊辉出行 on 2017/5/26.
 */

public class CharteredBu extends com.jh.rental.user.view.fragment.BaseFragment implements View.OnClickListener {

    @Override
    public View setView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_charteredbus, null);
        init(view);
        return view;
    }

    @Override
    protected void init(View view) {
        Button button = (Button) view.findViewById(R.id.button);
        SelectBoxItemView charterdbus_edt1 = (SelectBoxItemView) view.findViewById(R.id.charterdbus_edt1);
        SelectBoxItemView charterdbus_counters = (SelectBoxItemView) view.findViewById(R.id.charterdbus_counters);
        SelectBoxItemView charterdbus_type = (SelectBoxItemView) view.findViewById(R.id.charterdbus_type);
        SelectBoxItemView charterdbus_date = (SelectBoxItemView) view.findViewById(R.id.charterdbus_date);
     //   charterdbus_edt1.setOnClickListener(this);
        charterdbus_counters.setOnClickListener(this);
        charterdbus_date.setOnClickListener(this);
        charterdbus_type.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                ActivityUtils.nextActivity(OrderDetails_Activity.class);
                break;
            /**/
            case R.id.charterdbus_counters:

                    PopwindowUtils.getPopwindowUtils().show(new PopJourneyCounterView(getContext()),v,this.getActivity());

                break;
            case R.id.charterdbus_date:

           //     PopwindowUtils.getPopwindowUtils().show(new PopCanlenderView(getContext()),v,this.getActivity());

                break;
            case R.id.charterdbus_type:

                PopwindowUtils.getPopwindowUtils().show(new PopCarTypeView(getContext()),v,this.getActivity());

                break;
        }
    }
}

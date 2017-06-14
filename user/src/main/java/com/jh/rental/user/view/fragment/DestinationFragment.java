package com.jh.rental.user.view.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.destination.Destination_Activity;
import com.jh.rental.user.view.adapter.destination.DestinationLeftAdapter;
import com.jh.rental.user.view.adapter.destination.DestinationRigthAdapter;

public class DestinationFragment extends BaseFragment {
    public static final String TAG = "DestinationFragment";
    String[] str = {BaseContext.getResValue(R.string.hot),
            BaseContext.getResValue(R.string.HongKongMacauTaiwan),
            BaseContext.getResValue(R.string.SoutheastAsia),
            BaseContext.getResValue(R.string.DayKorea),
            BaseContext.getResValue(R.string.European),
            BaseContext.getResValue(R.string.NorthAmerica),
            BaseContext.getResValue(R.string.SouthAmerica),
            BaseContext.getResValue(R.string.Oceania),
            BaseContext.getResValue(R.string.Africa)};
    @Override
    public View setView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_destination,null);
        init(view);

        return view;
    }
    @Override
    protected void init(View view) {
        TextView tv= (TextView) view.findViewById(R.id.sub_title);
        tv.setText(BaseContext.getResValue(R.string.destination));
        ListView rvLeftArea = (ListView) view.findViewById(R.id.rv_left_area);
        GridView destination_gridview = (GridView) view.findViewById(R.id.destination_gridview);
   //     rvLeftArea.setLayoutManager(new LinearLayoutManager(getContext()));
        rvLeftArea.setAdapter(new DestinationLeftAdapter(getContext(),str));
        destination_gridview.setAdapter(new DestinationRigthAdapter(getContext()));
       rvLeftArea.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               System.out.println(position+"=======");
           }
       });
        destination_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActivityUtils.nextActivity(Destination_Activity.class);
            }
        });
    }

}

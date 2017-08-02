package com.jh.rental.user.view.fragment.internationnal;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.actitity.journey.Itinerary_Activity;
import com.jh.rental.user.view.adapter.internationnal.CitySceneryListAdapter;

/**
 * Created by 俊辉出行 on 2017/5/31.
 */

public class CitySceneryFragment extends com.jh.rental.user.view.fragment.BaseFragment implements View.OnClickListener {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public View setView() {
        View  view= LayoutInflater.from(getContext()).inflate(R.layout.fragment_cityscenery_list,null);
        init(view);
        return view;
    }

    @Override
    protected void init(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        TextView tvItinerary = (TextView) view.findViewById(R.id.tv_itinerary);
        mAdapter = new CitySceneryListAdapter(getContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerView.setAdapter(mAdapter);

        tvItinerary.setOnClickListener(this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_itinerary:
                ActivityUtils.nextActivity(Itinerary_Activity.class);
                break;
        }
    }
}

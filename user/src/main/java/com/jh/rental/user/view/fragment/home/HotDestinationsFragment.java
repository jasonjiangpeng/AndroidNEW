package com.jh.rental.user.view.fragment.home;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;
import com.jh.rental.user.model.NetResponArrayData;
import com.jh.rental.user.model.homemodel.GetInterAreaAddressList;
import com.jh.rental.user.view.adapter.home.HotDestinationsListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;

import java.util.List;


public class HotDestinationsFragment extends BaseListFragment {
  //  private HotDestinationsListAdapter HotDestinationsListAdapter;

    @Override
    public RecyclerView.Adapter getAdapter() {
  /*      if (getAreaAddressList==null){
            getAreaAddressList=new ArrayList<>();
        }
        HotDestinationsListAdapter =new HotDestinationsListAdapter(getContext(),getAreaAddressList);*/
        return null;
    }

    @Override
    protected void init() {
        super.init();
        netRequest();
    }

    public void netRequest() {
        new GetInterAreaAddressList().netRequest(new NetResponArrayData<GetAreaAddressList>() {
            @Override
            public void responeData(final List<GetAreaAddressList> values) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        HotDestinationsListAdapter hotRouteListAdapter =new HotDestinationsListAdapter(getContext(),values);
                        initRecyclerView(hotRouteListAdapter);

                    }
                });

            }
        });
    }


    @Override
    public void dataCallBack() {

    }
}

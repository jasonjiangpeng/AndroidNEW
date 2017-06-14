package com.jh.rental.user.view.fragment;


import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.order.FindOrdersbean;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.actitity.journey.WaitingPayment_Activity_;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class JourneyFragment extends BaseFragment {
    public static final String TAG = "JourneyFragment";
    private String[] values={"start","size"};
   private    volatile List<FindOrdersbean.ListBean> listBeenl;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        handler.sendEmptyMessage(0);
    }

    @Override
    public View setView() {
        listBeenl=new ArrayList<>();
        View view =LayoutInflater.from(getContext()).inflate(R.layout.fragment_journey,null);
        init(view);
        return view;
    }
  private Handler handler =new Handler(Looper.getMainLooper()){
      @Override
      public void handleMessage(Message msg) {
          switch (msg.what){
              case 0:
                  netRequest();
                  break;
              case 1:
                 uihanlder();
                  break;
          }

      }

  };

    private void uihanlder() {

    }
    private void netRequest() {
        HttpVolley.getInstance().getRequestParamData(ApiGet.findOrders,getLinkdHashHap(values,"1","6"),new NetSucceed<>(FindOrdersbean.class, new NetSucceed.HolderData<FindOrdersbean>() {
            @Override
            public void holdData(FindOrdersbean bean) {
                if (bean==null){
                    return;
                }
                listBeenl=bean.getList();
                if (listBeenl.size()>0){
                    journeyAdapter.notifyDataSetChanged();
                }
            }
        }),new NetError());
    }
    public LinkedHashMap<String,String > getLinkdHashHap(String[] efg, String...abc){
        LinkedHashMap<String,String > linkedHashMap=new LinkedHashMap<>();
        for (int i = 0; i <efg.length ; i++) {
            linkedHashMap.put(efg[i],abc[i]);
        }
        return linkedHashMap;
    }
private     JourneyAdapter  journeyAdapter;
    @Override
    protected void init(View view) {
       TextView  tv= (TextView) view.findViewById(R.id.sub2_title);
        tv.setText(BaseContext.getResValue(R.string.myjoureny));
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.journey_view);
          journeyAdapter =new JourneyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(journeyAdapter);
    }

    class JourneyAdapter extends RecyclerView.Adapter<JourineyHolder>{
        @Override
        public JourineyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            JourineyHolder jourineyHolder =new JourineyHolder(LayoutInflater.from(JourneyFragment.this.getContext()).
                    inflate(R.layout.sub_item_journey, parent, false));
            return jourineyHolder;
        }
        @Override
        public void onBindViewHolder(JourineyHolder holder, final int position) {
            holder.tv1.setText(typeJudge(listBeenl.get(position).getService_type()));
            holder.tv2.setText(listBeenl.get(position).getStatusName());
            holder.tv3.setText(listBeenl.get(position).getBegin_address());
            holder.tv4.setText(listBeenl.get(position).getEnd_address());
            holder.tv5.setText(listBeenl.get(position).getPrice_sum());
            holder.mItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ActivityUtils.nextActivity(WaitingPayment_Activity_.class,"order1",listBeenl.get(position).getId());
                }
            });
        }

        @Override
        public int getItemCount() {
            return listBeenl.size();
        }
    }
    private String  typeJudge(int value){
        String[] resArraysValue = BaseContext.getResArraysValue(R.array.serviceType);
        if (value>resArraysValue.length){
            return "error";
        }

        return  resArraysValue[value];
    }
    class JourineyHolder extends RecyclerView.ViewHolder{
        View mItemView;
      private   TextView  tv1,tv2,tv3,tv4,tv5,tv6;
        public JourineyHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            tv1= (TextView) mItemView.findViewById(R.id.jut1);
            tv2= (TextView) mItemView.findViewById(R.id.jut2);
            tv3= (TextView) mItemView.findViewById(R.id.jut3);
            tv4= (TextView) mItemView.findViewById(R.id.jut4);
            tv5= (TextView) mItemView.findViewById(R.id.jut5);

           //AutoUtils.autoSize(mItemView);
        }
    }
}

package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.location.HotAddress;
import com.jh.rental.user.bean.ordermessage.GetHotAddressList;
import com.jh.rental.user.bean.pickup.GetGDAddressList;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.internationnal.SingleAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.jh.rental.user.api.ApiGet.getGDAddressList;

public class AddressLocationPick_Activity extends TitelBarAcitvity implements View.OnClickListener {
    TextView tv2;
    private List<HotAddress> hotAddresses;
    private ListView mylistview;
   private List<String> values;
    @Override
    public void initParameter() {
              hotAddresses =new ArrayList<>();

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getGDAddressList=new ArrayList<>();
        values =new ArrayList<>();
        setContentView(R.layout.addresslocationpick_activity);
        initView();
    }
    private SingleAdapter sim;
    private void initView() {
        RecyclerView rlAddress = (RecyclerView)findViewById(R.id.rl_address);
        sim =new SingleAdapter(values,this);
        mylistview = (ListView)findViewById(R.id.mylistview);
        mylistview.setAdapter(sim);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                tv2.setText(getGDAddressList.get(position).getName());
                mylistview.setVisibility(View.GONE);
                  String date=getGDAddressList.get(position).getId();
                Logger.soutMessage("date"+date);
                        getHotAddressList(date);
            }
        });
        tv2 = (TextView)findViewById(R.id.addresstv2);
        tv2.setOnClickListener(this);
        tv2.setVisibility(View.VISIBLE);
        addressLocationAdapter =new AddressLocationAdapter();
        rlAddress.setLayoutManager(new LinearLayoutManager(this));
        rlAddress.setAdapter(addressLocationAdapter);
    }
    AddressLocationAdapter  addressLocationAdapter;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addresstv2:
               if (mylistview.getVisibility()==View.GONE){
                                handler.sendEmptyMessage(2);
               }
                break;
        }
    }

    class AddressLocationAdapter extends RecyclerView.Adapter<AddressLocationHolder>{
        @Override
        public AddressLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            AddressLocationHolder jourineyHolder =new AddressLocationHolder(
                    LayoutInflater.from(AddressLocationPick_Activity.this).inflate(R.layout.sub_item_address, parent, false));

            return jourineyHolder;
        }

        @Override
        public void onBindViewHolder(AddressLocationHolder holder, final int position) {
                     holder.addressa1.setText(hotAddresses.get(position).getName());
                     holder.addressa2.setText(hotAddresses.get(position).getAddress());
                 holder.addresslv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PickupDetails.getOrderDetails().setDescitys(hotAddresses.get(position).getName());
                    BaseApplication.finishActivity();
                }
            });

        }
        @Override
        public int getItemCount() {
            return hotAddresses.size();
        }}

    class AddressLocationHolder extends RecyclerView.ViewHolder{
        private LinearLayout addresslv;
        private TextView addressa1,addressa2;
        public AddressLocationHolder(View itemView) {
            super(itemView);
                   addressa1= (TextView) itemView.findViewById(R.id.addressa1);
                   addressa2= (TextView) itemView.findViewById(R.id.addressa2);
                  addresslv= (LinearLayout) itemView.findViewById(R.id.addresslv);

        }

    }
    private       List<GetGDAddressList>  getGDAddressList;
    @Override
    public void sendRequestData() {
        HttpVolley.getInstance().getRequestData(ApiGet.getGDAddressList,new NetJsonArraySucceed<>(GetGDAddressList.class, new NetJsonArraySucceed.HolderData<GetGDAddressList>() {
            @Override
            public void holdData(ArrayList<GetGDAddressList> bean) {
               if (bean!=null&&bean.size()>1){
                   getGDAddressList=bean;
               }
                for (int i = 0; i <getGDAddressList.size() ; i++) {
                    values.add(getGDAddressList.get(i).getName());
                }
                handler.sendEmptyMessage(0);
            }
        }),null);


    }

    @Override
    public void handleManage(int value) {
        if (value==0){
           getHotAddressList(getGDAddressList.get(0).getId());
            tv2.setText(getGDAddressList.get(0).getName());
            sim.notifyDataSetChanged();
        }else if (value==899){
            addressLocationAdapter.notifyDataSetChanged();
        }else if (value==2){
            mylistview.setVisibility(View.VISIBLE);
        }
    }
    private String[] ba={"cityId"};
    public void getHotAddressList(String value){
           HttpVolley.getInstance().postMapRequest(ApiPost.getHotAddressList,getBaseMap(ba,value),new NetJsonArraySucceed<>(GetHotAddressList.class, new NetJsonArraySucceed.HolderData<GetHotAddressList>() {
            @Override
            public void holdData(ArrayList<GetHotAddressList> bean) {
                if (bean.size()<1){
                    return;
                }
                hotAddresses.clear();
                for (int i = 0; i <bean.size() ; i++) {
                    Logger.soutMessage(bean.get(i).getAdrName());
                    hotAddresses.add(new HotAddress(bean.get(i).getAdrName(),bean.get(i).getAddress()));
                }
                handler.sendEmptyMessage(899);
            }
        }),null);
    }

}

package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.ordermessage.GetHotAddressList;
import com.jh.rental.user.bean.location.HotAddress;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import java.util.ArrayList;
import java.util.List;

public class AddressLocationDes_Activity extends TitelBarAcitvity{
    TextView tv1,tv2;
    private List<HotAddress> hotAddresses;
    @Override
    public void initParameter() {
              hotAddresses =new ArrayList<>();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addresslocation_activity);
        initView();
    }

    private void initView() {
        RecyclerView rlAddress = (RecyclerView)findViewById(R.id.rl_address);
        tv1 = (TextView)findViewById(R.id.addresstv1);
        if (getIntent()!=null&&getIntent().getStringExtra("addrsslocation")!=null){
                tv1.setText(getIntent().getStringExtra("addrsslocation"));
        }else {
            tv2 = (TextView)findViewById(R.id.addresstv2);
            tv1.setVisibility(View.GONE);
            tv2.setVisibility(View.VISIBLE);

        }
          addressLocationAdapter =new AddressLocationAdapter();
        rlAddress.setLayoutManager(new LinearLayoutManager(this));
        rlAddress.setAdapter(addressLocationAdapter);

    }
    AddressLocationAdapter  addressLocationAdapter;
    class AddressLocationAdapter extends RecyclerView.Adapter<AddressLocationHolder>{
        @Override
        public AddressLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            AddressLocationHolder jourineyHolder =new AddressLocationHolder(
                    LayoutInflater.from(AddressLocationDes_Activity.this).inflate(R.layout.sub_item_address, parent, false));

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



    @Override
    public void sendRequestData() {
    final String[] ba={"cityId"};
        HttpVolley.getInstance().postMapRequest(ApiPost.getHotAddressList,getBaseMap(ba,"111"),new NetJsonArraySucceed<>(GetHotAddressList.class, new NetJsonArraySucceed.HolderData<GetHotAddressList>() {
            @Override
            public void holdData(ArrayList<GetHotAddressList> bean) {
                 if (bean.size()<1){
                     return;
                 }
                for (int i = 0; i <bean.size() ; i++) {
                    hotAddresses.add(new HotAddress(bean.get(i).getAdrName(),bean.get(i).getAddress()));
                }
                handler.sendEmptyMessage(0);
            }
        }),null);
    }

    @Override
    public void handleManage(int value) {
        addressLocationAdapter.notifyDataSetChanged();
    }

}

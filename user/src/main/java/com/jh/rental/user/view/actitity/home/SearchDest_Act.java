package com.jh.rental.user.view.actitity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.CityData;
import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.view.actitity.BaseActvity;
import com.jh.rental.user.view.adapter.destination.DestinationLeftAdapter2;
import com.jh.rental.user.view.adapter.destination.HistoryAddressAdapter;
import com.jh.rental.user.view.adapter.destination.SearchDesRigthAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/1.
 */

public class SearchDest_Act extends BaseActvity implements View.OnClickListener {
    private List<String>  list;
    private List<CityData>  lists;
    private List<GetAreaAddressList>  getAreaAddressList;
    private TextView cancel;
    private ListView sd_left_area;
    private GridView gridView1;
    private GridView gridView2;
    private LinearLayout searchdes_layout;
    private DestinationLeftAdapter2 destinationLeftAdapter2;
    private SearchDesRigthAdapter searchDesRigthAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        list=new ArrayList<>();
        lists=new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seachdestination_activity);
        initUI();
    }
    private void initUI() {

        destinationLeftAdapter2=new DestinationLeftAdapter2(getApplicationContext(),list);
        searchDesRigthAdapter=new SearchDesRigthAdapter(getApplicationContext(),lists);
        searchdes_layout= (LinearLayout) findViewById(R.id.searchdes_layout);
        cancel= (TextView) findViewById(R.id.tv_cancel);
        cancel.setOnClickListener(this);
        sd_left_area= (ListView) findViewById(R.id.sd_left_area);
        gridView1= (GridView) findViewById(R.id.destination_gridview1);
        gridView2= (GridView) findViewById(R.id.sd_destination_gridview);
        sd_left_area.setAdapter(destinationLeftAdapter2);
        destinationLeftAdapter2.setChangeData(new DestinationLeftAdapter2.ChangeData() {
            @Override
            public void changeData(int value) {
                List<GetAreaAddressList.AddressListBean> addressList = getAreaAddressList.get(value).getAddressList();
                lists.clear();
                for (int i = 0; i <  addressList.size() ; i++) {
                    lists.add(new CityData(addressList.get(i).getName(),addressList.get(i).getId()));
                }
                handler.sendEmptyMessage(2);
            }
        });
        gridView1.setAdapter(new HistoryAddressAdapter(getApplicationContext()));
        gridView2.setAdapter(searchDesRigthAdapter);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                onBackPressed();
                break;
        }
    }

    @Override
    public void sendRequestData() {
        HttpVolley.getInstance().getRequestData(ApiGet.getAreaAddressList, new NetJsonArraySucceed<>(GetAreaAddressList.class, new NetJsonArraySucceed.HolderData<GetAreaAddressList>() {
            @Override
            public void holdData(ArrayList<GetAreaAddressList> bean) {
                if (getAreaAddressList==null){
                    getAreaAddressList=new ArrayList<>();
                }
                getAreaAddressList=bean;
                for (GetAreaAddressList getArea:getAreaAddressList){
                  list.add(getArea.getAreaName());
                }
                List<GetAreaAddressList.AddressListBean> addressList = getAreaAddressList.get(0).getAddressList();
                for (int i = 0; i <  addressList.size() ; i++) {
                    lists.add(new CityData(addressList.get(i).getName(),addressList.get(i).getId()));
                }
                handler.sendEmptyMessage(0);
            }
        }),null);
    }

    @Override
    public void handleManage(int value) {
        if (value==2){
            searchDesRigthAdapter.notifyDataSetChanged();
        }else {
             searchDesRigthAdapter.notifyDataSetChanged();
             destinationLeftAdapter2.notifyDataSetChanged();
        }

    }
}

package com.jh.rental.user.view.adapter.destination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;
import com.jh.rental.user.db.flight.DBHistoryCity;
import com.jh.rental.user.db.flight.HistoryCity;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.destination.Destination_Activity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by 俊辉出行 on 2017/5/24.
 */

public class SearchDesRigthAdapter extends BaseAdapter {
    Context context;
    List<GetAreaAddressList.AddressListBean> list;
    public SearchDesRigthAdapter(Context context) {
        this(context,null);
    }
    public SearchDesRigthAdapter(Context context,    List<GetAreaAddressList.AddressListBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        if (list!=null){
            return list.size();
        }
        return 5;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.sub_item_search_list,parent, false);
            AutoUtils.autoSize(convertView);
        }
       Button  button=(Button)convertView.findViewById(R.id.address1);
          if (list!=null){
              String name = list.get(position).getName();
              if (name.indexOf("(")!=-1){
                  String name2 = name.substring(0, name.indexOf("("));
                  button.setText(name2);
              }else {
                  button.setText(name);
              }
          }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        DBHistoryCity dbHistoryCity=new DBHistoryCity();
                        HistoryCity historyCity =new HistoryCity(System.currentTimeMillis(),list.get(position).getId(),list.get(position).getName(),"null",
                                String.valueOf( list.get(position).getGdLng()),String.valueOf(  list.get(position).getGdLat()));
                        dbHistoryCity.replaceLove(historyCity);
                    }
                }.start();
                if (ApiConstants.searchChoose==2){
                    OrderDetails.getOrderDetails().setCity(list.get(position).getName());
                    OrderDetails.getOrderDetails().setId(list.get(position).getId());
                    BaseApplication.finishActivity();
                }else {
                    OrderDetails.setValue(list.get(position).getId(),list.get(position).getImgUrl());
                    ActivityUtils.nextActivity(Destination_Activity.class,"cityName",list.get(position).getName());
                }
            }
        });
        return convertView;
    }


}

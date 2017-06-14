package com.jh.rental.user.view.adapter.destination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.CityData;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.SimpleObject;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by 俊辉出行 on 2017/5/24.
 */

public class SearchDesRigthAdapter extends BaseAdapter {
    Context context;
    List<CityData> list;
    public SearchDesRigthAdapter(Context context) {
        this(context,null);
    }
    public SearchDesRigthAdapter(Context context,    List<CityData> list) {
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
              button.setText(list.get(position).getCity());
          }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OrderDetails.getOrderDetails().setCity(list.get(position).getCity());
                OrderDetails.getOrderDetails().setId(list.get(position).getId());
                BaseApplication.finishActivity();
            }
        });
        return convertView;
    }

}

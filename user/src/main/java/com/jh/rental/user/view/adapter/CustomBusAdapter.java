package com.jh.rental.user.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;

import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public class CustomBusAdapter extends BaseAdapter {
    Context context;
   // List<Object>
    public CustomBusAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return 20;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder customViewHolder;
       if (convertView==null){
           convertView= LayoutInflater.from(context).inflate(R.layout.sub_tokyoscenic_item,null);
           customViewHolder=new CustomViewHolder();
        //   customViewHolder.choose=f
       }
        return convertView;
    }
   class   CustomViewHolder{
       TextView  timer;
       CheckBox choose;
       TextView titel;
       ImageView photo;
   }
}

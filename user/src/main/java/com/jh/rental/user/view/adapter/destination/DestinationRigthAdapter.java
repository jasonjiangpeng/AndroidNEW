package com.jh.rental.user.view.adapter.destination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;

/**
 * Created by 俊辉出行 on 2017/5/24.
 */

public class DestinationRigthAdapter extends BaseAdapter{
    Context context;
    public DestinationRigthAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.sub_item_destination_list,null);
        }
        return convertView;
    }
   class   DestinationHolder{
       ImageView img;
       TextView  tv;
   }
}

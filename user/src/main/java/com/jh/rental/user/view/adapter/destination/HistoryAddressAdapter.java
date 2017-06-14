package com.jh.rental.user.view.adapter.destination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/5/24.
 */

public class HistoryAddressAdapter extends BaseAdapter {
    Context context;
    public HistoryAddressAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return 4;
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
            convertView=LayoutInflater.from(context).inflate(R.layout.sub_item_history_list,parent, false);
            AutoUtils.autoSize(convertView);
        }
        return convertView;
    }

    class  HistoryHolder{
       Button mAddress;
   }
}

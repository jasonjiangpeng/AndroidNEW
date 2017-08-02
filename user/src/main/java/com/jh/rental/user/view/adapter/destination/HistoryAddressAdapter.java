package com.jh.rental.user.view.adapter.destination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.db.flight.HistoryCity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by 俊辉出行 on 2017/5/24.
 */

public class HistoryAddressAdapter extends BaseAdapter {
    Context context;
private List<HistoryCity>  list;
    public HistoryAddressAdapter(Context context,List<HistoryCity>  list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        HistoryHolder historyHolder;
        if (convertView==null){
            historyHolder=new HistoryHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.sub_item_history_list,parent, false);
            historyHolder.mAddress= (TextView) convertView.findViewById(R.id.tv_tex);
            convertView.setTag(historyHolder);
            AutoUtils.autoSize(convertView);
        }
         historyHolder= (HistoryHolder) convertView.getTag();
        historyHolder.mAddress.setText(list.get(position).getCityName());
        historyHolder.mAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (callback!=null){
                     callback.dataCallback(list,position);
                 }
            }
        });
        return convertView;
    }
  private CallBack callback;

    public CallBack getCallback() {
        return callback;
    }

    public void setCallback(CallBack callback) {
        this.callback = callback;
    }

    class  HistoryHolder{
        TextView mAddress;
   }
  public interface CallBack{
       void dataCallback(List<HistoryCity> list,int positon);
   }
}

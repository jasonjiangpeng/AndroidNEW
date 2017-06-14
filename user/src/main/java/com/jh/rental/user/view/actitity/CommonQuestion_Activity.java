package com.jh.rental.user.view.actitity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ArraysUtils;
import com.jh.rental.user.utils.jason.BaseContext;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public class CommonQuestion_Activity extends TitelBarAcitvity{
    ListView listView;
    String[]  commonArrays= BaseContext.getResArraysValue(R.array.CommonQuestion_Activity);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commonquestion_activity);
        listView= (ListView) findViewById(R.id.list_view);
        CommonAdapter commonAdapter =new CommonAdapter();
        listView.setAdapter(commonAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int value=position+1;
                   switch (value){
                       case 1:
                           break;
                       case 2:
                           break;
                       case 3:
                           break;
                       case 4:
                           break;
                       case 5:
                           break;
                       case 6:
                           break;
                       case 7:
                           break;
                       case 8:
                           break;
                       default:
                           break;
                   }
               //    ActivityUtils.nextActivity();
            }
        });
    }
  class   CommonAdapter  extends BaseAdapter{

      @Override
      public int getCount() {
          return commonArrays.length;
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
          if (convertView==null){
              convertView= LayoutInflater.from(BaseContext.context).inflate(R.layout.sub_item_commonquestion,null);
              TextView textView = (TextView) convertView.findViewById(R.id.itemtitel);
               textView.setText(commonArrays[position]);
          }
          return convertView;
      }

  }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ArraysUtils.cleanArrays(commonArrays);
    }
}

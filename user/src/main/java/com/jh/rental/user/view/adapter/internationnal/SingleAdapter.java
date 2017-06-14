package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.bean.pickup.GetGDAddressList;
import com.jh.rental.user.utils.jason.Logger;

import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/13.
 */

public class SingleAdapter extends BaseAdapter {
   private List<String>  stringList;
   private Context context;
    public SingleAdapter(   List<String>  stringList,Context context) {
        this.stringList=stringList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView=null;
         if (textView==null){
             textView =new TextView(context);
             textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
         }
        textView.setText(stringList.get(position));
        return textView;
    }
}

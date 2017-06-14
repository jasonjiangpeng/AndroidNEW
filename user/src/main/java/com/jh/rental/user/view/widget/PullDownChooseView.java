package com.jh.rental.user.view.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.TestActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/5.
 */

public class PullDownChooseView extends LinearLayout implements View.OnClickListener {
    TextView textView1,textView2,textView3;
    List<View> lv;
    ListView listview;
    List<String>  listvalue;
   MyAdapter myAdapter;
    int  state=999;
    Handler handler =new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==999){
                listview.setVisibility(View.GONE);
                for (int i = 0; i <lv.size() ; i++) {
                    lv.get(i).setSelected(false);
                }
                state=999;
                return;
            }
            state=msg.what;
            listview.setVisibility(View.VISIBLE);
            myAdapter.notifyDataSetChanged();
            for (int i = 0; i <lv.size() ; i++) {
                if (i==msg.what){
                    lv.get(i).setSelected(true);
                }else  lv.get(i).setSelected(false);

            }

        }
    };
    public PullDownChooseView(Context context) {
        super(context);
    }

    public PullDownChooseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View inflate = LayoutInflater.from(context).inflate(R.layout.choosemenuview, this);
        lv=new ArrayList<>();
        listvalue= new ArrayList<>();
        myAdapter=new MyAdapter();
        textView1=   (TextView)inflate.findViewById(R.id.a_text1);
        textView2=   (TextView)inflate.findViewById(R.id.a_text2);
        textView3=   (TextView)inflate.findViewById(R.id.a_text3);
        listview=   (ListView) inflate.findViewById(R.id.a_list_view);
        listview.setAdapter(myAdapter);
        lv.add(textView1);
        lv.add(textView2);
        lv.add(textView3);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
    }

    @Override
    protected void onDetachedFromWindow() {
       handler.removeCallbacksAndMessages(null);
        if (lv!=null){
            lv.clear();
        }
        if (listvalue!=null){
            listvalue.clear();
        }
        super.onDetachedFromWindow();
    }

    @Override
    public void onClick(View v) {
        int a=0;
        listvalue.clear();
        switch (v.getId()){
            case R.id.a_text1:
                listvalue.add("haos");
                listvalue.add("haos");
                listvalue.add("haos");
                listvalue.add("haos");
                a=0;
                break;
            case R.id.a_text2:
                listvalue.add("hassos");
                listvalue.add("hassos");
                listvalue.add("hassos");
                a=1;
                break;
            case R.id.a_text3:
                listvalue.add("hass11os");
                listvalue.add("hass1os");
                listvalue.add("hass2os");
                listvalue.add("hass2os");
                listvalue.add("hass212os");
                a=2;
                break;
        }
        if (state==a){
            handler.sendEmptyMessage(999);
        }else handler.sendEmptyMessage(a);
    }
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return listvalue.size();
        }
        @Override
        public Object getItem(int position) {
            return listvalue.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView=LayoutInflater.from(getContext()).inflate(R.layout.sub_item_simpletext,null);
            }
            TextView  tv= (TextView) convertView.findViewById(R.id.b_sub_title);
            tv.setText(listvalue.get(position));
            return convertView;
        }
    }
}

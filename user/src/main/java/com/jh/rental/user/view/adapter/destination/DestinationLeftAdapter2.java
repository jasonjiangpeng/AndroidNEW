package com.jh.rental.user.view.adapter.destination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 俊辉出行 on 2017/5/24.
 */

public class DestinationLeftAdapter2 extends BaseAdapter   {

  private   Context context;
  private   List<String> lists;


    public DestinationLeftAdapter2(Context context, String[] str) {
       this(context,Arrays.asList(str));

    }
    public DestinationLeftAdapter2(Context context, List<String> lists) {
        this.context=context;
        this.lists=lists;

    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    int positons=0;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyHolder myHolder=null;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.sub_item_textview,null);
            myHolder=new MyHolder();
            convertView.setTag(myHolder);
        }
        myHolder= (MyHolder) convertView.getTag();
        myHolder.mImg= (ImageView) convertView.findViewById(R.id.sub_img);
        myHolder.mTxt= (TextView) convertView.findViewById(R.id.sub_text);
        myHolder.mTxt.setText(lists.get(position));
        if (position==positons){
            myHolder.mImg.setVisibility(View.VISIBLE);
            myHolder.mTxt.setBackgroundColor(BaseContext.getResIntValue(R.color.white3));
            myHolder.mTxt.setTextColor(BaseContext.getResIntValue(R.color.mudiwhite1));
        }else{
            myHolder.mImg.setVisibility(View.GONE);
            myHolder.mTxt.setBackgroundColor(BaseContext.getResIntValue(R.color.userGray2));
            myHolder.mTxt.setTextColor(BaseContext.getResIntValue(R.color.userBlack));
        }
        myHolder.mTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positons=position;
                notifyDataSetChanged();
                if (changeData!=null){
                    changeData.changeData(positons);
                }
            }




        });
        return convertView;
    }

    public ChangeData getChangeData() {
        return changeData;
    }

    public void setChangeData(ChangeData changeData) {
        this.changeData = changeData;
    }

    private    ChangeData changeData;
    class  MyHolder {
        TextView  mTxt;
        ImageView  mImg;
        public MyHolder() {

        }
    }
  public   interface ChangeData{
        void changeData(int value);
    }

}

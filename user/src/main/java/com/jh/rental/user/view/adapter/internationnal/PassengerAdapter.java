package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.db.User;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by 俊辉出行 on 2017/6/10.
 */

public class PassengerAdapter extends RecyclerView.Adapter<PassengerAdapter.PassengerHolder>  {
    private Context mContext;
    private List<User> userList;
    public PassengerAdapter(Context context,    List<User> userList) {
        this.mContext=context;
        this.userList=userList;
    }

    @Override
    public PassengerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(BaseContext.context).inflate(R.layout.sub_item_passenger_list, parent, false);
        return new PassengerHolder(view);
    }

    @Override
    public void onBindViewHolder(PassengerHolder holder,final int position) {
        String value=userList.get(position).getName()+"("+userList.get(position).getPhone()+")";
        holder.ephone.setText(value);
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataCallBack!=null){
                    dataCallBack.dataCallback(userList.get(position));
                }
            }
        });
        holder.mItemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (dataCallBack!=null){
                    dataCallBack.deledata(userList.get(position));
                }
                return false;
            }
        });
    }
    @Override
    public int getItemCount() {
        return userList.size();
    }


    private   DataCallBack  dataCallBack;

    public DataCallBack getDataCallBack() {
        return dataCallBack;
    }

    public void setDataCallBack(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    public class PassengerHolder extends RecyclerView.ViewHolder {
   private      View mItemView;
       private TextView  ephone;
        public PassengerHolder(View itemView) {
            super(itemView);
            this.mItemView = itemView;
            this.ephone= (TextView) itemView.findViewById(R.id.et_phone);
            AutoUtils.autoSize(itemView);
        }
    }


    public interface  DataCallBack{
        void  dataCallback(User user);
        void  deledata(User user);
    }
}

package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jh.rental.user.R;

import static com.jh.rental.user.other.apputilss.utilcode.utils.Utils.getContext;

/**
 * Created by 俊辉出行 on 2017/6/9.
 */

public class ChooseAdapter1 extends BaseAdapter {
    private final Context mContext;

    public ChooseAdapter1(Context context) {
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_text,null);
        }
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

}

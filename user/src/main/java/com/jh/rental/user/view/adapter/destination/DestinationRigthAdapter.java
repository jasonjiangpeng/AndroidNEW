package com.jh.rental.user.view.adapter.destination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.uiobj.ItemImgTv;
import com.jh.rental.user.presenter.photo.PhotoUtils;

import java.util.List;

/**
 * Created by 俊辉出行 on 2017/5/24.
 */

public class DestinationRigthAdapter extends BaseAdapter{
   private Context context;
  private List<ItemImgTv>  lv;
    public DestinationRigthAdapter(Context context, List<ItemImgTv>  lv) {
        this.context=context;
        this.lv=lv;
    }

    @Override
    public int getCount() {
        return lv.size();
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
        DestinationHolder  destinationHolder;
        if (convertView==null){
            destinationHolder=new DestinationHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.sub_item_destination_list,null);
            convertView.setTag(destinationHolder);
        }
        destinationHolder= (DestinationHolder) convertView.getTag();
        destinationHolder.img= (ImageView) convertView.findViewById(R.id.ivimg1);
        destinationHolder.tv= (TextView) convertView.findViewById(R.id.ivtv1);
//        Glide.with(context).load(lv.get(position).getUrl()).listener(getRequestListener(destinationHolder.img)).into(destinationHolder.img);
        PhotoUtils.isHasToImg(lv.get(position).getUrl(),destinationHolder.img);
        destinationHolder.tv.setText(lv.get(position).getName());
        return convertView;
    }
   class   DestinationHolder{
       ImageView img;
       TextView  tv;
   }
}

package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.ordermessage.GetCarPrice;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.popview.PopwindowUtils;

import java.util.ArrayList;
import java.util.List;


public class PopCarTypeView extends LinearLayout implements View.OnClickListener {
    public PopCarTypeView(Context context) {
        this(context, null);
    }
    public PopCarTypeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    ListView poplistcartype;
    List<GetCarPrice>  getCarPrices;
    private void init() {
        getCarPrices=new ArrayList<>();
        myAdapter=new MyAdapter();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_cartpye, this);
        poplistcartype = (ListView) inflate.findViewById(R.id.poplistcartype);
        poplistcartype.setAdapter(myAdapter);
        TextView  cancel_btn = (TextView) inflate.findViewById(R.id.cancel_btn);
        TextView  sure_btn = (TextView) inflate.findViewById(R.id.sure_btn);
        TextView   poptvs = (TextView) inflate.findViewById(R.id.poptvs);
        poptvs.setText("请选择车型");
        sure_btn.setVisibility(INVISIBLE);
        cancel_btn.setOnClickListener(this);
        sure_btn.setOnClickListener(this);

    }
    public List<GetCarPrice> getGetCarPrices(){
        return getCarPrices;
    }
    public void setGetCarPrices(List<GetCarPrice> getCarPrices) {
        this.getCarPrices = getCarPrices;
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.cancel_btn:
                PopwindowUtils.getPopwindowUtils().getPopupWindow().dismiss();
                break;

        }
    }

    public MyAdapter getMyAdapter() {
        return myAdapter;
    }
    public void setMyAdapter(MyAdapter myAdapter) {
        this.myAdapter = myAdapter;
    }
    private  MyAdapter  myAdapter;
    public class  MyAdapter  extends BaseAdapter{
        @Override
        public int getCount() {
            return getCarPrices.size();
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
            Myholder  myholder;
            if (convertView==null){
                myholder=new Myholder();
                convertView=LayoutInflater.from(getContext()).inflate(R.layout.sub_item_cartpye2,null);
                myholder.img= (ImageView) convertView.findViewById(R.id.carimg);
                myholder.carname= (TextView) convertView.findViewById(R.id.carname);
                myholder.cartitel= (TextView) convertView.findViewById(R.id.cartetle);
                myholder.carcounter= (TextView) convertView.findViewById(R.id.carcounter);
                myholder.carprice= (TextView) convertView.findViewById(R.id.carprice);
                myholder.carluggle= (TextView) convertView.findViewById(R.id.carluggle);
                myholder.carlayout= (LinearLayout) convertView.findViewById(R.id.carlayout);
                convertView.setTag(myholder);
            }
            myholder= (Myholder) convertView.getTag();
            myholder.carname.setText(getCarPrices.get(position).getModelNames()+"或同级别车型。");
          //  myholder.carname.setText(getCarPrices.get(position).getModelNames());
            myholder.carcounter.setText(getCarPrices.get(position).getCarModel().getSeatNum()+"人座");
            myholder.carluggle.setText(getCarPrices.get(position).getCarModel().getLuggleNum()+"行李");
            myholder.cartitel.setText(getCarPrices.get(position).getCarModel().getModel());
            myholder.carprice.setText("￥"+getCarPrices.get(position).getPrice()+"");
            myholder.carlayout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopwindowUtils.closePopWin();
                    String  string=getCarPrices.get(position).getCarModel().getModel();
                    Object   seatNum= getCarPrices.get(position).getCarModel().getLuggleNum();
                    int prince= (int) getCarPrices.get(position).getPrice();
                    OrderDetails.getOrderDetails().setSeatNum(Integer.valueOf(getCarPrices.get(position).getCarModel().getSeatNum()));
                    OrderDetails.getOrderDetails().setCarShowLuggmu(getCarPrices.get(position).getCarModel().getLuggleNum());
                    if(ApiConstants.OrderlTpye==2){
                        OrderDetails.getOrderDetails().setModelId(getCarPrices.get(position).getModelId());
                    }else {
                        PickupDetails.getOrderDetails().setModelId(getCarPrices.get(position).getModelId());
                    }
                    if (popTime!=null){
                        popTime.callBack(string, seatNum.toString(),prince);
                    }
                }
            });
            return convertView;
        }
    }
    public class Myholder{
        private LinearLayout  carlayout;
        private ImageView img;
        private TextView carname,cartitel,carcounter,carprice,carluggle;
    }
    public void setTipa( CarCallback popTime){
        this.popTime =  popTime;
    }

    private     CarCallback popTime;
    public interface  CarCallback{
        void  callBack(String name ,String s,int price);

    }

}

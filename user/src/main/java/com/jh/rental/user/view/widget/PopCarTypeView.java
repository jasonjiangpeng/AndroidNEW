package com.jh.rental.user.view.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import com.jh.rental.user.bean.ordermessage.GetCarPrice;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.internationnal.MakeAppointment_Activity;
import com.jh.rental.user.view.actitity.internationnal.TravelBooking_Activity;
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
        TextView  cancel_btn = (TextView) inflate.findViewById(R.id.cancel_btn);
        TextView  sure_btn = (TextView) inflate.findViewById(R.id.sure_btn);
        cancel_btn.setOnClickListener(this);
        sure_btn.setOnClickListener(this);
        poplistcartype.setAdapter(myAdapter);
       }
    public List<GetCarPrice> getGetCarPrices() {
        return getCarPrices;
    }
    public void setGetCarPrices(List<GetCarPrice> getCarPrices) {
        this.getCarPrices = getCarPrices;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.cancel_btn:
                PopwindowUtils.getPopwindowUtils().getPopupWindow().dismiss();
                break;
            case  R.id.sure_btn:
                if (popTime!=null){
                 popTime.next();
             }
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
        public View getView(int position, View convertView, ViewGroup parent) {
            Myholder  myholder;
            if (convertView==null){
                myholder=new Myholder();
                convertView=LayoutInflater.from(getContext()).inflate(R.layout.sub_item_cartpye,null);
                myholder.img= (ImageView) convertView.findViewById(R.id.carimg);
                myholder.carname= (TextView) convertView.findViewById(R.id.carname);
                myholder.cartitel= (TextView) convertView.findViewById(R.id.cartetle);
                myholder.carcounter= (TextView) convertView.findViewById(R.id.carcounter);
                myholder.carprice= (TextView) convertView.findViewById(R.id.carprice);
                myholder.carluggle= (TextView) convertView.findViewById(R.id.carluggle);
                convertView.setTag(myholder);
            }
            myholder= (Myholder) convertView.getTag();
            myholder.carname.setText(getCarPrices.get(position).getCarModel().getBrand());
            myholder.carcounter.setText(getCarPrices.get(position).getCarModel().getSeatNum()+"");
            myholder.cartitel.setText(getCarPrices.get(position).getCarModel().getRemark());
            myholder.carprice.setText(getCarPrices.get(position).getPrice()+"");
            return convertView;
        }

    }
public class Myholder{
         private ImageView img;
         private TextView carname,cartitel,carcounter,carprice,carluggle;

     }
    public void setTipa( PopTime popTime){
        this.popTime =  popTime;
    }

    PopTime popTime;
    public interface  PopTime{
        void  next();
        void sendNetRequet();
    }

}

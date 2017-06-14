package com.jh.rental.user.view.actitity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.ordermessage.GetCarPrice;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.actitity.internationnal.AddressLocationDes_Activity;
import com.jh.rental.user.view.actitity.internationnal.AddressLocation_Activity;
import com.jh.rental.user.view.actitity.internationnal.MakeAppointment_Activity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCarTypeView;
import com.jh.rental.user.view.widget.PopJourneyCounterView;
import com.jh.rental.user.view.widget.PopTimeView;

import java.util.ArrayList;

import static com.jh.rental.user.R.id.tv_delete1;
import static com.jh.rental.user.R.id.tv_delete2;


/**
 * Created by 骏辉出行 on 2017/5/26.
 * 专车接送
 */
public class DifineBus_Act extends TitelBarAcitvity implements View.OnClickListener {

    private LinearLayout mLlViapoint1;
    private LinearLayout mLlViapoint2;
    private LinearLayout mLlEnd;
    private TextView city,citysub,descity,tv_add;
    private  PopTimeView  popTimeView;
    private PopCarTypeView  popCarTypeView;
    private PopJourneyCounterView PopJourneyCounterView;
    @Override
    public void initParameter() {
        orderDetails = OrderDetails.getOrderDetails();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difinebus_activity);
        setMyTitel(BaseContext.getResValue(R.string.SpecialistCar));
        init();
    }


    private void init() {
        popTimeView=new PopTimeView(this);
        popCarTypeView=new PopCarTypeView(this);
        PopJourneyCounterView=new PopJourneyCounterView(this);
        LinearLayout difne_usecar= (LinearLayout) findViewById(R.id.difne_usecar);
        mLlViapoint1 = (LinearLayout) findViewById(R.id.ll_viapoint1);
        mLlViapoint2 = (LinearLayout) findViewById(R.id.ll_viapoint2);
        descity = (TextView) findViewById(R.id.descity);
        city = (TextView) findViewById(R.id.dftv1);
         tv_add= (TextView) findViewById(R.id.tv_add);
        citysub= (TextView) findViewById(R.id.citysub);
        TextView tv_delete1= (TextView) findViewById(R.id.tv_delete1);
        TextView tv_delete2= (TextView) findViewById(R.id.tv_delete2);
        LinearLayout ll_InputViaPoint= (LinearLayout) findViewById(R.id.ll_InputViaPoint);
        mLlEnd = (LinearLayout) findViewById(R.id.ll_end);
        difne_usecar.setOnClickListener(this);
        tv_add.setOnClickListener(this);
        ll_InputViaPoint.setOnClickListener(this);
        mLlEnd.setOnClickListener(this);
        tv_delete1.setOnClickListener(this);
        tv_delete2.setOnClickListener(this);
        mLlViapoint1.setOnClickListener(this);
        mLlViapoint2.setOnClickListener(this);
        popTimeView.setTipa(new PopTimeView.PopTime() {
            @Override
            public void next() {
                PopwindowUtils.getPopwindowUtils().show(PopJourneyCounterView, mLlEnd,DifineBus_Act.this);
            }
        });
        popCarTypeView.setTipa(new PopCarTypeView.PopTime() {
            @Override
            public void next() {
                   ActivityUtils.nextActivity(MakeAppointment_Activity.class);
            }

            @Override
            public void sendNetRequet() {

            }
        });
        PopJourneyCounterView.setTipa(new PopJourneyCounterView.PopTime() {
            @Override
            public void next(int man, int child) {
                PopwindowUtils.getPopwindowUtils().show(popCarTypeView, mLlEnd,DifineBus_Act.this);
            }


        });
    }

    int tag = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.difne_usecar:
                ActivityUtils.nextActivity(SearchDest_Act.class);
                break;
            case R.id.ll_InputViaPoint:
                if (OrderDetails.getOrderDetails().getCity()!=null){
                    ActivityUtils.nextActivity(AddressLocation_Activity.class,"addrsslocation",OrderDetails.getOrderDetails().getCity());
                }else SnakebarUtils.showToast("你没有选择城市");

                break;
            case R.id.ll_viapoint1:
                ActivityUtils.nextActivity(AddressLocationDes_Activity.class);
                break;
            case R.id.ll_viapoint2:
                ActivityUtils.nextActivity(AddressLocation_Activity.class);
                break;
            case R.id.ll_end:
                ActivityUtils.nextActivity(AddressLocation_Activity.class,"addrsslocations",OrderDetails.getOrderDetails().getCity());
                break;
            case R.id.tv_add:
                if ( tag == 0){
                    mLlViapoint1.setVisibility(View.VISIBLE);
                    tag = 1;
                }else {
                    mLlViapoint2.setVisibility(View.VISIBLE);
                }
                break;
            case tv_delete1:
                mLlViapoint1.setVisibility(View.GONE);
                tag = 0;
                break;
            case tv_delete2:
                mLlViapoint2.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onResume() {
        if (orderDetails.getCity()!=null){
            city.setText(OrderDetails.getOrderDetails().getCity());
        }
        if (orderDetails.getCitysub()!=null){
            citysub.setText(OrderDetails.getOrderDetails().getCitysub());
        }
        if (orderDetails.getDescity()!=null){
            descity.setText(OrderDetails.getOrderDetails().getDescity());
        }
        if (isTrue()){
            handler.sendEmptyMessage(5);
        }
        super.onResume();
    }
    public void showPop(){
         PopwindowUtils.getPopwindowUtils().show(popTimeView,tv_add,this);
    }

    public boolean isTrue(){
        if (orderDetails.getCity()!=null&&orderDetails.getDescity()!=null&&orderDetails.getCitysub()!=null){
            return true;
        }
        return false;
    }
    OrderDetails  orderDetails;

    @Override
    public void handleManage(int value) {
         if (value==5){ //弹出pop
            showPop();
             getCarPrice();
         }else if (value==10){
          popCarTypeView.getMyAdapter().notifyDataSetChanged();
         }
    }
     public  void getCarPrice(){
         HttpVolley.getInstance().postMapRequest(ApiPost.getCarPrice,getMap(cars,cars1),new NetJsonArraySucceed<>(GetCarPrice.class, new NetJsonArraySucceed.HolderData<GetCarPrice>() {
             @Override
             public void holdData(ArrayList<GetCarPrice> bean) {
                 popCarTypeView.setGetCarPrices(bean);
                 handler.sendEmptyMessage(10);
             }
         }),new NetError(this));
     }
     private  String [] cars={"cityId","sLng","sLat","eLng","eLat","pnum"};
     private  String [] cars1={"1","114.117661","22.541966","114.044963","22.528648","5"};

}

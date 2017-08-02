package com.jh.rental.user.view.fragment.internationnal;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.home.SearchDest_Act;
import com.jh.rental.user.view.actitity.internationnal.OrderDetails_Activity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopCanlenderView;
import com.jh.rental.user.view.widget.PopCarTypeCharter;
import com.jh.rental.user.view.widget.PopJourneyCounterView;
import com.jh.rental.user.view.widget.SelectBoxItemView;

/**
 * Created by 俊辉出行 on 2017/5/26.
 */

public class CharteredBu1 extends com.jh.rental.user.view.fragment.BaseFragment implements View.OnClickListener {
    public static String INDENT= "CharteredBu";
    private  PopCanlenderView popCanlenderView;
    private    PopJourneyCounterView  PopJourneyCounterView;
    @Override
    public View setView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_charteredbus, null);
        init(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
      if (OrderDetails.getOrderDetails().getCity()!=null){
         charterdbus_edt1.seteditText(OrderDetails.getOrderDetails().getCity());
     }
    }
    private SelectBoxItemView  charterdbus_edt1,charterdbus_counters,charterdbus_type,charterdbus_date;
    @Override
    protected void init(View view) {
        PopJourneyCounterView=new PopJourneyCounterView(getContext());
        popCanlenderView=new PopCanlenderView(getContext());
        popCarTypeView=new PopCarTypeCharter(getContext());
        popCarTypeView.setTipa(new PopCarTypeCharter.CarCallback() {
            @Override
            public void callBack(String name, String s, int price) {
                charterdbus_type.seteditText(name);
                OrderDetails.getOrderDetails().setPrice(price);
                OrderDetails.getOrderDetails().setLuggage(s);
                OrderDetails.getOrderDetails().setCar(name);
            }
        });
        popCanlenderView.setCallBack(new PopCanlenderView.CallBack() {
            @Override
            public void callback(String start, String end) {
                PopwindowUtils.closePopWin();
                String s=start+"-"+end;
                charterdbus_date.seteditText(s);
                String[] split = start.split("/");
                if (split.length==3){
              String  v=      split[0]+"年"+split[1]+"月"+split[2]+"日";
                    OrderDetails.getOrderDetails().setDate(v);
                }

            }
        });
        PopJourneyCounterView.setTipa(new PopJourneyCounterView.PopTime() {
            @Override
            public void next(int man, int child) {
                OrderDetails.getOrderDetails().setMan(String.valueOf(man));
                OrderDetails.getOrderDetails().setChild(String.valueOf(child));
                int c=man+child;
                charterdbus_counters.seteditText(String.valueOf(c));
                PopwindowUtils.closePopWin();
            }
        });
        Button button = (Button) view.findViewById(R.id.button);
         charterdbus_edt1 = (SelectBoxItemView) view.findViewById(R.id.charterdbus_edt1);
        SelectBoxItemView charterdbus_edt2 = (SelectBoxItemView) view.findViewById(R.id.charterdbus_edt2);
         charterdbus_counters = (SelectBoxItemView) view.findViewById(R.id.charterdbus_counters);
         charterdbus_type = (SelectBoxItemView) view.findViewById(R.id.charterdbus_type);
         charterdbus_date = (SelectBoxItemView) view.findViewById(R.id.charterdbus_date);
        charterdbus_edt1.setOnClickListener(this);
        charterdbus_counters.setOnClickListener(this);
        charterdbus_date.setOnClickListener(this);
        charterdbus_type.setOnClickListener(this);
        button.setOnClickListener(this);
        charterdbus_edt2.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Constant.COUPON = 0;
                ActivityUtils.nextActivity(OrderDetails_Activity.class,"indent",INDENT);
                break;
            case R.id.charterdbus_edt1:
                ActivityUtils.nextActivity(SearchDest_Act.class);
                break;
            case R.id.charterdbus_counters:
                PopwindowUtils.getPopwindowUtils().show(PopJourneyCounterView,v,this.getActivity());
                break;
            case R.id.charterdbus_date:
                PopwindowUtils.getPopwindowUtils().show(popCanlenderView,v,this.getActivity());
                break;
            case R.id.charterdbus_type:
                PopwindowUtils.getPopwindowUtils().show(popCarTypeView,v,this.getActivity());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        sendResponse();
                    }
                });
                break;
        }

    }
  public void sendResponse(){
   /*    getmap();
      Logger.soutMessage(OrderDetails.getOrderDetails().getId());
      HttpVolley.getInstance().postMapRequest(ApiPost.getCharteredCarPrice,getBaseMap(postMapRequest,OrderDetails.getOrderDetails().getId(),"4","1",charterdbus_counters.getEtTex()),new NetJsonArraySucceed<>(GetCharteredCarPrice.class, new NetJsonArraySucceed.HolderData<GetCharteredCarPrice>() {
          @Override
          public void holdData(ArrayList<GetCharteredCarPrice> bean) {
              popCarTypeView.setGetCarPrices(bean);

          }
      }));*/

  }
  void getmap(){
      if (charterdbus_counters.isnull()){
          SnakebarUtils.showToast("人数未选择");
          return;
      }

  }
  private PopCarTypeCharter popCarTypeView;
  private String[]  postMapRequest={"cityId","hourNum","useType","pnum"};

}

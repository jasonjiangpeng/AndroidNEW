package com.jh.rental.user.view.widget.pickdate;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.popview.PopwindowUtils;


/**
 * Created by 骏辉出行 on 2017/6/10.
 */

public class PopTimeChoose extends LinearLayout implements View.OnClickListener {
    public PopTimeChoose(Context context) {
        this(context,null);
    }
  private   PickViewm2 pickViewm1;
  private   PickViewm pickViewm5,pickViewm6;
    public PopTimeChoose(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View   inflate =  LayoutInflater.from(context).inflate(R.layout.pickdate, this);
         pickViewm1= (PickViewm2) inflate.findViewById(R.id.jason1);
         pickViewm5= (PickViewm) inflate.findViewById(R.id.jason5);
         pickViewm6= (PickViewm) inflate.findViewById(R.id.jason6);
        TextView cancel_btn= (TextView) inflate.findViewById(R.id.cancel_btn);
        TextView  sure_btn= (TextView) inflate.findViewById(R.id.sure_btn);
        TextView   poptvs = (TextView) inflate.findViewById(R.id.poptvs);
        poptvs.setText("请选择出发日期");
        cancel_btn.setOnClickListener(this);
        sure_btn.setOnClickListener(this);
        pickViewm1.startUi("s");
        pickViewm5.startUi(Type.HOUR,"点");
        pickViewm6.startUi(Type.TIME,"分");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.cancel_btn:
                PopwindowUtils.closePopWin();
                break;
            case  R.id.sure_btn:
                PopwindowUtils.closePopWin();
                String  time=pickViewm1.getTime()+" "+String.valueOf(pickViewm5.getTime())+":"+String.valueOf(pickViewm6.getTime());
                if (ApiConstants.OrderlTpye==1){
                    PickupDetails.getOrderDetails().setArriveTime(time);
                }else {
                    OrderDetails.getOrderDetails().setBegintime(time+":00");
                }
               callBack.getTime(time);
                break;
        }
    }

    public CallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    private CallBack callBack;
   public    interface  CallBack{
        void  getTime(String value);
    }

}

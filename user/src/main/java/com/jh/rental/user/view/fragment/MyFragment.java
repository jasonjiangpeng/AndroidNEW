package com.jh.rental.user.view.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.actitity.person.Collection_Activity;
import com.jh.rental.user.view.actitity.person.Coupons_Activity_;
import com.jh.rental.user.view.actitity.person.IdeaCallBack_Activity_;
import com.jh.rental.user.view.actitity.person.InvoiceService_Activity;
import com.jh.rental.user.view.actitity.person.PersonMessage_Activity_;
import com.jh.rental.user.view.actitity.person.ShareGift_Activity_;
import com.jh.rental.user.view.actitity.person.UserAgreement_Activity_;


public  class MyFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "MyFragment";

    @Override
    public View setView() {
        View view =LayoutInflater.from(getContext()).inflate(R.layout.text_show,null);
        init(view);
        return view;
    }

    protected void init(View view) {
         ImageView imageView = (ImageView) view.findViewById(R.id.my_personphtone);
         LinearLayout linearLayout1 = (LinearLayout) view.findViewById(R.id.myfragment1);
         LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.myfragment2);
         LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.myfragment3);
         LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.myfragment5);
         LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.myfragment6);
         LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.myfragment7);
         imageView.setOnClickListener(this);
         linearLayout1.setOnClickListener(this);
         linearLayout2.setOnClickListener(this);
         linearLayout3.setOnClickListener(this);
         linearLayout5.setOnClickListener(this);
         linearLayout6.setOnClickListener(this);
         linearLayout7.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_personphtone:
                ActivityUtils.nextActivity(PersonMessage_Activity_.class);
                break;
            case R.id.myfragment1:
                ActivityUtils.nextActivity(Collection_Activity.class);
                break;
            case R.id.myfragment2:
                ActivityUtils.nextActivity(Coupons_Activity_.class);
                break;
            case R.id.myfragment3:
                ActivityUtils.nextActivity(InvoiceService_Activity.class);
                break;
            case R.id.myfragment5:
                ActivityUtils.nextActivity(ShareGift_Activity_.class);
                break;
            case R.id.myfragment6:
                ActivityUtils.nextActivity(UserAgreement_Activity_.class);
                break;
            case R.id.myfragment7:
                ActivityUtils.nextActivity(IdeaCallBack_Activity_.class);
                break;
        }
    }
}

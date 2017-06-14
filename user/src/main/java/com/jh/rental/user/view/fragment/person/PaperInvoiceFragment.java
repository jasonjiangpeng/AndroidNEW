package com.jh.rental.user.view.fragment.person;

import android.view.LayoutInflater;
import android.view.View;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.actitity.person.MoreInformation_Activity_;
import com.jh.rental.user.view.fragment.BaseFragment;
import com.jh.rental.user.view.widget.InputBoxItemView;

/*
 *  @项目名：  AndroidApp 
 *  @包名：    com.jh.rental.user.view.fragment.person
 *  @文件名:   PaperInvoiceFragment
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/30 20:34
 *  @描述：    TODO
 */
public class PaperInvoiceFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "PaperInvoiceFragment";

    @Override
    public View setView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_paper_invoice, null);
        init(view);
        return view;
    }

    @Override
    protected void init(View view) {
        InputBoxItemView inputBox4 = (InputBoxItemView) view.findViewById(R.id.inputBox4);
        inputBox4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inputBox4:
                ActivityUtils.nextActivity(MoreInformation_Activity_.class);
                break;
        }
    }
}

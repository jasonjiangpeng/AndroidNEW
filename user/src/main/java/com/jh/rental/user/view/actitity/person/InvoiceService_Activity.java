package com.jh.rental.user.view.actitity.person;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.jh.rental.user.R;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.person.InvoicePagerAdapter;
import com.jh.rental.user.view.fragment.person.ElectronicFragment;
import com.jh.rental.user.view.fragment.person.PaperInvoiceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
public class InvoiceService_Activity extends TitelBarAcitvity
        implements RadioGroup.OnCheckedChangeListener {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoice_service_activity);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        initView();
    }

    private void initView() {
        mRadioGroup.setOnCheckedChangeListener(this);
        ElectronicFragment   weChatFragment   = new ElectronicFragment();
        PaperInvoiceFragment contactsFragment = new PaperInvoiceFragment();
        List<Fragment>       alFragment       = new ArrayList<>();
        alFragment.add(weChatFragment);
        alFragment.add(contactsFragment);
        //ViewPager设置适配器
        mViewPager.setAdapter(new InvoicePagerAdapter(getSupportFragmentManager(), alFragment));
        //ViewPager显示第一个Fragment
        mViewPager.setCurrentItem(0);
        //ViewPager页面切换监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRadioGroup.check(R.id.electronic);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.PaperInvoice);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.electronic:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.PaperInvoice:
                mViewPager.setCurrentItem(1);
                break;
        }
    }

}

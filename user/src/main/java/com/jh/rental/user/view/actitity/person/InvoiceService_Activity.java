package com.jh.rental.user.view.actitity.person;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.jh.rental.user.R;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.person.InvoicePagerAdapter;
import com.jh.rental.user.view.fragment.person.ElectronicFragment;
import com.jh.rental.user.view.fragment.person.PaperInvoiceFragment;
import com.jh.rental.user.view.widget.NoScrollViewPager;
import java.util.ArrayList;
import java.util.List;
import static com.jh.rental.user.R.id.viewpager;
/**
 * Created by 骏辉出行 on 2017/5/18.
 */
public class InvoiceService_Activity extends TitelBarAcitvity
        implements CompoundButton.OnCheckedChangeListener {

    private NoScrollViewPager mViewPager;
    private CheckBox checkBox1,checkBox2;
private Bitmap bitmap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoice_service_activity);
          mViewPager = (NoScrollViewPager) findViewById(viewpager);
        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.invoice_selector);
        initView();
    }

    private void initView() {
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        ElectronicFragment   weChatFragment   = new ElectronicFragment();
        PaperInvoiceFragment contactsFragment = new PaperInvoiceFragment();
        List<Fragment>       alFragment       = new ArrayList<>();
        alFragment.add(weChatFragment);
        alFragment.add(contactsFragment);
        mViewPager.setAdapter(new InvoicePagerAdapter(getSupportFragmentManager(), alFragment));
        mViewPager.setCurrentItem(0);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()){
            case R.id.checkbox1:
                if(isChecked) checkBox2.setChecked(false);
                else checkBox2.setChecked(true);
                checkBox1.setClickable(false);
                checkBox2.setClickable(true);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.checkbox2:
                if(isChecked) checkBox1.setChecked(false);
                else checkBox1.setChecked(true);
                checkBox1.setClickable(true);
                checkBox2.setClickable(false);
                mViewPager.setCurrentItem(1);
                break;
        }
    }
}

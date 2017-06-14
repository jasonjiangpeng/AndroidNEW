package com.jh.rental.user.view.actitity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public class CustomBus_Activity extends TitelBarAcitvity{
private     TabLayout  customtabs;
    private  ViewPager customviewpager;
    private List<String>  stringList=new ArrayList<>();
 //   FrameLayout customfragment;
  //  FragmentTransaction fragmentTransaction;

  //  Fragment fragmentById;
  private   List<View>  viewsList=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custombus_activity);
        // switchFragment(new TestA_fragment());
        View inflate = LayoutInflater.from(this).inflate(R.layout.passwordmodify_b_activity, null);
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.passwordmodify_a_activity, null);
        viewsList.add(inflate);
        viewsList.add(inflate2);
        stringList.add(BaseContext.getResValue(R.string.citycustombus));
        stringList.add(BaseContext.getResValue(R.string.crosscitycustombus));
        customtabs= (TabLayout) findViewById(R.id.customtabs);
        customviewpager= (ViewPager) findViewById(R.id.customviewpager);
        customviewpager.setAdapter(new CustomAdapter());
        customtabs.setTabMode(TabLayout.MODE_FIXED);
    /*    for (int i = 0; i < ; i++) {
            customtabs.addTab(customtabs.newTab().setText(stringList.get(0)));
            customtabs.addTab(customtabs.newTab().setText(stringList.get(1)));
        }*/


    //    customtabs.addTab(customtabs.newTab().setText("很不错"));
        customtabs.setupWithViewPager(customviewpager);
     }

    class CustomAdapter  extends PagerAdapter{

        @Override
        public int getCount() {
            return viewsList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            container.removeView(viewsList.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return stringList.get(position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
             container.addView(viewsList.get(position));
            return viewsList.get(position);
        }

    }
}

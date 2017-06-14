package com.jh.rental.user.view.actitity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.adapter.CustomBusAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public class CustomBus2_Activity extends TitelBarAcitvity{
private     TabLayout  customtabs;
    private  ViewPager customviewpager;
    private List<String>  stringList=new ArrayList<>();
 //   FrameLayout customfragment;
  //  FragmentTransaction fragmentTransaction;

  //  Fragment fragmentById;
    GridView gridview;
  private   List<View>  viewsList=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custombus_activity);
        // switchFragment(new TestA_fragment());
        initUi();
      /*    for (int i = 0; i < ; i++) {
            customtabs.addTab(customtabs.newTab().setText(stringList.get(0)));
            customtabs.addTab(customtabs.newTab().setText(stringList.get(1)));
        }*/

    //    customtabs.addTab(customtabs.newTab().setText("很不错"));

     }

    private void initUi() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.tokyoscenic_item , null);
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.tokyoscenic_item, null);
        gridview= (GridView) inflate.findViewById(R.id.gridview);
        viewsList.add(inflate);
        viewsList.add(inflate2);
        stringList.add(BaseContext.getResValue(R.string.citycustombus));
        stringList.add(BaseContext.getResValue(R.string.crosscitycustombus));
        gridview.setAdapter(new CustomBusAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Logger.showMessage("posio"+position);
            }
        });
        customtabs= (TabLayout) findViewById(R.id.customtabs);
        customviewpager= (ViewPager) findViewById(R.id.customviewpager);
        customviewpager.setAdapter(new CustomAdapter());

        customtabs.setTabMode(TabLayout.MODE_FIXED);
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

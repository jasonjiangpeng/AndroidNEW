package com.jh.rental.user.view.adapter.person;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/*
 *  @项目名：  AndroidApp
 *  @包名：    com.jh.rental.user.view.adapter.person
 *  @文件名:   InvoicePagerAdapter
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/30 20:37
 *  @描述：    TODO
 */
public class InvoicePagerAdapter extends FragmentPagerAdapter
{
    private List<Fragment> list;

    public InvoicePagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

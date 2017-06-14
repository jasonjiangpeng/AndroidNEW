package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.jh.rental.user.R;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.seachdestination_activity)
public class SeachDestination_Activity extends TitelBarAcitvity{
@ViewById(R.id.sd_destination_gridview)
 GridView seach_gridview;

 @AfterViews
  public void init(){
  MyAdapter  myAdapter =new MyAdapter();
   seach_gridview.setAdapter(myAdapter);
 }
 class MyAdapter extends BaseAdapter{

  @Override
  public int getCount() {
   return 0;
  }

  @Override
  public Object getItem(int position) {
   return null;
  }

  @Override
  public long getItemId(int position) {
   return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
   return null;
  }
 }
}

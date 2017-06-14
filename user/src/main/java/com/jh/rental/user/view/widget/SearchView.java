package com.jh.rental.user.view.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.RelativeLayout;

import com.jh.rental.user.R;


public class SearchView extends RelativeLayout {
   private ListView listView;
    public SearchView(Context context) {
        this(context,null);}

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sub_search, this);
   //     View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sub_search, this);
        EditText editText= (EditText) inflate.findViewById(R.id.et1);
        listView= (ListView) inflate.findViewById(R.id.list1);
        listView.setAdapter(new MySearchAdapter());
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                  if (s.length()>2){
                       listView.setVisibility(VISIBLE);
                  }else {
                      listView.setVisibility(GONE);
                  }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    class MySearchAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 5;
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

            if (convertView==null){
                convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_text,null);
            }
            return convertView;
        }
    }
}

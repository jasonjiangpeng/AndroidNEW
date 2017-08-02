package com.jh.rental.user.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.Logger;

/**
 * Created by 俊辉出行 on 2017/5/22.
 */

public abstract class BaseListFragment extends Fragment implements HomeFragment.DataCallBack {

    private View mView;
    private RecyclerView.Adapter mAdapter;
    public RecyclerView mRecyclerView;

//   private SwipeRefreshLayout swiperefresh;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_base_list, container,false);
        init();
        return mView;
    }

    protected void init() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);
        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Logger.newTestMessage("setOnTouchListenersetOnTouchListenersetOnTouchListenersetOnTouchListener");
                return false;
            }
        });
        mAdapter = getAdapter();
   //     mRecyclerView.setHasFixedSize(true);
  //      mRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager    mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        initRecyclerView();
    }

    public RecyclerView getmRecyclerView() {

        return mRecyclerView;
    }

    public void setmRecyclerView(RecyclerView mRecyclerView) {
        this.mRecyclerView = mRecyclerView;
    }

    protected void initRecyclerView() {

        mRecyclerView.setAdapter(mAdapter);
    }
    protected void initRecyclerView(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @NonNull
    public LinearLayoutManager getLayout() {
        return new GridLayoutManager(getContext(), 1);
    }

    public abstract RecyclerView.Adapter getAdapter();

    public Handler handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            myHanlder(msg.what);
        }
    };
    public void myHanlder(int value){
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        new Thread(){
            @Override
            public void run() {
                netRequest();
            }
        }.start();
    }
    public void netRequest(){

    }
}

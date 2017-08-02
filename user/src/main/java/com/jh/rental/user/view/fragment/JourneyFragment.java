package com.jh.rental.user.view.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jh.rental.user.MainActivity;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.order.FindOrdersbean;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.presenter.BaseListPresenter;
import com.jh.rental.user.presenter.impl.JourneyPresenterImpl;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.login.Login_Act_;
import com.jh.rental.user.view.adapter.JourneyAdapter;
import com.jh.rental.user.view.view.BaseListView;

import org.androidannotations.api.UiThreadExecutor;

import java.util.List;

public class JourneyFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseListView, View.OnClickListener {
    private List<FindOrdersbean.ListBean> listBeenl;
    private BaseListPresenter mJourneyListPresenter;
    JourneyAdapter journeyAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView recyclerView;
    LinearLayout mLoading;
    RelativeLayout mNotLogged, mNotTrip;
    Button mLogin, mVisitThe;

    @Override
    public View setView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_journey, null);
        init(view);
        return view;
    }

    @Override
    public void myHanlder(int value) {
    }

    @Override
    protected void init(View view) {
//        SnakebarUtils.showToast(ApiConstants.localCookie+"=="+ Constant.ACCOUNT+"=="+ Constant.PASSWORD);
        TextView tv = (TextView) view.findViewById(R.id.sub2_title);
        tv.setText(BaseContext.getResValue(R.string.myjoureny));
        recyclerView = (RecyclerView) view.findViewById(R.id.journey_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        mLoading = (LinearLayout) view.findViewById(R.id.loading);
        mNotLogged = (RelativeLayout) view.findViewById(R.id.NotLogged);
        mNotTrip = (RelativeLayout) view.findViewById(R.id.NotTrip);
        mLogin = (Button) view.findViewById(R.id.login);
        mVisitThe = (Button) view.findViewById(R.id.VisitThe);
        mJourneyListPresenter = new JourneyPresenterImpl(this);
        mLogin.setOnClickListener(this);
        mVisitThe.setOnClickListener(this);
        loading();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ApiConstants.localCookie == null) {
            mNotLogged.setVisibility(View.VISIBLE);
        }
        loading();
//        onDataLoaded();
    }

    private void loading() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mJourneyListPresenter.loadDataList();
        listBeenl = mJourneyListPresenter.getDataList();
        journeyAdapter = new JourneyAdapter(this, listBeenl);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(journeyAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {//滑动停止后才加载
                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                    if (lastVisibleItemPosition == mJourneyListPresenter.getDataList().size() - 1) {
                        mJourneyListPresenter.loadMoreData();
                    }
                }

            }
        });
    }

    @Override
    public void onRefresh() {
        mJourneyListPresenter.refresh();
    }

    @Override
    public void onDataLoaded() {
        mSwipeRefreshLayout.setRefreshing(false);
        journeyAdapter.notifyDataSetChanged();
//        SnakebarUtils.showToast(ApiConstants.localCookie);
        mNotLogged.setVisibility(View.GONE);
        UiThreadExecutor.runTask("", new Runnable() {
                    @Override
                    public void run() {
                        if (listBeenl.size() == 0) {
                            mLoading.setVisibility(View.GONE);
                            mNotTrip.setVisibility(View.VISIBLE);
                        }
                    }
                }
                , 600L);
    }

    @Override
    public void onDataLoadFailed(String error) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                ActivityUtils.nextActivity(Login_Act_.class);
                break;
            case R.id.VisitThe:
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.jump1();
                break;
        }

    }
}

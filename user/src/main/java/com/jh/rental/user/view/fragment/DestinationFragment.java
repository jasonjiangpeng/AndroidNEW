package com.jh.rental.user.view.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.location.GetPoiCityList;
import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;
import com.jh.rental.user.bean.uiobj.ItemImgTv;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.model.NetResponArrayData;
import com.jh.rental.user.model.homemodel.GetInterAreaAddressList;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.destination.Destination_Activity;
import com.jh.rental.user.view.adapter.ListAdapter;
import com.jh.rental.user.view.adapter.destination.DestinationLeftAdapter2;
import com.jh.rental.user.view.adapter.destination.DestinationRigthAdapter;
import com.jh.rental.user.view.widget.SearchView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DestinationFragment extends BaseFragment {
    private ArrayList<GetAreaAddressList> getAreaAddressList;

    @Override
    public void initParamer() {
        lvstr = new ArrayList<>();
        lvimg = new ArrayList<>();
        getAreaAddressList = new ArrayList<>();
    }

    @Override
    public void netRequest() {
        new GetInterAreaAddressList().netRequest(new NetResponArrayData<GetAreaAddressList>() {
            @Override
            public void responeData(List<GetAreaAddressList> values) {
                if (getAreaAddressList != null) {
                    getAreaAddressList.clear();
                }
                if (values != null && values.size() > 0) {
                    getAreaAddressList.addAll(values);
                    handler.sendEmptyMessage(0);
                }
            }
        });
    }

    public void dataHanlder() {
        if (getAreaAddressList != null) {
            if (lvstr != null) {
                lvstr.clear();
            }
            for (GetAreaAddressList s : getAreaAddressList) {
                lvstr.add(s.getAreaName());
            }
            List<GetAreaAddressList.AddressListBean> addressList = getAreaAddressList.get(0).getAddressList();
            if (addressList.size() > 0) {
                lvimg.clear();
            }
            for (GetAreaAddressList.AddressListBean na : addressList
                    ) {
                lvimg.add(new ItemImgTv(na.getImgUrl(), na.getName(), na.getId()));
            }
            handler.sendEmptyMessage(1);
        }
    }

    @Override
    public void myHanlder(int value) {
        if (value == 0) {
            dataHanlder();
        } else if (value == 1) {
            listadapter.notifyDataSetChanged();
            gridevieadapter.notifyDataSetChanged();
        }

    }

    @Override
    public View setView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_destination, null);
        init(view);
        return view;
    }

    private ListView rvLeftArea;
    private GridView destinationgridview;
    private DestinationLeftAdapter2 listadapter;
    private DestinationRigthAdapter gridevieadapter;
    private List<String> lvstr;
    private TextView mClues;
    private List<ItemImgTv> lvimg;
    private SearchView searchView;
    private ListView listView;
    private ListAdapter<GetPoiCityList> listListAdapter;
    private List<GetPoiCityList> getPoiCityLists;
    private LinearLayout mainlayout, mNotFind;

    public void initSearchView(View view) {
        mainlayout = (LinearLayout) view.findViewById(R.id.mainlayout);
        listView = (ListView) view.findViewById(R.id.list1);
        searchView = (SearchView) view.findViewById(R.id.searchView);
        searchView.setCancelGone();
        mNotFind = (LinearLayout) view.findViewById(R.id.NotFind);
        mClues = (TextView) view.findViewById(R.id.clues);
        searchView.setCallback(new SearchView.CallBack() {
            @Override
            public void callBack(String charsequence, int count) {
                if (charsequence.length() > 0) {
                    showList(charsequence);
                } else {
                    clearList();
                }
            }

            @Override
            public void cancle() {
                clearList();
            }
        });
        getPoiCityLists = new ArrayList<>();
        listListAdapter = new ListAdapter<>(getPoiCityLists);
        listListAdapter.setDataBack(new ListAdapter.DataBack() {
            @Override
            public void setValue(TextView tv, TextView tv2, int positon) {
                tv.setText(getPoiCityLists.get(positon).getCityName());
                tv2.setText(getPoiCityLists.get(positon).getNationName());
            }

            @Override
            public void dataChoose(int position) {
                /*SnakebarUtils.showToast("position=="+position);
                OrderDetails.setValue(getPoiCityLists.get(position).getCityId(), getPoiCityLists.get(position).getImgUrl());
                ActivityUtils.nextActivity(Destination_Activity.class, "cityName", getPoiCityLists.get(position).getCityName());*/
            }

        });
        listView.setAdapter(listListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SnakebarUtils.showToast("position=="+position);
                OrderDetails.setValue(getPoiCityLists.get(position).getCityId(), getPoiCityLists.get(position).getImgUrl());
                ActivityUtils.nextActivity(Destination_Activity.class, "cityName", getPoiCityLists.get(position).getCityName());
                searchView.empty();
            }
        });
    }

    /*  public void saveToDb(HistoryCity dbHistoryCity){
          dbFlight.replaceLove(dbHistoryCity);
      }*/
    @Override
    protected void init(View view) {
        initSearchView(view);
        TextView sub_goback = (TextView) view.findViewById(R.id.sub_goback);
        sub_goback.setVisibility(View.GONE);
        gridevieadapter = new DestinationRigthAdapter(BaseApplication.currentActivity(), lvimg);
        listadapter = new DestinationLeftAdapter2(BaseApplication.currentActivity(), lvstr);
        listadapter.setChangeData(new DestinationLeftAdapter2.ChangeData() {
            @Override
            public void changeData(int value) {
                List<GetAreaAddressList.AddressListBean> addressList = getAreaAddressList.get(value).getAddressList();
                if (addressList.size() > 0) {
                    lvimg.clear();
                }
                for (GetAreaAddressList.AddressListBean na : addressList
                        ) {
                    lvimg.add(new ItemImgTv(na.getIndexImgUrl(), na.getName(), na.getId()));
                }
                handler.sendEmptyMessage(1);
            }
        });
        TextView tv = (TextView) view.findViewById(R.id.sub_title);
        tv.setText(BaseContext.getResValue(R.string.destination));
        rvLeftArea = (ListView) view.findViewById(R.id.listb1);
        destinationgridview = (GridView) view.findViewById(R.id.listb2);
        rvLeftArea.setAdapter(listadapter);
        destinationgridview.setAdapter(gridevieadapter);
        destinationgridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = lvimg.get(position).getName();
                OrderDetails.setValue(lvimg.get(position).getId(), lvimg.get(position).getUrl());
                ActivityUtils.nextActivity(Destination_Activity.class, "cityName", name);
            }
        });
    }

    public void showList(final String s) {
        String s1 = GsonUtlis.stringToJson(new Value(s));
        Logger.soutMessage(s1);
        JsonArrayRequest jjs = new JsonArrayRequest(Request.Method.POST, ApiPost.getPoiCityList, s1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Logger.soutMessage(response);
//                getPoiCityLists.clear();
                getPoiCityLists.addAll(GsonUtlis.getJsonArray(response.toString(), GetPoiCityList.class));
                mainlayout.setVisibility(View.GONE);
                if (getPoiCityLists.size() > 0) {
                    mNotFind.setVisibility(View.GONE);
                    listListAdapter.notifyDataSetChanged();
                } else {
                    mNotFind.setVisibility(View.VISIBLE);
                    mClues.setText(BaseContext.getResValue(R.string.UrbanSearch1) + s + BaseContext.getResValue(R.string.UrbanSearch2));
                }
            }
        }, null);
        HttpVolley.getInstance().getRequestQueue().add(jjs);
    }

    public void clearList() {
        mNotFind.setVisibility(View.GONE);
        mainlayout.setVisibility(View.VISIBLE);
        getPoiCityLists.clear();
        listListAdapter.notifyDataSetChanged();
    }

    private class Value {
        private String query;

        public Value(String query) {
            this.query = query;
        }
    }
}

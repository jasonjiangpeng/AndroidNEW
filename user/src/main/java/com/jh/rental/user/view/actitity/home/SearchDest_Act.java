package com.jh.rental.user.view.actitity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.location.GetPoiCityList;
import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.db.flight.DBHistoryCity;
import com.jh.rental.user.db.flight.HistoryCity;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.model.NetResponArrayData;
import com.jh.rental.user.model.homemodel.GetInterAreaAddressList;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.BaseActvity;
import com.jh.rental.user.view.actitity.destination.Destination_Activity;
import com.jh.rental.user.view.adapter.ListAdapter;
import com.jh.rental.user.view.adapter.destination.DestinationLeftAdapter2;
import com.jh.rental.user.view.adapter.destination.HistoryAddressAdapter2;
import com.jh.rental.user.view.adapter.destination.SearchDesRigthAdapter;
import com.jh.rental.user.view.widget.MyLayoutManager;
import com.jh.rental.user.view.widget.SearchView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/1.
 */

public class SearchDest_Act extends BaseActvity implements View.OnClickListener {
    private List<String> list;
    private List<GetAreaAddressList.AddressListBean> lists;
    private DBHistoryCity dbFlight;
    private List<GetAreaAddressList> getAreaAddressList;
    private ListView listView;
    private ListAdapter<GetPoiCityList> listListAdapter;
    private List<GetPoiCityList> getPoiCityLists;
    private ListView sd_left_area;
    private GridView gridView2;
    private LinearLayout mSearchdes_layout, mainlayout, mNotFind;
    private DestinationLeftAdapter2 destinationLeftAdapter2;
    private SearchDesRigthAdapter searchDesRigthAdapter;
    private SearchView searchview;
    private List<HistoryCity> historyCities;
    private TextView mClues;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        list = new ArrayList<>();
        lists = new ArrayList<>();
        historyCities = new ArrayList<>();
        dbFlight = new DBHistoryCity();
        historyCities = dbFlight.qureyAllData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seachdestination_activity);
        initUI();
        initSearch();
    }

    public void saveToDb(HistoryCity dbHistoryCity) {
        dbFlight.replaceLove(dbHistoryCity);
    }

    public void initSearch() {
        searchview.setCallback(new SearchView.CallBack() {
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
                /*if (ApiConstants.searchChoose == 2) {
                    OrderDetails.getOrderDetails().setCity(getPoiCityLists.get(position).getCityName());
                    OrderDetails.getOrderDetails().setId(getPoiCityLists.get(position).getCityId());
                    BaseApplication.finishActivity();
                } else {
                    ActivityUtils.nextActivity(Destination_Activity.class, "cityName", getPoiCityLists.get(position).getCityName());
                }
                HistoryCity historyCity = new HistoryCity(System.currentTimeMillis(),
                        getPoiCityLists.get(position).getCityId(), getPoiCityLists.get(position).getCityName(),
                        getPoiCityLists.get(position).getNationName(), String.valueOf(getPoiCityLists.get(position).getGdLng())
                        , String.valueOf(getPoiCityLists.get(position).getGdLat()));
                saveToDb(historyCity);*/
            }

        });
        listView.setAdapter(listListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (ApiConstants.searchChoose == 2) {
                    OrderDetails.getOrderDetails().setCity(getPoiCityLists.get(position).getCityName());
                    OrderDetails.getOrderDetails().setId(getPoiCityLists.get(position).getCityId());
                    BaseApplication.finishActivity();
                } else {
                    ActivityUtils.nextActivity(Destination_Activity.class, "cityName", getPoiCityLists.get(position).getCityName());
                }
                HistoryCity historyCity = new HistoryCity(System.currentTimeMillis(),
                        getPoiCityLists.get(position).getCityId(), getPoiCityLists.get(position).getCityName(),
                        getPoiCityLists.get(position).getNationName(), String.valueOf(getPoiCityLists.get(position).getGdLng())
                        , String.valueOf(getPoiCityLists.get(position).getGdLat()));
                saveToDb(historyCity);
            }
        });
    }

    RecyclerView history;

    private void initUI() {
        searchDesRigthAdapter = new SearchDesRigthAdapter(getApplicationContext(), lists);
        destinationLeftAdapter2 = new DestinationLeftAdapter2(getApplicationContext(), list);
        mSearchdes_layout = (LinearLayout) findViewById(R.id.searchdes_layout);
        gridView2 = (GridView) findViewById(R.id.sd_destination_gridview);
        sd_left_area = (ListView) findViewById(R.id.sd_left_area);
        mainlayout = (LinearLayout) findViewById(R.id.mainlayout);
        mNotFind = (LinearLayout) findViewById(R.id.NotFind);
        searchview = (SearchView) findViewById(R.id.searchview);
        history = (RecyclerView) findViewById(R.id.history);
        listView = (ListView) findViewById(R.id.list1);
        mClues = (TextView) findViewById(R.id.clues);
        sd_left_area.setAdapter(destinationLeftAdapter2);
        destinationLeftAdapter2.setChangeData(new DestinationLeftAdapter2.ChangeData() {
            @Override
            public void changeData(int value) {
                if (value >= getAreaAddressList.size()) {
                    return;
                }
                lists.clear();
                lists.addAll(getAreaAddressList.get(value).getAddressList());
                handler.sendEmptyMessage(2);
            }
        });
        ViewGroup.LayoutParams params = mSearchdes_layout.getLayoutParams();
        if (historyCities.size() > 0) {
            if (Constant.NEWLINE == 1) {
                params.height = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 115, getResources().getDisplayMetrics()));
            } else {
                params.height = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 75, getResources().getDisplayMetrics()));
            }
        } else {
            params.height = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics()));
        }
        mSearchdes_layout.setLayoutParams(params);
        history.setHasFixedSize(true);
        history.setLayoutManager(new MyLayoutManager());
        history.setAdapter(new HistoryAddressAdapter2(getApplicationContext(), historyCities));
        gridView2.setAdapter(searchDesRigthAdapter);

    }

    @Override
    public void onClick(View v) {
//        searchdes_layout.setVisibility(View.GONE);
    }

    @Override
    public void sendRequestData() {
        new GetInterAreaAddressList().netRequest(new NetResponArrayData<GetAreaAddressList>() {
            @Override
            public void responeData(List<GetAreaAddressList> values) {
                if (values.size() < 1) {
                    return;
                }
                getAreaAddressList.clear();
                getAreaAddressList.addAll(values);
                list.clear();
                for (GetAreaAddressList getArea : getAreaAddressList) {
                    list.add(getArea.getAreaName());
                }
                lists.clear();
                lists.addAll(getAreaAddressList.get(0).getAddressList());
                handler.sendEmptyMessageDelayed(0, 15);
            }
        });

    }

    @Override
    public void initParameter() {
        if (getAreaAddressList == null) {
            getAreaAddressList = new ArrayList<>();
        }
        if (list == null) {
            list = new ArrayList<String>();
        }
        if (lists == null) {
            lists = new ArrayList<>();
        }
    }

    @Override
    public void handleManage(int value) {

        if (value == 2) {
            searchDesRigthAdapter.notifyDataSetChanged();
        } else {
            if (destinationLeftAdapter2 == null) {
                handler.sendEmptyMessageDelayed(0, 15);
            } else {
                searchDesRigthAdapter.notifyDataSetChanged();
                destinationLeftAdapter2.notifyDataSetChanged();
            }

        }
    }

    public void showList(final String s) {
        mainlayout.setVisibility(View.GONE);
        String s1 = GsonUtlis.stringToJson(new Value(s));
        Logger.soutMessage(s1);
        JsonArrayRequest jjs = new JsonArrayRequest(Request.Method.POST, ApiPost.getPoiCityList, s1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Logger.soutMessage(response);
                getPoiCityLists.clear();
                getPoiCityLists.addAll(GsonUtlis.getJsonArray(response.toString(), GetPoiCityList.class));
                if (getPoiCityLists.size()>0){
                    mNotFind.setVisibility(View.GONE);
                    listListAdapter.notifyDataSetChanged();
                }else {
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
        String query;

        public Value(String query) {
            this.query = query;
        }
    }
}

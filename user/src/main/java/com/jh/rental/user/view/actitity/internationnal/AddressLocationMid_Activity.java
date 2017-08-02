package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.CarPriceSend;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.location.GetGdList;
import com.jh.rental.user.bean.location.GetGooglePointByAdrBean;
import com.jh.rental.user.bean.location.QueryGdList;
import com.jh.rental.user.bean.location.WayPointOne;
import com.jh.rental.user.bean.location.WayPointTwo;
import com.jh.rental.user.bean.ordermessage.GetHotAddressList;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.model.NetResponArrayData;
import com.jh.rental.user.model.NetResponData;
import com.jh.rental.user.model.homemodel.HotAddressList;
import com.jh.rental.user.model.send.GetGooglePointByAdr;
import com.jh.rental.user.model.send.GgPoiPath;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.ListAdapter;
import com.jh.rental.user.view.widget.SearchView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class AddressLocationMid_Activity extends TitelBarAcitvity {
    private TextView tv1;
    private List<GetHotAddressList> hotAddresses;
    private SearchView searchview;
    private int waypoint = 0;
    private GetGooglePointByAdrBean getgooglePoint;
    private boolean isStartCity = true;

    @Override
    public void initParameter() {
        hotAddresses = new ArrayList<>();
        if (ApiConstants.OrderlTpye == 2) {
            sendRequestData(OrderDetails.getOrderDetails().getCity());
        } else {
            sendRequestData(PickupDetails.getOrderDetails().getArriveName());
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new GetGooglePointByAdr().reqNet(ApiConstants.queryCity, new NetResponData<GetGooglePointByAdrBean>() {
            @Override
            public void responeData(GetGooglePointByAdrBean object) {
                if (object.getCountryType()!=null){
                    getgooglePoint=object;
                }
            }
        });
        waypoint = getIntent().getIntExtra("AddressLocationMid_Activity", 0);
        setContentView(R.layout.addresslocationmid_activity);
        initView();
        initSearch();
    }

    public void switchCity(View view) {
        if (ApiConstants.OrderlTpye == 2) {
            if (OrderDetails.getOrderDetails().getId().equals(OrderDetails.getOrderDetails().getEndCityID())) {
                return;
            }
        } else {
            if (CarPriceSend.getCarPriceSend().getEndCityName().equals(PickupDetails.getOrderDetails().getArriveName())) {
                return;
            }
        }
        if (isStartCity) {
            isStartCity = false;
            if (ApiConstants.OrderlTpye == 2) {
                tv1.setText(OrderDetails.getOrderDetails().getDescity());
                sendRequestData(OrderDetails.getOrderDetails().getDescity());
            } else {
                tv1.setText(CarPriceSend.getCarPriceSend().getEndCityName());
                sendRequestData(CarPriceSend.getCarPriceSend().getEndCityName());
            }

        } else {
            isStartCity = true;
            if (ApiConstants.OrderlTpye == 2) {
                tv1.setText(OrderDetails.getOrderDetails().getCity());
                sendRequestData(OrderDetails.getOrderDetails().getCity());
            } else {
                tv1.setText(PickupDetails.getOrderDetails().getArriveName());
                sendRequestData(PickupDetails.getOrderDetails().getArriveName());
            }

        }

    }

    private void initView() {
        RecyclerView rlAddress = (RecyclerView) findViewById(R.id.rl_address);
        tv1 = (TextView) findViewById(R.id.addresstv1);
        if (ApiConstants.OrderlTpye == 2) {
            tv1.setText(OrderDetails.getOrderDetails().getCity());

        } else {
            tv1.setText(PickupDetails.getOrderDetails().getArriveName());
        }

        addressLocationAdapter = new AddressLocationAdapter();
        rlAddress.setLayoutManager(new LinearLayoutManager(this));
        rlAddress.setAdapter(addressLocationAdapter);
    }

    AddressLocationAdapter addressLocationAdapter;

    class AddressLocationAdapter extends RecyclerView.Adapter<AddressLocationHolder> {
        @Override
        public AddressLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            AddressLocationHolder jourineyHolder = new AddressLocationHolder(
                    LayoutInflater.from(AddressLocationMid_Activity.this).inflate(R.layout.sub_item_address, parent, false));
            return jourineyHolder;
        }

        @Override
        public void onBindViewHolder(AddressLocationHolder holder, final int position) {
            holder.addressa1.setText(hotAddresses.get(position).getAdrName());
            holder.addressa2.setText(hotAddresses.get(position).getAddress());
            holder.addresslv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (waypoint == 1) {
                    //    WayPointOne.creOredeDetails();
                        Logger.soutMessage(tv1.getText().toString() + hotAddresses.get(position).getAdrName());
                        WayPointOne.getOrderDetails().setCityName(tv1.getText().toString());
                        WayPointOne.getOrderDetails().setCityAdress(hotAddresses.get(position).getAddress());
                        WayPointOne.getOrderDetails().setAdrName(hotAddresses.get(position).getAdrName());
                        WayPointOne.getOrderDetails().setLatitudeGoogle(hotAddresses.get(position).getGdLat());
                        WayPointOne.getOrderDetails().setLongitudeGoogle(hotAddresses.get(position).getGdLng());
                    } else if (waypoint == 2) {
               //         WayPointTwo.creOredeDetails();
                        WayPointTwo.getOrderDetails().setCityName(tv1.getText().toString());
                        WayPointTwo.getOrderDetails().setAdrName(hotAddresses.get(position).getAdrName());
                        WayPointTwo.getOrderDetails().setCityAdress(hotAddresses.get(position).getAddress());
                        WayPointTwo.getOrderDetails().setLatitudeGoogle(hotAddresses.get(position).getGdLat());
                        WayPointTwo.getOrderDetails().setLongitudeGoogle(hotAddresses.get(position).getGdLng());
                    }
                    BaseApplication.finishActivity();
                }
            });

        }

        @Override
        public int getItemCount() {
            return hotAddresses.size();
        }
    }

    class AddressLocationHolder extends RecyclerView.ViewHolder {
        private LinearLayout addresslv;
        private TextView addressa1, addressa2;

        public AddressLocationHolder(View itemView) {
            super(itemView);
            addressa1 = (TextView) itemView.findViewById(R.id.addressa1);
            addressa2 = (TextView) itemView.findViewById(R.id.addressa2);
            addresslv = (LinearLayout) itemView.findViewById(R.id.addresslv);
        }
    }

    public void sendRequestData(String cityid) {
        new HotAddressList().netRequest(new NetResponArrayData<GetHotAddressList>() {
            @Override
            public void responeData(List<GetHotAddressList> values) {
                if (values.size() < 1) {
                    return;
                }
                hotAddresses.clear();
                hotAddresses.addAll(values);
                handler.sendEmptyMessage(0);
            }
        }, cityid);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private ListView listView;
    private ListAdapter<GetGdList> listListAdapter;
    private List<GetGdList> getPoiCityLists;
    private LinearLayout mainlayout;

    public void initSearch() {
        mainlayout = (LinearLayout) findViewById(R.id.mainlayout);
        searchview = (SearchView) findViewById(R.id.searchview);
        searchview.setCallback(new SearchView.CallBack() {
            @Override
            public void callBack(String charsequence, int count) {
                if (charsequence.length() > 0) {
                    mainlayout.setVisibility(View.GONE);
                    if (getgooglePoint==null){
                        return;
                    }
                    Logger.soutTestMessage(getgooglePoint.getCountryType());
                    if (getgooglePoint.getCountryType().equals("1")){
                        showList(charsequence);
                    }else {
                        showGdList(charsequence);
                    }
                } else {
                    clearList();
                }
            }
            private void showGdList(String charsequence) {
                new GgPoiPath().reqNets(getgooglePoint.getLng(), getgooglePoint.getLat(), charsequence, new NetResponArrayData<GetGdList>() {
                    @Override
                    public void responeData(List<GetGdList> values) {
                        getPoiCityLists.clear();
                        getPoiCityLists.addAll(values);
                        listListAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void cancle() {
                clearList();
            }
        });
        listView = (ListView) findViewById(R.id.list2);
        getPoiCityLists = new ArrayList<>();
        listListAdapter = new ListAdapter<>(getPoiCityLists);
        listListAdapter.setDataBack(new ListAdapter.DataBack() {
            @Override
            public void setValue(TextView tv, TextView tv2, int positon) {
                tv.setText(getPoiCityLists.get(positon).getName());
                tv2.setText(getPoiCityLists.get(positon).getFormatted_address());
            }

            @Override
            public void dataChoose(int position) {
                /*if (waypoint == 1) {
                    WayPointOne.getOrderDetails().setCityName(tv1.getText().toString());
                    WayPointOne.getOrderDetails().setAdrName(getPoiCityLists.get(position).getName());
                    WayPointOne.getOrderDetails().setCityAdress(getPoiCityLists.get(position).getFormatted_address());
                    WayPointOne.getOrderDetails().setLatitudeGoogle(getPoiCityLists.get(position).getLat());
                    WayPointOne.getOrderDetails().setLongitudeGoogle(getPoiCityLists.get(position).getLng());
                } else if (waypoint == 2) {
                    WayPointTwo.getOrderDetails().setCityName(tv1.getText().toString());
                    WayPointTwo.getOrderDetails().setAdrName(getPoiCityLists.get(position).getName());
                    WayPointTwo.getOrderDetails().setCityAdress(getPoiCityLists.get(position).getFormatted_address());
                    WayPointTwo.getOrderDetails().setLatitudeGoogle(getPoiCityLists.get(position).getLat());
                    WayPointTwo.getOrderDetails().setLongitudeGoogle(getPoiCityLists.get(position).getLng());
                }
                BaseApplication.finishActivity();*/
            }

        });
        listView.setAdapter(listListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SnakebarUtils.showToast("position=="+position);
                if (waypoint == 1) {
                    WayPointOne.getOrderDetails().setCityName(tv1.getText().toString());
                    WayPointOne.getOrderDetails().setAdrName(getPoiCityLists.get(position).getName());
                    WayPointOne.getOrderDetails().setCityAdress(getPoiCityLists.get(position).getFormatted_address());
                    WayPointOne.getOrderDetails().setLatitudeGoogle(getPoiCityLists.get(position).getLat());
                    WayPointOne.getOrderDetails().setLongitudeGoogle(getPoiCityLists.get(position).getLng());
                } else if (waypoint == 2) {
                    WayPointTwo.getOrderDetails().setCityName(tv1.getText().toString());
                    WayPointTwo.getOrderDetails().setAdrName(getPoiCityLists.get(position).getName());
                    WayPointTwo.getOrderDetails().setCityAdress(getPoiCityLists.get(position).getFormatted_address());
                    WayPointTwo.getOrderDetails().setLatitudeGoogle(getPoiCityLists.get(position).getLat());
                    WayPointTwo.getOrderDetails().setLongitudeGoogle(getPoiCityLists.get(position).getLng());
                }
                BaseApplication.finishActivity();
            }
        });
    }

    public void showList(String s) {
        String s1 = GsonUtlis.stringToJson(new QueryGdList(s, tv1.getText().toString()));
        Logger.soutMessage(s1);
        JsonArrayRequest jjs = new JsonArrayRequest(Request.Method.POST, ApiPost.getGdPoiList, s1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                getPoiCityLists.clear();
                ArrayList<GetGdList> jsonArray = null;
                try {
                    jsonArray = GsonUtlis.getJsonArray(response.toString(), GetGdList.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (jsonArray != null && jsonArray.size() > 0) {
                    getPoiCityLists.addAll(jsonArray);
                    mainlayout.setVisibility(View.GONE);
                    listListAdapter.notifyDataSetChanged();
                }

            }
        }, null);
        HttpVolley.getInstance().getRequestQueue().add(jjs);
    }

    public void clearList() {
        mainlayout.setVisibility(View.VISIBLE);
        getPoiCityLists.clear();
        listListAdapter.notifyDataSetChanged();
    }

    @Override
    public void handleManage(int value) {
        addressLocationAdapter.notifyDataSetChanged();
    }

}

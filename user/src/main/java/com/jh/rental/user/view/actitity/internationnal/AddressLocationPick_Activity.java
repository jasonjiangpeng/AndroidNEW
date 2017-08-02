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
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.CarPriceSend;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.PickupDetails;
import com.jh.rental.user.bean.location.GetGdList;
import com.jh.rental.user.bean.location.GetGooglePointByAdrBean;
import com.jh.rental.user.bean.location.QueryGdList;
import com.jh.rental.user.bean.ordermessage.GetHotAddressList;
import com.jh.rental.user.bean.pickup.GetGDAddressList;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.model.NetResponArrayData;
import com.jh.rental.user.model.NetResponData;
import com.jh.rental.user.model.homemodel.HotAddressList;
import com.jh.rental.user.model.send.GetGooglePointByAdr;
import com.jh.rental.user.model.send.GgPoiPath;
import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.ListAdapter;
import com.jh.rental.user.view.widget.SearchView;
import com.jh.rental.user.view.widget.jason.RecyleViewItem;

import org.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class AddressLocationPick_Activity extends TitelBarAcitvity implements View.OnClickListener {
    private TextView tv2;
    private List<String> values;
    private GetGooglePointByAdrBean getgooglePoint;
    private int comeValue = 0;
    private ArrayList<GetHotAddressList> getHotAddressLists;
    private TextView hotcity;

    @Override
    public void initParameter() {
        getHotAddressLists = new ArrayList<>();
        values = new ArrayList<>();

    }

    public void reqGoogle() {
        new GetGooglePointByAdr().reqNet(ApiConstants.queryCity, new NetResponData<GetGooglePointByAdrBean>() {
            @Override
            public void responeData(GetGooglePointByAdrBean object) {
                getgooglePoint = object;
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reqGoogle();
        sendRequestDatas();
        comeValue = getIntent().getIntExtra("AddressLocationPick_Activity", 0);
        setContentView(R.layout.addresslocationpick_activity);
        if (ApiConstants.OrderlTpye == 0 || ApiConstants.OrderlTpye == 1) {
            OrderDetails.getOrderDetails().setCity(PickupDetails.getOrderDetails().getArriveName());
        }
        getHotAddressList(OrderDetails.getOrderDetails().getCity());
        initView();
        initSearch();
    }

    private void initView() {
        RecyclerView rlAddress = (RecyclerView) findViewById(R.id.rl_address);
        recyleViewItem = (RecyleViewItem) findViewById(R.id.recycler_view);
        hotcity = (TextView) findViewById(R.id.hotcity);
        recyleViewItem.setCallBack(new RecyleViewItem.CallBack() {
            @Override
            public void CallBack(String s) {
                Logger.soutMessage(s);
                tv2.setText(s);
                judgeRecyleViewGone();
                getHotAddressList(s);
            }
        });
        recyleViewItem.init();
        tv2 = (TextView) findViewById(R.id.addresstv2);
        tv2.setOnClickListener(this);
        tv2.setVisibility(View.VISIBLE);
        tv2.setText(OrderDetails.getOrderDetails().getCity());
        addressLocationAdapter = new AddressLocationAdapter();
        rlAddress.setLayoutManager(new LinearLayoutManager(this));
        rlAddress.setAdapter(addressLocationAdapter);
    }

    private AddressLocationAdapter addressLocationAdapter;
    private RecyleViewItem recyleViewItem;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addresstv2:
                judgeRecyleViewGone();
                break;
        }
    }

    /*判断是否显示*/
    public void judgeRecyleViewGone() {
        if (recyleViewItem.getVisibility() == View.GONE) {
            //   hotcity.setGravity(Gravity.CENTER);
            hotcity.setText("热门城市");
            recyleViewItem.setVisibility(View.VISIBLE);
            try {
                recyleViewItem.getData();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if (recyleViewItem.getVisibility() == View.VISIBLE) {
            //     hotcity.setGravity(Gravity.NO_GRAVITY);
            hotcity.setText("热门地标");
            recyleViewItem.setVisibility(View.GONE);
        }
    }

    class AddressLocationAdapter extends RecyclerView.Adapter<AddressLocationHolder> {
        @Override
        public AddressLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            AddressLocationHolder jourineyHolder = new AddressLocationHolder(
                    LayoutInflater.from(AddressLocationPick_Activity.this).inflate(R.layout.sub_item_address, parent, false));
            return jourineyHolder;
        }

        @Override
        public void onBindViewHolder(AddressLocationHolder holder, final int position) {
            holder.addressa1.setText(getHotAddressLists.get(position).getAdrName());
            holder.addressa2.setText(getHotAddressLists.get(position).getAddress());
            holder.addresslv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseApplication.finishActivity();
                    if (comeValue == 99) {
                        OrderDetails.getOrderDetails().setDescity(tv2.getText().toString());
                        OrderDetails.getOrderDetails().setEndCityID(getHotAddressLists.get(position).getCityId());
                        OrderDetails.getOrderDetails().setEndLag(getHotAddressLists.get(position).getGdLat());
                        OrderDetails.getOrderDetails().setEndLng(getHotAddressLists.get(position).getGdLng());
                        OrderDetails.getOrderDetails().setEndAdrName(getHotAddressLists.get(position).getAdrName());
                        OrderDetails.getOrderDetails().setEndAddress(getHotAddressLists.get(position).getAddress());
                    } else if (comeValue == 79) {
                        String value = tv2.getText().toString() + "·" + getHotAddressLists.get(position).getAdrName();
                        OrderDetails.getOrderDetails().setWaycity1(value);
                    } else if (comeValue == 80) {
                        String value = tv2.getText().toString() + "·" + getHotAddressLists.get(position).getAdrName();
                        OrderDetails.getOrderDetails().setWaycity2(value);
                    } else {
                        CarPriceSend.getCarPriceSend().setEndCityName(tv2.getText().toString());
                        CarPriceSend.getCarPriceSend().setEndAddress(getHotAddressLists.get(position).getAddress());
                        CarPriceSend.getCarPriceSend().setSLat(String.valueOf(getHotAddressLists.get(position).getGdLat()));
                        CarPriceSend.getCarPriceSend().setSLng(String.valueOf(getHotAddressLists.get(position).getGdLng()));
                    }
                }


            });

        }

        @Override
        public int getItemCount() {
            return getHotAddressLists.size();
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

    private ArrayList<GetGDAddressList> getGDAddressList;

    public void sendRequestDatas() {
        HttpVolley.getInstance().getRequestData(ApiGet.getGDAddressList, new NetJsonArraySucceed<>(GetGDAddressList.class, new NetJsonArraySucceed.HolderData<GetGDAddressList>() {
            @Override
            public void holdData(ArrayList<GetGDAddressList> bean) {
                if (getGDAddressList == null) {
                    getGDAddressList = new ArrayList<GetGDAddressList>();
                }
                getGDAddressList.clear();
                getGDAddressList.addAll(bean);
                if (bean != null && bean.size() > 1) {
                    if (getGDAddressList != null) {
                    }
                }
                for (int i = 0; i < getGDAddressList.size(); i++) {
                    values.add(getGDAddressList.get(i).getName());
                }

            }
        }), null);
    }

    @Override
    public void handleManage(int value) {
        if (value == 9999) {
            addressLocationAdapter.notifyDataSetChanged();
        }
    }

    public void getHotAddressList(String value) {
        Logger.soutTestMessage("value" + value);
        new HotAddressList().netRequest(new NetResponArrayData<GetHotAddressList>() {
            @Override
            public void responeData(List<GetHotAddressList> values) {
                if (values.size() < 1) {
                    getHotAddressLists.clear();
                    addressLocationAdapter.notifyDataSetChanged();
                    return;
                }
                if (getHotAddressLists == null) {
                    getHotAddressLists = new ArrayList<GetHotAddressList>();
                } else {
                    getHotAddressLists.clear();
                    getHotAddressLists.addAll(values);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (getGDAddressList != null && getGDAddressList.size() > 1) {
                            OrderDetails.getOrderDetails().setEndCityID(getGDAddressList.get(0).getId());
                        }

                        addressLocationAdapter.notifyDataSetChanged();
                    }
                }, 10);

            }
        }, value);

    }

    private ListView listView;
    private ListAdapter<GetGdList> listListAdapter;
    private List<GetGdList> getPoiCityLists;
    private LinearLayout mainlayout;
    private SearchView searchView;

    public void initSearch() {
        mainlayout = (LinearLayout) findViewById(R.id.mainlayout);
        searchView = (SearchView) findViewById(R.id.searchview);
        searchView.setCallback(new SearchView.CallBack() {
            @Override
            public void callBack(String charsequence, int count) {
                if (charsequence.length() > 0) {
                    mainlayout.setVisibility(View.GONE);
                    Logger.soutTestMessage("===");
                    if (getgooglePoint == null) {
                        reqGoogle();
                        Logger.soutTestMessage("===getgooglePoint");
                        return;
                    }
                    Logger.soutTestMessage(getgooglePoint.getCountryType());
                    if (getgooglePoint.getCountryType().equals("1")) {
                        showList(charsequence);
                    } else {
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
                /*BaseApplication.finishActivity();
                if (ApiConstants.OrderlTpye == 2) {
                    OrderDetails.getOrderDetails().setDescity(tv2.getText().toString());
                    OrderDetails.getOrderDetails().setEndAdrName(getPoiCityLists.get(position).getName());
                    OrderDetails.getOrderDetails().setEndAddress(getPoiCityLists.get(position).getFormatted_address());
                    OrderDetails.getOrderDetails().setEndLag(getPoiCityLists.get(position).getLat());
                    OrderDetails.getOrderDetails().setEndLng(getPoiCityLists.get(position).getLng());
                } else {
                    CarPriceSend.getCarPriceSend().setEndCityName(tv2.getText().toString());
                    CarPriceSend.getCarPriceSend().setEndAddress(getPoiCityLists.get(position).getFormatted_address());
                    CarPriceSend.getCarPriceSend().setSLat(String.valueOf(getPoiCityLists.get(position).getLat()));
                    CarPriceSend.getCarPriceSend().setSLng(String.valueOf(getPoiCityLists.get(position).getLng()));
                }*/
            }

        });
        listView.setAdapter(listListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SnakebarUtils.showToast("position=="+position);
                BaseApplication.finishActivity();
                if (ApiConstants.OrderlTpye == 2) {
                    OrderDetails.getOrderDetails().setDescity(tv2.getText().toString());
                    OrderDetails.getOrderDetails().setEndAdrName(getPoiCityLists.get(position).getName());
                    OrderDetails.getOrderDetails().setEndAddress(getPoiCityLists.get(position).getFormatted_address());
                    OrderDetails.getOrderDetails().setEndLag(getPoiCityLists.get(position).getLat());
                    OrderDetails.getOrderDetails().setEndLng(getPoiCityLists.get(position).getLng());
                } else {
                    CarPriceSend.getCarPriceSend().setEndCityName(tv2.getText().toString());
                    CarPriceSend.getCarPriceSend().setEndAddress(getPoiCityLists.get(position).getFormatted_address());
                    CarPriceSend.getCarPriceSend().setSLat(String.valueOf(getPoiCityLists.get(position).getLat()));
                    CarPriceSend.getCarPriceSend().setSLng(String.valueOf(getPoiCityLists.get(position).getLng()));
                }
            }
        });
    }

    public void showList(String s) {
        String s1 = GsonUtlis.stringToJson(new QueryGdList(s, tv2.getText().toString()));
        Logger.soutMessage(s1);
        JsonArrayRequest jjs = new JsonArrayRequest(Request.Method.POST, ApiPost.getGdPoiList, s1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<GetGdList> jsonArray = null;
                try {
                    jsonArray = GsonUtlis.getJsonArray(response.toString(), GetGdList.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (jsonArray != null && jsonArray.size() > 0) {
                    getPoiCityLists.clear();
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

}

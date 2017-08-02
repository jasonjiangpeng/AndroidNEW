package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.location.GetGdList;
import com.jh.rental.user.bean.location.GetGooglePointByAdrBean;
import com.jh.rental.user.bean.location.QueryGdList;
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

public class AddressLocation_Activity extends TitelBarAcitvity implements View.OnClickListener {
   private TextView tv1;
    private SearchView searchview;
      private GetGooglePointByAdrBean getgooglePoint;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new GetGooglePointByAdr().reqNet(OrderDetails.getOrderDetails().getCity(), new NetResponData<GetGooglePointByAdrBean>() {
            @Override
            public void responeData(GetGooglePointByAdrBean object) {
                if (object.getCountryType()!=null){
                    getgooglePoint=object;
                }
            }
        });
        setContentView(R.layout.addresslocation_activity);
         initView();
        initSearch();
    }

    private boolean  isData=true;
    RecyclerView rlAddress;
    private void initView() {
        rlAddress = (RecyclerView)findViewById(R.id.rl_address);
        tv1 = (TextView)findViewById(R.id.addresstv1);
        tv1.setText(OrderDetails.getOrderDetails().getCity());
        rlAddress.setLayoutManager(new LinearLayoutManager(this));
        mysendRequestData();

    }
 //   AddressLocationAdapter  addressLocationAdapter;

    @Override
    public void onClick(View v) {

    }

    class AddressLocationAdapter extends RecyclerView.Adapter<AddressLocationHolder>{
        List<GetHotAddressList> hotAddresses;
        public AddressLocationAdapter(List<GetHotAddressList> hotAddressess) {
            this.hotAddresses=hotAddressess;
        }

        @Override
        public AddressLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            AddressLocationHolder jourineyHolder =new AddressLocationHolder(
                    LayoutInflater.from(AddressLocation_Activity.this).inflate(R.layout.sub_item_address, parent, false));
            return jourineyHolder;
        }
        @Override
        public void onBindViewHolder(AddressLocationHolder holder, final int position) {
                     holder.addressa1.setText(hotAddresses.get(position).getAdrName());
                     holder.addressa2.setText(hotAddresses.get(position).getAddress());
                     holder.addresslv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseApplication.finishActivity();
                    if (isData){
                     //   String  value=OrderDetails.getOrderDetails().getCity()+"·"+hotAddresses.get(position).getAdrName();
                        OrderDetails.getOrderDetails().setCitysub(tv1.getText().toString());
                        OrderDetails.getOrderDetails().setStartCityId(hotAddresses.get(position).getCityId());
                        OrderDetails.getOrderDetails().setStartAdrName(hotAddresses.get(position).getAdrName());
                        OrderDetails.getOrderDetails().setStartAddress(hotAddresses.get(position).getAddress());
                        OrderDetails.getOrderDetails().setStartLag(hotAddresses.get(position).getGdLat());
                        OrderDetails.getOrderDetails().setStartLng(hotAddresses.get(position).getGdLng());
                    }else {
                        OrderDetails.getOrderDetails().setDescity(tv1.getText().toString());
                        OrderDetails.getOrderDetails().setEndAdrName(hotAddresses.get(position).getAdrName());
                        OrderDetails.getOrderDetails().setEndAddress(hotAddresses.get(position).getAddress());
                        OrderDetails.getOrderDetails().setEndLag(hotAddresses.get(position).getGdLat());
                        OrderDetails.getOrderDetails().setEndLng(hotAddresses.get(position).getGdLng());
                    }


                }
            });

        }

        @Override
        public int getItemCount() {
            return hotAddresses.size();
        }}

    class AddressLocationHolder extends RecyclerView.ViewHolder{
        private LinearLayout addresslv;
        private TextView addressa1,addressa2;
        public AddressLocationHolder(View itemView) {
            super(itemView);
                   addressa1= (TextView) itemView.findViewById(R.id.addressa1);
                   addressa2= (TextView) itemView.findViewById(R.id.addressa2);
                  addresslv= (LinearLayout) itemView.findViewById(R.id.addresslv);
        }
    }


    public void mysendRequestData() {
        new HotAddressList().netRequest(new NetResponArrayData<GetHotAddressList>() {
            @Override
            public void responeData(final List<GetHotAddressList> values) {
                if (values==null){
                    return;
                }
                if (values.size()<1){
                    return;
                }
                if (ApiConstants.OrderlTpye==4){
                    new Thread(){
                        @Override
                        public void run() {
                            OrderDetails.getOrderDetails().setStartCityId(values.get(0).getCityId());
                        }
                    }.start();

                }

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setText(values.get(0).getCityName());
                        AddressLocationAdapter  addressLocationAdapter=new AddressLocationAdapter(values);
                        rlAddress.setAdapter(addressLocationAdapter);
                    }
                });

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    private ListView listView;
    private   ListAdapter<GetGdList>  listListAdapter;
    private List<GetGdList> getPoiCityLists;
    private LinearLayout mainlayout;
    public void initSearch(){
        mainlayout= (LinearLayout) findViewById(R.id.mainlayout);
        searchview= (SearchView) findViewById(R.id.searchview);
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
        listView= (ListView) findViewById(R.id.list2);
        getPoiCityLists=new ArrayList<>();
        listListAdapter =new ListAdapter<>(getPoiCityLists);
        listListAdapter.setDataBack(new ListAdapter.DataBack() {
            @Override
            public void setValue(TextView tv, TextView tv2, int positon) {
                tv.setText(getPoiCityLists.get(positon).getName());
                tv2.setText(getPoiCityLists.get(positon).getFormatted_address());
            }

            @Override
            public void dataChoose(int position) {
               /* BaseApplication.finishActivity();
                if (isData){
                   // String  value=OrderDetails.getOrderDetails().getCity()+"·"+getPoiCityLists.get(position).getName();
                    OrderDetails.getOrderDetails().setCitysub(tv1.getText().toString());
                    OrderDetails.getOrderDetails().setStartAdrName(getPoiCityLists.get(position).getName());
                    OrderDetails.getOrderDetails().setStartAddress(getPoiCityLists.get(position).getFormatted_address());
                    OrderDetails.getOrderDetails().setStartLag(getPoiCityLists.get(position).getLat());
                    OrderDetails.getOrderDetails().setStartLng(getPoiCityLists.get(position).getLng());
                }else {
                    OrderDetails.getOrderDetails().setDescity(tv1.getText().toString());
                    OrderDetails.getOrderDetails().setEndAdrName(getPoiCityLists.get(position).getName());
                    OrderDetails.getOrderDetails().setEndAddress(getPoiCityLists.get(position).getFormatted_address());
                    OrderDetails.getOrderDetails().setEndLag(getPoiCityLists.get(position).getLat());
                    OrderDetails.getOrderDetails().setEndLng(getPoiCityLists.get(position).getLng());

                }*/
            }

        });
        listView.setAdapter(listListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SnakebarUtils.showToast("position=="+position);
                BaseApplication.finishActivity();
                if (isData){
                    // String  value=OrderDetails.getOrderDetails().getCity()+"·"+getPoiCityLists.get(position).getName();
                    OrderDetails.getOrderDetails().setCitysub(tv1.getText().toString());
                    OrderDetails.getOrderDetails().setStartAdrName(getPoiCityLists.get(position).getName());
                    OrderDetails.getOrderDetails().setStartAddress(getPoiCityLists.get(position).getFormatted_address());
                    OrderDetails.getOrderDetails().setStartLag(getPoiCityLists.get(position).getLat());
                    OrderDetails.getOrderDetails().setStartLng(getPoiCityLists.get(position).getLng());
                }else {
                    OrderDetails.getOrderDetails().setDescity(tv1.getText().toString());
                    OrderDetails.getOrderDetails().setEndAdrName(getPoiCityLists.get(position).getName());
                    OrderDetails.getOrderDetails().setEndAddress(getPoiCityLists.get(position).getFormatted_address());
                    OrderDetails.getOrderDetails().setEndLag(getPoiCityLists.get(position).getLat());
                    OrderDetails.getOrderDetails().setEndLng(getPoiCityLists.get(position).getLng());

                }
            }
        });
    }
    public void showList(String s){
        if (s==null||s.length()<1){
            return;
        }
        String s1 = GsonUtlis.stringToJson(new QueryGdList(s,tv1.getText().toString()));
        Logger.soutMessage(s1);
        JsonArrayRequest jjs =new JsonArrayRequest(Request.Method.POST, ApiPost.getGdPoiList, s1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                getPoiCityLists.clear();
                ArrayList<GetGdList> jsonArray = null;
                try {
                    jsonArray = GsonUtlis.getJsonArray(response.toString(), GetGdList.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (jsonArray!=null&&jsonArray.size()>0){
                    getPoiCityLists.addAll(jsonArray);
                    mainlayout.setVisibility(View.GONE);
                    listListAdapter.notifyDataSetChanged();
                }

            }
        },null);
        HttpVolley.getInstance().getRequestQueue().add(jjs);
    }
    public void clearList(){
        mainlayout.setVisibility(View.VISIBLE);
        getPoiCityLists.clear();
        listListAdapter.notifyDataSetChanged();
    }




}

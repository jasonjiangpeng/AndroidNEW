package com.jh.rental.user.view.fragment.person;

import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.user.UserCollection;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.view.adapter.person.CollectionCircuitListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;

import java.util.LinkedHashMap;


public class CollectionCircuitFragment extends BaseListFragment {
    private String[] values={"type","start","size"};
    @Override
    public RecyclerView.Adapter getAdapter() {
        return null;

    }
    @Override
    protected void init() {
        super.init();
        netRequest();
    }

    public void netRequest() {
        HttpVolley.getInstance().getRequestParamData( ApiGet.getUserCollectionList,getLinkdHashHap(values,"1","1","10"),new NetSucceed<>(UserCollection.class, new NetSucceed.HolderData<UserCollection>() {
            @Override
            public void holdData(UserCollection bean) {
                CollectionCircuitListAdapter listAdapter = new CollectionCircuitListAdapter(getContext(), bean.getList());
                initRecyclerView(listAdapter);
            }

        }),new NetError());
    }

    public LinkedHashMap<String,String > getLinkdHashHap(String[] efg, String...abc){
        LinkedHashMap<String,String > linkedHashMap=new LinkedHashMap<>();
        for (int i = 0; i <efg.length ; i++) {
            linkedHashMap.put(efg[i],abc[i]);
        }
        return linkedHashMap;
    }

    @Override
    public void dataCallBack() {

    }
}

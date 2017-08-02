package com.jh.rental.user.view.fragment.home;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.bean.home.HotCircuits;
import com.jh.rental.user.model.NetResponData;
import com.jh.rental.user.model.postjson.PostHotCircuits;
import com.jh.rental.user.utils.jason.LoadDialog;
import com.jh.rental.user.view.adapter.home.HotRouteListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;

/*
 *  @项目名：  AndroidApp 
 *  @包名：    com.jh.rental.user.view.fragment.home
 *  @文件名:   HotDestinationsFragment
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/21 22:19
 *  @描述：    TODO
 */
public class HotRouteFragment extends BaseListFragment {


    @Override
    protected void init() {
        super.init();

        getmRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition() == hotCircuits.getList().size() - 1) {

                }
            }
        });
        if (hotCircuits == null) {
            netRequests();
        } else {
            netRequests();
        }

    }
    private HotRouteListAdapter hotRouteListAdapter;
    private HotCircuits hotCircuits;
    @Override
    public RecyclerView.Adapter getAdapter() {
        return null;
    }

    public void netRequests() {
        new PostHotCircuits().reqNet(loadValue, 8, new NetResponData<HotCircuits>() {
            @Override
            public void responeData(final HotCircuits object) {
                delete(object);
                hotCircuits = object;
                total = Integer.valueOf(object.getTotal());
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        hotRouteListAdapter = new HotRouteListAdapter(getContext(), hotCircuits.getList());
                        initRecyclerView(hotRouteListAdapter);
                    }
                });
            }
        });
    }


    @Override
    public void myHanlder(int value) {
    }

    @Override
    public void dataCallBack() {
        if (isLoad ) {
            loadData();
        }

    }

    private boolean isLoad = true;
   // private boolean start = true;
    private int total;
    private int loadValue = 1;

    private void loadData() {
        isLoad = false;
        if (total > loadValue * 8) {
            loadValue++;
           LoadDialog.show(getContext(), "加载数据...");
            new PostHotCircuits().reqNet(loadValue, 8, new NetResponData<HotCircuits>() {
                @Override
                public void responeData(final HotCircuits object) {
                    delete(object);
                    hotCircuits.getList().addAll(object.getList());
                    LoadDialog.dismiss(getContext());
                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                           LoadDialog.dismiss(getContext());
                            getmRecyclerView().getAdapter().notifyDataSetChanged();

                       //     recyclerView.getAdapter().notifyDataSetChanged();
                            isLoad = true;
                        }
                    });
                }
            });
        }else {
            isLoad = false;
        }
    }
    private void delete(HotCircuits object) {
        if (object!=null&object.getList()!=null){
            for (int i = 0;i <object.getList().size();i++){
                if (object.getList().get(i).getName().indexOf("专车接送")!=-1){
                    object.getList().remove(i);
                }
            }
        }
    }
}

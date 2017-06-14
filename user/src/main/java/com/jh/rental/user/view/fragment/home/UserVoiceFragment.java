package com.jh.rental.user.view.fragment.home;

import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.view.adapter.home.UserVoiceListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;

/*
 *  @项目名：  AndroidApp 
 *  @包名：    com.jh.rental.user.view.adapter
 *  @文件名:   UserVoiceFragment
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/21 22:21
 *  @描述：    TODO
 */
public class UserVoiceFragment
        extends BaseListFragment {
    private static final String TAG = "UserVoiceFragment";

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new UserVoiceListAdapter(getContext());
    }
}

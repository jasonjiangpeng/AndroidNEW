package com.jh.rental.user.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public abstract class BaseMainFragment extends Fragment {
    public static final String TAG = "BaseMainFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutResId(), null);
        init();
        return root;
    }


    protected  void init() {

    }

    public abstract int getLayoutResId();

}

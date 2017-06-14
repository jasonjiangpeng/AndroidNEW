package com.jh.rental.user.view.fragment;


import android.view.LayoutInflater;
import android.view.View;

import com.jh.rental.user.R;

public class ConsultFragment extends BaseFragment {
    public static final String TAG = "ConsultFragment";

    @Override
    public View setView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_consult,null);
    }
}

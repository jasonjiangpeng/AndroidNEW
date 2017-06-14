package com.jh.rental.user.view.fragment.internationnal;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.jh.rental.user.R;

/**
 * Created by 俊辉出行 on 2017/5/26.
 */

public class LocalCustomSwim extends com.jh.rental.user.view.fragment.BaseFragment {

    @Override
    public View setView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_charteredbus, null);
        RelativeLayout rlImg = (RelativeLayout) inflate.findViewById(R.id.rl_img);
        rlImg.setVisibility(rlImg.VISIBLE);
        return inflate;
    }
}

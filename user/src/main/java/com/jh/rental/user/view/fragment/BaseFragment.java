package com.jh.rental.user.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jh.rental.user.MainActivity;
import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.NetUtils;

/**
 * Created by 骏辉出行 on 2017/5/23.
 */

public abstract class BaseFragment extends Fragment {

    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (isNetUsed()){
            if (!NetUtils.isConnected(BaseContext.context)){
                View view1=inflater.inflate(R.layout.nonet,null);
                Button  button= (Button) view1.findViewById(R.id.netupdata);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity mainActivity_ = (MainActivity) getActivity();
                        mainActivity_.upUi();
                    }
                });
                return view1;
            }
        }
        View view =setView();
        return view;
    }
    public     abstract View setView();
    protected    void init(){

    }
    protected    void init(View view){

    }

    public boolean isNetUsed(){
        return  true;
    }
}

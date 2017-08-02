package com.jh.rental.user.view.actitity.hongkong;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

public class UploadData2_Activity extends TitelBarAcitvity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploaddata2_activity);
        requestPermission(new String[]{Manifest.permission.CAMERA},123);
        setMyTitel(BaseContext.getResValue(R.string.PerfectInformation));
        initView();
    }


    private void initView() {
        Button btUpload = (Button) findViewById(R.id.bt_continueUpload);
        btUpload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_continueUpload:
                ActivityUtils.nextActivity(VisaCollection_Activity.class);
                break;
        }
    }
}

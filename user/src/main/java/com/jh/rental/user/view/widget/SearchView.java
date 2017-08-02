package com.jh.rental.user.view.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.BaseApplication;


public class SearchView extends RelativeLayout implements View.OnClickListener {
    private TextView cancel;
    private EditText editText;
    private ImageView imgcall;
  /* private ListView listView;

    private   ListAdapter<GetPoiCityList>  listListAdapter;
    private List<GetPoiCityList> getPoiCityLists;*/
    public SearchView(Context context) {
        this(context,null);}
     public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sub_search, this);
         editText= (EditText) inflate.findViewById(R.id.et1);
         cancel= (TextView) findViewById(R.id.tv_cancel);
         imgcall= (ImageView) findViewById(R.id.imgcall);
         imgcall.setVisibility(GONE);
         cancel.setOnClickListener(this);
         imgcall.setOnClickListener(this);
         editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             //   ApiConstants.searchChar=s.toString();
                if (s.toString().length()>10){
                    SnakebarUtils.showToast("对不起，你输入的字符过长");
                }
              if (callback!=null){
                  if (count>0){
                      imgcall.setVisibility(VISIBLE);
                  }else {
                      imgcall.setVisibility(GONE);
                  }
                callback.callBack(s.toString(),count);
            }

            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void empty() {
        editText.setText("");
    }
    public CallBack getCallback() {
        return callback;
    }

    public void setCallback(CallBack callback) {
        this.callback = callback;
    }

    CallBack callback;
   public interface CallBack{
         void callBack(String charsequence,int count);
       void cancle();

    }
  public void setCancelGone(){
      cancel.setVisibility(GONE);
  }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgcall:
                editText.setText("");
                if (callback!=null){
                    callback.cancle();
                }
                break;
            case R.id.tv_cancel:
                BaseApplication.finishActivity();
                break;
        }


    }

}

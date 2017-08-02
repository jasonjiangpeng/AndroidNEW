package com.jh.rental.user.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jh.rental.user.R;


public class InputBoxItemView extends RelativeLayout {

    private static final String TAG = "HomeListItemView";
    private View root = null;
    private TextView txtView = null;
    private EditText editText = null;
    String tvText;
    String etTex;

    public InputBoxItemView(Context context) {
        this(context, null);
    }
    public InputBoxItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.userAPP);
        tvText = ta.getString(R.styleable.userAPP_tvTex);
        etTex = ta.getString(R.styleable.userAPP_etTex);
        initView(context);
        ta.recycle();
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        root = inflater.inflate(R.layout.sub_item_input_box, this, true);
        txtView = (TextView) root.findViewById(R.id.tv_tex);
        editText = (EditText) root.findViewById(R.id.et_tex);
        editText.setInputType(InputType.TYPE_NULL);
        //  KeyboardCtrol.getkeyboardUtils().hideSoftkey(editText);
        txtView.setText(tvText);

    }
}

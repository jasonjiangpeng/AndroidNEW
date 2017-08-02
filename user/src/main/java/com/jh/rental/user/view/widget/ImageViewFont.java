package com.jh.rental.user.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.jh.rental.user.R;

/**
 * Created by 骏辉出行 on 2017/5/31.
 */

public class ImageViewFont extends android.support.v7.widget.AppCompatImageView {
    public ImageViewFont(Context context) {
        super(context);
    }

    public ImageViewFont(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (text!=null){
            canvas.drawText(text,getWidth()/2,getHeight()/2,getpain());
        }
    }
  private String text;
    private Paint  getpain(){
        Paint paint =new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(50f);
        paint.setColor(Color.WHITE);
        return paint;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }
}

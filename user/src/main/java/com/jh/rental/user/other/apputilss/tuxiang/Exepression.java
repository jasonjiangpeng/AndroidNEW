package com.jh.rental.user.other.apputilss.tuxiang;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by LostJason on 2017/4/13.
 */

public class Exepression {
    /*贝塞尔曲线*/
    public static void drawRipple(Canvas c, Path path, Path path2, float srcx, float desx, float srcy, Paint paint, float bb ){
        //bb的值需要变化 bb-=0.1f;
        if (path==null||c==null||path2==null||paint==null){
            return;
        }
        path.reset();
        path2.reset();
        path.moveTo(srcx,srcy);
        path2.moveTo(srcx,srcy);
        float xxx=desx-srcx;
        //  bb-=0.1f;
        double w=  2*Math.PI/xxx;
        for (int j = (int) srcx; j <=desx ; j+=10) {
            float y= (float) (8*Math.sin(w*j+bb)+srcy-10);
            float y2= (float) (8*Math.cos(w*j+bb)+srcy-10);
            path.lineTo(j,y);
            path2.lineTo(j,y2);
        }
        path2.lineTo(desx,srcy);
        path.lineTo(desx,srcy);
        c.drawPath(path,paint);
        c.drawPath(path2,paint);
        // postInvalidateDelayed(100);
    }
}

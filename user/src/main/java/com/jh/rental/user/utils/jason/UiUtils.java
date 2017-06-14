
package com.jh.rental.user.utils.jason;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class UiUtils {

    static public int getScreenWidthPixels() {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) BaseContext.context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.widthPixels;
    }
    static public int getScreenHeightPixels() {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) BaseContext.context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.heightPixels;
    }

    static public int dipToPx(int dip) {
        return (int) (dip * getScreenDensity() + 0.5f);
    }

    static public float getScreenDensity( ) {
        try {
            DisplayMetrics dm = new DisplayMetrics();
            ((WindowManager) BaseContext.context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                    .getMetrics(dm);
            return dm.density;
        } catch (Exception e) {
            return DisplayMetrics.DENSITY_DEFAULT;
        }
    }

}

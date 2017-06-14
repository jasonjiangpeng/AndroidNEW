package com.jh.rental.user.other.apputilss.utilcode.utils;/*
package com.aotome202.lostjason.e202project.apputils.utilcode.utils;

import android.support.annotation.ColorInt;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.ref.WeakReference;

*/
/*

public class SnackbarUtils {

    private SnackbarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static WeakReference<Snackbar> snackbarWeakReference;

    */
/*

    public static void showShortSnackbar(View parent, CharSequence text, @ColorInt int textColor, @ColorInt int bgColor) {
        showSnackbar(parent, text, Snackbar.LENGTH_SHORT, textColor, bgColor, null, -1, null);
    }

    */
/*

    public static void showShortSnackbar(View parent, CharSequence text, @ColorInt int textColor, @ColorInt int bgColor,
                                         CharSequence actionText, int actionTextColor, View.OnClickListener listener) {
        showSnackbar(parent, text, Snackbar.LENGTH_SHORT, textColor, bgColor,
                actionText, actionTextColor, listener);
    }

    */
/*

    public static void showLongSnackbar(View parent, CharSequence text, @ColorInt int textColor, @ColorInt int bgColor) {
        showSnackbar(parent, text, Snackbar.LENGTH_LONG, textColor, bgColor, null, -1, null);
    }

    */
/*

    public static void showLongSnackbar(View parent, CharSequence text, @ColorInt int textColor, @ColorInt int bgColor,
                                        CharSequence actionText, int actionTextColor, View.OnClickListener listener) {
        showSnackbar(parent, text, Snackbar.LENGTH_LONG, textColor, bgColor,
                actionText, actionTextColor, listener);
    }

    */
/*

    public static void showIndefiniteSnackbar(View parent, CharSequence text, @ColorInt int textColor, @ColorInt int bgColor) {
        showSnackbar(parent, text, Snackbar.LENGTH_INDEFINITE, textColor, bgColor, null, -1, null);
    }

    */
/*

    public static void showIndefiniteSnackbar(View parent, CharSequence text, @ColorInt int textColor, @ColorInt int bgColor,
                                              CharSequence actionText, int actionTextColor, View.OnClickListener listener) {
        showSnackbar(parent, text, Snackbar.LENGTH_INDEFINITE, textColor, bgColor,
                actionText, actionTextColor, listener);
    }

    */
/*

    private static void showSnackbar(View parent, CharSequence text,
                                     int duration,
                                     @ColorInt int textColor, @ColorInt int bgColor,
                                     CharSequence actionText, int actionTextColor,
                                     View.OnClickListener listener) {
        snackbarWeakReference = new WeakReference<>(Snackbar.make(parent, text, duration));
        Snackbar snackbar = snackbarWeakReference.get();
        View view = snackbar.getView();
        snackbar.setActionTextColor(textColor);
        view.setBackgroundColor(bgColor);
        if (actionText != null && actionText.length() > 0 && listener != null) {
            snackbar.setActionTextColor(actionTextColor);
            snackbar.setAction(actionText, listener);
        }
        snackbar.show();
    }

    */
/*

    public static void addView(int layoutId, int index) {
        Snackbar snackbar = snackbarWeakReference.get();
        if (snackbar != null) {
            View view = snackbar.getView();
            Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) view;
            View child = LayoutInflater.from(view.getContext()).inflate(layoutId, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER_VERTICAL;
            layout.addView(child, index, params);
        }
    }

    */
/*

    public static void dismissSnackbar() {
        if (snackbarWeakReference != null && snackbarWeakReference.get() != null) {
            snackbarWeakReference.get().dismiss();
            snackbarWeakReference = null;
        }
    }
}
*/

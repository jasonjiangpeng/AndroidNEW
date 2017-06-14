package com.jh.rental.user.other.apputilss;

/**
 * Created by LostJason on 2017/4/19.
 */

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class SimpleAnimUtil {
    public SimpleAnimUtil() {
    }

    public static Animation getTranslateAnimation(int start, int end, int durationMillis) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0F, 0.0F, (float)start, (float)end);
        translateAnimation.setDuration((long)durationMillis);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }

    public static Animation getScaleAnimation(float fromX, float toX, float fromY, float toY, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(fromX, toX, fromY, toY, pivotXType, pivotXValue, pivotYType, pivotYValue);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    public static Animation getDefaultScaleAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    public static Animation getDefaultAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    public static AnimatorSet getDefaultSlideFromBottomAnimationSet(View mAnimaView) {
        AnimatorSet set = null;
        set = new AnimatorSet();
        if(mAnimaView != null) {
            set.playTogether(new Animator[]{ObjectAnimator.ofFloat(mAnimaView, "translationY", new float[]{250.0F, 0.0F}).setDuration(400L), ObjectAnimator.ofFloat(mAnimaView, "alpha", new float[]{0.4F, 1.0F}).setDuration(375L)});
        }

        return set;
    }
}
package com.example.sunhongbo.dispatchtouchsample;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import android.widget.RelativeLayout;

/**
 * Created by sunhongbo on 17/9/12.
 */

public class MyLayout extends RelativeLayout {

    public MyLayout(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }


    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        Log.v("111", "mylayout dipatch " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(final MotionEvent ev) {
        Log.v("111", "MyLayout onInterceptTouchEvent " + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        Log.v("111", "MyLayout onTouchEvent");
        return super.onTouchEvent(event);
    }
}

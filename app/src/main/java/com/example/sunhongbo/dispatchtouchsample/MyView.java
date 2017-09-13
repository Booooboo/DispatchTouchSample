package com.example.sunhongbo.dispatchtouchsample;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by sunhongbo on 17/9/12.
 */

public class MyView extends Button {

    private OnTouchListener mOnTouchListener;

    public MyView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(final MotionEvent event) {
        //Log.v("111", "MyView disPatch " + event.getAction());
        //getParent().requestDisallowInterceptTouchEvent(true);
        //return super.dispatchTouchEvent(event);

        // 加上这句话，使得父层Move的onInterceptTouchEvent不能拦截自己收到event
        getParent().requestDisallowInterceptTouchEvent(true);
        int action = event.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e("111", "dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("111", "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("111", "dispatchTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(final MotionEvent event) {

        Log.v("111", "MyView onTouchEvent " + event.getAction());

        //try {
        //    Method method = getClass().getDeclaredMethod("getListenerInfo");
        //    method.setAccessible(true);
        //    Object o = method.invoke(this);
        //    Field field = o.getClass().getField("mOnTouchListener");
        //    field.setAccessible(true);
        //    mOnTouchListener = (OnTouchListener) field.get(this);
        //    mOnTouchListener.onTouch(this, event);
        //} catch (Exception e) {
        //
        //}
        return true;
        //return true
        // 如果这里消费event，如果这个view的onTouch返回false，回去执行这个view重写的onClick方法
        //输出
        //09-13 15:10:46.308 19843-19843/? V/111: mylayout dipatch 0
        //09-13 15:10:46.308 19843-19843/? V/111: mylayoutNext dipatch 0
        //09-13 15:10:46.308 19843-19843/? V/111: MyView disPatch
        //09-13 15:10:46.308 19843-19843/? V/111: myView touch 0
        //09-13 15:10:46.308 19843-19843/? V/111: MyView onTouchEvent 0
        //09-13 15:10:46.413 19843-19843/? V/111: mylayout dipatch 1
        //09-13 15:10:46.413 19843-19843/? V/111: mylayoutNext dipatch 1
        //09-13 15:10:46.413 19843-19843/? V/111: MyView disPatch
        //09-13 15:10:46.413 19843-19843/? V/111: myView touch 1
        //09-13 15:10:46.413 19843-19843/? V/111: MyView onTouchEvent 1
        //09-13 15:10:46.418 19843-19843/? V/111: MyView onClick

    }
}

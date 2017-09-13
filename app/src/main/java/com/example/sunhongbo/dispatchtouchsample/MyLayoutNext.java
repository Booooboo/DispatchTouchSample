package com.example.sunhongbo.dispatchtouchsample;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by sunhongbo on 17/9/13.
 */

public class MyLayoutNext extends LinearLayout {

    public MyLayoutNext(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }


    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        Log.v("111", "myLayoutNext dispatch " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    // return true;
    // 拦截事件，直接调用这个view的onTouchEvent, 当前view的onTouchEvent不消费，继续往上传递
    // 09-13 15:20:39.158 21460-21460/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 0
    //09-13 15:20:39.158 21460-21460/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 0
    //        09-13 15:20:39.158 21460-21460/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onInterceptTouchEvent0
    //09-13 15:20:39.158 21460-21460/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 15:20:39.158 21460-21460/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onTouchEvent
    //09-13 15:20:39.158 21460-21460/com.example.sunhongbo.dispatchtouchsample V/111: 11111111
    //        09-13 15:20:39.248 21460-21460/com.example.sunhongbo.dispatchtouchsample V/111: 11111111


    //return super.onInterceptTouchEvent(ev); 和 return false; 效果一样
    //不拦截事件，并且最终没有任何view的onTouchEvent消费事件，那么Action_Down后续的Action_Move和Action_Up都不会执行
    //09-13 15:22:14.918 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 0
    //        09-13 15:22:14.918 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 0
    //        09-13 15:22:14.918 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onInterceptTouchEvent 0
    //        09-13 15:22:14.918 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: MyView disPatch
    //09-13 15:22:14.918 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: myView touch 0
    //        09-13 15:22:14.918 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: MyView onTouchEvent 0
    //        09-13 15:22:14.918 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 15:22:14.918 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onTouchEvent
    //09-13 15:22:14.918 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: 11111111
    //        09-13 15:22:15.013 23332-23332/com.example.sunhongbo.dispatchtouchsample V/111: 11111111
    // 如果被某个View的onTouchEvent消费掉，会是下面这个流程，Action_Move和Action_Up都能得到执行
    //09-13 15:26:18.943 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 0
    //        09-13 15:26:18.943 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 0
    //        09-13 15:26:18.943 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onInterceptTouchEvent 0
    //        09-13 15:26:18.943 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: MyView disPatch
    //09-13 15:26:18.943 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: myView touch 0
    //        09-13 15:26:18.943 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: MyView onTouchEvent 0
    //        09-13 15:26:18.943 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 15:26:19.263 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 1
    //        09-13 15:26:19.263 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 1
    //        09-13 15:26:19.263 26449-26449/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent


    @Override
    public boolean onInterceptTouchEvent(final MotionEvent ev) {
        Log.v("111", "MyLayoutNext onInterceptTouchEvent " + ev.getAction());
        //return super.onInterceptTouchEvent(ev);
        int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                //如果你觉得需要拦截
                return false ;
            case MotionEvent.ACTION_MOVE:
                //如果你觉得需要拦截
                return true ;
            case MotionEvent.ACTION_UP:
                //如果你觉得需要拦截
                return true ;
        }

        return super.onInterceptTouchEvent(ev);
    }

    // 在这个onTouchEvent消费掉， 只有第一次Action_Down会走一边流程找到这个消费点
    // Action_Move和Action_Up直接走到这这一层的dispatchTouchEvent后不在往下分发，直接调用onTouchEvent消费;
    // 输出
    //09-13 17:42:52.900 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 0
    //        09-13 17:42:52.900 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 0
    //        09-13 17:42:52.900 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 0
    //        09-13 17:42:52.900 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onInterceptTouchEvent 0
    //        09-13 17:42:52.900 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyView disPatch 0
    //        09-13 17:42:52.900 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myView touch 0
    //        09-13 17:42:52.900 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyView onTouchEvent 0
    //        09-13 17:42:52.900 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.030 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.030 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.030 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.030 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.045 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.045 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.045 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.045 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.060 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.060 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.060 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.060 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.080 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.080 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.080 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.080 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.095 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.095 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.095 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.095 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.110 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.110 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.110 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.110 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.130 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.130 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.130 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.130 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.145 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.145 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.145 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.145 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.160 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.160 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.160 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.160 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.180 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.180 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.180 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.180 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.195 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.195 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.195 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.195 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.210 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.210 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.210 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.210 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.225 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 2
    //        09-13 17:42:53.225 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 2
    //        09-13 17:42:53.230 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 2
    //        09-13 17:42:53.230 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent
    //09-13 17:42:53.230 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: mylayout dipatch 1
    //        09-13 17:42:53.230 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayout onInterceptTouchEvent 1
    //        09-13 17:42:53.230 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: myLayoutNext dispatch 1
    //        09-13 17:42:53.230 16254-16254/com.example.sunhongbo.dispatchtouchsample V/111: MyLayoutNext onTouchEvent


    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        Log.v("111", "MyLayoutNext onTouchEvent");
        return false;
    }
}

package com.example.sunhongbo.dispatchtouchsample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MyView myView = (MyView) findViewById(R.id.my_view);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                Log.v("111", "button touch");
                return false;
            }
        });

        myView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                Log.v("111", "myView touch " + motionEvent.getAction());
                return false;
                // return true；
                //09-13 15:50:52.505 30502-30502/? V/111: mylayout dipatch 0
                //09-13 15:50:52.505 30502-30502/? V/111: myLayoutNext dispatch 0
                //09-13 15:50:52.505 30502-30502/? V/111: MyLayoutNext onInterceptTouchEvent 0
                //09-13 15:50:52.505 30502-30502/? V/111: MyView disPatch
                //09-13 15:50:52.505 30502-30502/? V/111: myView touch 0
                //09-13 15:50:52.570 30502-30502/? V/111: mylayout dipatch 1
                //09-13 15:50:52.570 30502-30502/? V/111: myLayoutNext dispatch 1
                //09-13 15:50:52.570 30502-30502/? V/111: MyLayoutNext onInterceptTouchEvent 1
                //09-13 15:50:52.570 30502-30502/? V/111: MyView disPatch
                //09-13 15:50:52.570 30502-30502/? V/111: myView touch 1


            }
        });
        myView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                Log.v("111", "MyView onClick");
            }
        });
    }



    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        Log.v("111", "11111111");
        return super.onTouchEvent(event);
    }
}

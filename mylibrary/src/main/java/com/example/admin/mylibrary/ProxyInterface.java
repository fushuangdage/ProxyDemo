package com.example.admin.mylibrary;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by fushuang on 2017/9/5.
 */

public interface ProxyInterface {


    public void onCreate(Bundle savedInstanceState);

    public void onStart();

    public void onResume();

    public void onPause();

    public void onStop();

    public void onDestroy();

    public void onSaveInstanceState(Bundle outState);

    public  boolean onTouchEvent(MotionEvent event);

    public void onAttach(Activity context);

}

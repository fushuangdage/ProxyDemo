package com.example.admin.alipay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.admin.mylibrary.ProxyInterface;

/**
 * Created by fushuang on 2017/9/6.
 */

public class BaseActivity extends Activity implements ProxyInterface {

    private Activity activity;

    @Override
    public WindowManager getWindowManager() {
        if (activity != null) {
            return activity.getWindowManager();
        } else {
            return super.getWindowManager();
        }
    }

    @Override
    public Window getWindow() {
        if (activity != null) {
            return activity.getWindow();
        }else {
            return super.getWindow();
        }
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        if (activity != null) {
            return activity.getLayoutInflater();
        } else {
            return super.getLayoutInflater();
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        if (activity != null) {
           return activity.getClassLoader();
        }else {
            return super.getClassLoader();
        }
    }

    @Override
    public <T extends View> T findViewById(int id) {
        if (activity != null) {
            return activity.findViewById(id);
        }else {
            return super.findViewById(id);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (activity != null) {
            activity.setContentView(layoutResID);
        } else {
            super.setContentView(layoutResID);
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public void onAttach(Activity context) {
        activity = context;
    }

    @Override
    public Context getApplicationContext() {
        if (activity != null) {
            return activity.getApplicationContext();
        }else {

            return super.getApplicationContext();
        }
    }
}

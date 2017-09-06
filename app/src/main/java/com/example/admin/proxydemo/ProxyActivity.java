package com.example.admin.proxydemo;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.admin.mylibrary.ProxyInterface;

import java.lang.reflect.Constructor;


public class ProxyActivity extends Activity {

    private String className;
    private ProxyInterface realActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
         className = getIntent().getStringExtra("className");

        //这种不能获得,因为类在包外面
//        getClassLoader().loadClass(className)

        try {
            //activity 构造私有,反射构建
            Class loadClass = getClassLoader().loadClass(className);
            Constructor constructor = loadClass.getConstructor(new Class[]{});
            realActivity = ((ProxyInterface) constructor.newInstance(new Object[]{}));
            realActivity.onAttach(this);
            /**
             * 定义标准
             * 传递生命周期
             */
            Bundle bundle = new Bundle();
            realActivity.onCreate(bundle);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        realActivity.onStart();
    }

    @Override
    protected void onResume() {
        super.onPause();
        realActivity.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        realActivity.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realActivity.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        realActivity.onPause();
    }


    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance().dexClassLoader;
    }

    @Override
    public Resources getResources() {
        return PluginManager.getInstance().resources;
    }
}

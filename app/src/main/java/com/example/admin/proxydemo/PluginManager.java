package com.example.admin.proxydemo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by fushuang on 2017/9/5.
 */

public class PluginManager {

    public DexClassLoader dexClassLoader;
    public Resources resources;
    public Context context;
    public String enterActivityName;  //新包入口的activity name

    private static final PluginManager ourInstance = new PluginManager();

    public static PluginManager getInstance() {
        return ourInstance;
    }

    private PluginManager() {

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    //加载一个页面有两个因素
    //一个是class文件 一个是resource
    public void loadPath(String path) {

        //重新构建新包的类加载器
        File dexOutFile = context.getDir("dex", Context.MODE_PRIVATE);
        dexClassLoader = new DexClassLoader(path, dexOutFile.getAbsolutePath(), null, context.getClassLoader());


        PackageManager packageManager = context.getPackageManager();

        PackageInfo packageInfo = packageManager.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
        enterActivityName = packageInfo.activities[0].name;


        //构建新包的资源加载器
        //对于AssetManager因为构造方法添加了Hide注解,所以必须通过反射获取
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = AssetManager.class.getMethod("addAssetPath", String.class);
            method.invoke(assetManager,path);
            resources = new Resources(assetManager,context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}

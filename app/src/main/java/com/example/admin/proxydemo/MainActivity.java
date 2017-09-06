package com.example.admin.proxydemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PluginManager.getInstance().setContext(this);
    }


    public void load(View view) {
        File directory = Environment.getExternalStorageDirectory();
        File file = new File(directory, "plugin.apk");
        PluginManager.getInstance().loadPath(file.getAbsolutePath());
    }

    public void jump(View view) {
        Intent intent = new Intent(this, ProxyActivity.class);
        intent.putExtra("className",PluginManager.getInstance().enterActivityName);
        startActivity(intent);
    }


}

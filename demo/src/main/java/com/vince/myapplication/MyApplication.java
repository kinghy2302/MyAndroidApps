package com.vince.myapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by vince on 2014/9/4.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        Log.d("MyApplication","Application is created.");
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        Log.d("MyApplication","Application is terminate.");
        super.onTerminate();
    }

    public void test(Context con,String param){
        Toast.makeText(con,param,Toast.LENGTH_LONG).show();
    }
}

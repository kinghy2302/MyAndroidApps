package com.vince.myapplication;

import android.animation.AnimatorInflater;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.Service;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.transition.TransitionInflater;
import android.view.MenuInflater;
import android.view.WindowManager;

import java.util.LinkedList;
import java.util.ResourceBundle;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Thread workThread1=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                }
            }
        },"vince_worker_1");

/*            ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            PackageManager pm = getPackageManager();
            WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            Resources rs = getResources();
            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            BluetoothManager bm = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);*/

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public static void main(String[] args){
        LinkedList<Float> linkedList=new LinkedList<Float>();
       /* int size=0;
       for(int i=1;i<1000;i++){
            size=linkedList.size();
            if(size<300)
            linkedList.add(Float.valueOf(i));
        }*/
        linkedList.add(1f);
        linkedList.add(2f);
        linkedList.add(3f);

        linkedList.removeFirst();
        linkedList.addLast(4f);

    }
}

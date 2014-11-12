package com.vince.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import java.io.IOException;
import java.util.TimerTask;

/**
 * Created by vince on 2014/11/5.
 */
public class Test extends Activity{
    private static Thread t1;
    public static final String MY_ACTION="com.vince.demo..action.test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                System.out.println(intent.getAction());
                Object o=null;
               try{ o.toString();}catch (NullPointerException e){
                   e.printStackTrace();
               }
            }
        };
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(MY_ACTION);
        registerReceiver(broadcastReceiver,intentFilter);

       new Thread(new Runnable() {
           @Override
           public void run() {
                   Intent intent=new Intent(MY_ACTION);
                   sendBroadcast(intent);
           }
       },"send_thread").start();
    }


    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 has gone.");
            }
        },"t2").start();
        t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I run");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"t1");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.gc();
        System.out.println(t1.getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

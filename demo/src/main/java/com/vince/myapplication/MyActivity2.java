package com.vince.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MyActivity2 extends Activity implements View.OnClickListener{

    private TextView textView,textView2;
    private Button button,button2;
    protected static int playseconds;
    protected static Integer i=0;
    private  Handler handler;
    private static int targettime=3600;
    private static boolean isCounnDown,isPause;
    private Timer timer;
    private TimerTask timerTask;
    AsyncTask<String,Integer,String> task1,task2;
    private Thread t1;




    private static final String MYACTIVITY2_LOG_TAG="vince_tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(MYACTIVITY2_LOG_TAG,"call the method onCreate!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
/*        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("111111111111"+ Thread.currentThread().getName());
            }
        });
        textView.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("2222222222222"+ Thread.currentThread().getName());
            }
        });
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText("3333333333333"+ Thread.currentThread().getName());
            }
        },2000);*/
 /*       AsyncTask<String,Void,String> task1=new AsyncTask<String,Void,String>() {
            @Override
            protected String doInBackground(String... params) {
                String threadName=Thread.currentThread().getName();
                return threadName;
            }

            @Override
            protected void onPostExecute(String o) {
                textView.setText("update UI from thread : "+o);
                super.onPostExecute(o);
            }
        };
        task1.execute();*/
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCounnDown=!isCounnDown;
                textView.setText(isCounnDown?dateFormat(targettime-playseconds)+"↓":dateFormat(playseconds)+"↑");
            }
        });

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                try {
                    switch (msg.what) {
                        case 1:
                            playseconds++;
                            textView.setText(isCounnDown?dateFormat(targettime-playseconds)+"↓":dateFormat(playseconds)+"↑");
                            break;
                        case 2:
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        timer=new Timer(true);
        timerTask=new MyTimerTask();
        timer.schedule(timerTask,0,1000);
/*        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    if(playseconds>=100){
                        timer.cancel();
                    }
                }
            }
        },"mythread");
        thread.setDaemon(true);
        thread.isDaemon();
        thread.run();*/

        task1= new MyAsyncTask() ;
        task1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
/*        t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.interrupted()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        },"vince's thread1");
        t1.start();*/
/*        AsyncTask task2= new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... params) {
                   return null;
            }}.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        task2.cancel(true);*/
//        Log.d(MYACTIVITY2_LOG_TAG,"isCancel?:"+task2.isCancelled());
 /*       task2= new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... params) {
                while(!isCancelled()&&!Thread.interrupted()){

                    try {
                        Thread.sleep(1000);
                        publishProgress(i++);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                textView2.setText(values[0].toString());
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);*/
    }

    public static String dateFormat(int seconds){
        int hour,minute,second;
        hour=seconds/3600;
        minute=(seconds-3600*hour)/60;
        second=seconds-3600*hour-60*minute;
        StringBuffer sb=new StringBuffer();
        sb.append(String.valueOf(hour));
        sb.append(":");
        sb.append(minute>9?String.valueOf(minute):"0"+String.valueOf(minute));
        sb.append(":");
        sb.append(second>9?String.valueOf(second):"0"+String.valueOf(second));
        return sb.toString();
    }

    @Override
    protected void onStart() {
        Log.d(MYACTIVITY2_LOG_TAG,"call the method onStart!");
        Fragment f1=new MyFragment();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.container,f1);
        transaction.commit();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d(MYACTIVITY2_LOG_TAG,"call the method onRestart!");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d(MYACTIVITY2_LOG_TAG,"call the method onResume!");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(MYACTIVITY2_LOG_TAG,"call the method onDestroy!");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d(MYACTIVITY2_LOG_TAG,"call the method onPause!");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(MYACTIVITY2_LOG_TAG,"call the method onStop!");
        timer.cancel();
        task1.cancel(true);
        t1.interrupt();
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
/*
                if(!isPause){
                    timerTask.cancel();
                    button.setText("resume");
                }else{
                    timerTask=new MyTimerTask();
                    button.setText("pause");
                    timer.schedule(timerTask,0,1000);
                }
                isPause=!isPause;
*/
                try {
                    task1=new MyAsyncTask();
                    task1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                }catch (Exception e){
                    Log.e(MYACTIVITY2_LOG_TAG,"eeeeeee",e);
                }
                break;
            case R.id.button2:
/*                Dbhelper dbhelper=new Dbhelper(this);
                SQLiteDatabase db=dbhelper.getWritableDatabase();
                String[] columns={"2"};
                Cursor cursor=db.query("mytable",null,"id=?",columns,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        Toast.makeText(this,cursor.getString(1),Toast.LENGTH_SHORT).show();
                    }while (cursor.moveToNext());
                }*/
/*                ContentValues cv=new ContentValues();
                cv.put("name","插入数据1");
                cv.put("count","2014");
                cv.put("remark","add");
                db.insert("mytable",null,cv);
                ContentValues cv1=new ContentValues();
                cv1.put("remark","更新一条记录");
                String[] param={"1"};
                db.update("mytable",cv1,"id=?",param);
                String[] param1={"2"};
                db.delete("mytable","id=?",param1);*/
/*                Cursor cursor=db.rawQuery("select mytable2.descriptor from mytable,mytable2 where mytable.id=mytable2.table1_id and mytable.id=1",null);
                if(cursor.moveToFirst()){
                    Toast.makeText(this,cursor.getString(0),Toast.LENGTH_SHORT).show();
                }*/
//                SharedPreferences sp=getSharedPreferences("yasi",MODE_PRIVATE);
/*                SharedPreferences.Editor editor=sp.edit();
                editor.putString("auth","VinceHe");
                editor.commit();*/
/*                String auth=sp.getString("auth",null);
                Toast.makeText(this,"This application created by "+auth,Toast.LENGTH_LONG).show();*/
/*                File file=new File(getFilesDir().getPath()+"/yasi.text");
                FileWriter fw=null;
                try {
                    fw =new FileWriter(file);
                    fw.write("VinceHe,believe yourself!");
                    fw.flush();
                } catch (IOException e) {
                    Log.e("ioError","创建文件失败！");
                }finally {
                   if(fw!=null){
                       try {
                           fw.close();
                       } catch (IOException e) {
                           Log.e("ioError","释放输出流失败！");
                       }
                   }                }*/
                task1.cancel(true);
//                t1.interrupt();
                break;
            default:
                Toast.makeText(this,"该控件暂无对应的交互内容",Toast.LENGTH_SHORT).show();
        }
    }

    class  MyTimerTask extends java.util.TimerTask{
        @Override
        public void run() {
            Message message=Message.obtain(handler);
            message.what=1;
            handler.sendMessage(message);
        }
    };
    class MyAsyncTask extends AsyncTask<String,Integer,String>{
        @Override
        protected String doInBackground(String... params) {
            while(!isCancelled()){
                try {
                    Thread.sleep(1000);
                    publishProgress(i++);
                } catch (InterruptedException e) {
//                    Log.e(MYACTIVITY2_LOG_TAG,"InterruptedException occur",e);
                    break;
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView2.setText(values[0].toString());
        }
    }

    public static void main(String[] args){
//        int a=189;
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toHexString(a));
//        System.out.println(Integer.toOctalString(a));
        int b=0x123;
        int c=0123;
        System.out.println(b);
        System.out.println(c);
    }
}
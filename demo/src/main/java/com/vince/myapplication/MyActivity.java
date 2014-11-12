package com.vince.myapplication;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MyActivity extends Activity{

    Button button;
    ImageView car;

    AnimationSet set;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_play_flash);
//        WebView w=(WebView)findViewById(R.id.webView);
//        w.loadUrl("http://www.163.com");
/*        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyActivity.this,ItemListActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });*/
    }

/*    @Override
    protected void onResume() {
        super.onResume();
//        Intent intent=new Intent(this,ItemListActivity.class);
//        startActivity(intent);
//        overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
    }*/
    /*{

        try {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD,WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |View.SYSTEM_UI_FLAG_FULLSCREEN |View.SYSTEM_UI_FLAG_IMMERSIVE);
            setContentView(R.layout.activity_my);
//            Animation animation=AnimationUtils.loadAnimation(MyActivity.this,R.anim.animotion1);
//            set=new AnimationSet(true);
            final Animation animation1= new TranslateAnimation(-300.0f,300.0f,0.0f,0.0f);
            animation1.setDuration(6000);
//            animation1.setRepeatMode(Animation.REVERSE);
            animation1.setRepeatCount(-1);
*//*            Animation animation2=new RotateAnimation(0f,360f);
            animation2.setDuration(6000);
            animation2.setRepeatCount(-1);*//*

//            animation1.setRepeatMode(Animation.REVERSE);
//            animation1.setRepeatCount(2);
//            animation1.setRepeatMode(Animation.REVERSE);
//            animation1.setRepeatCount(10);
//            Animation animation2= new ScaleAnimation(1.0f,0.3f,1.0f,0.3f);
//            animation2.setDuration(6000);
*//*            Animation animation2=new AlphaAnimation(1.0f,0.3f);
            animation2.setDuration(6000);
            animation2.setStartOffset(6000);*//*
            *//* Animation animation3=new ScaleAnimation(0.1f,1.0f,0.1f,1.0f);
            animation3.setDuration(6000);
            animation3.setStartOffset(12000);
            Animation animation4=new RotateAnimation(0f,360f);
            animation4.setDuration(6000);
            animation4.setStartOffset(18000);
            set.addAnimation(animation1);
            set.addAnimation(animation2);
            set.setFillEnabled(true);
            set.setFillBefore(false);
            set.setFillAfter(true);


            set.addAnimation(animation2);
            set.addAnimation(animation3);
            set.addAnimation(animation4);*//*

            button=(Button)findViewById(R.id.button);
            car=(ImageView)findViewById(R.id.image);
            car.setAnimation(animation1);
*//*            Timer timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    set.cancel();
                }
            },12000);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    set.startNow();
                }
            },24000);*//*
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(MyActivity.this,"Are you sure to leave？",Toast.LENGTH_LONG).show();
//                    quitDialog();
*//*                    Timer timer=new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            finish();
                        }
                    },2000);*//*

                    if(button.getText().equals("stop")){
                        Toast.makeText(MyActivity.this,"stop the car!",Toast.LENGTH_SHORT).show();
                        button.setText("start");
                        animation1.cancel();
                    }else{
                        Toast.makeText(MyActivity.this,"start the car!",Toast.LENGTH_SHORT).show();
                        button.setText("stop");
                        animation1.startNow();
                    }

//                    System.exit(0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_HOVER_MOVE)
            ;

        float x = event.getX();
        float y = event.getY();
        return super.onTouchEvent(event);

    }

    protected void quitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                 MyActivity.this.finish();
                 }
            });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
         @Override
           public void onClick(DialogInterface dialog, int which) {
           dialog.dismiss();
           }
           });
        builder.create().show();
       }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static void main(String[] args){
        System.out.println(System.getenv("ANDROID_HOME"));
    }
}

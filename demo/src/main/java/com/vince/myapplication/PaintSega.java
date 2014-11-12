package com.vince.myapplication;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Random;

public class PaintSega extends Activity {
    private ImageView canvas_sega;
    private Button button;
    private Bitmap baseBitmap;
    private Canvas canvas;
    private Paint paint;
    private final static String TAG="canvas_sega" ;
    public final static float startX=0;
    public final static float startY=500;
    final LinkedList<Float> list=new LinkedList<Float>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paint_sega);

        // 初始化一个画笔，笔触宽度为1，颜色为绿色
        paint = new Paint();
        paint.setStrokeWidth(1);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        canvas_sega = (ImageView) findViewById(R.id.canvas_sega);
        button=(Button)findViewById(R.id.paint_button);
        button.setText("绘制");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paint();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void paintOnce(){
            // 第一次绘图初始化内存图片，指定背景为白色
            if (baseBitmap == null) {
            baseBitmap = Bitmap.createBitmap(canvas_sega.getWidth(),
                    canvas_sega.getHeight(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(baseBitmap);
            canvas.drawColor(Color.WHITE);
        }
            for(int i=0;i<1000;i++){
            //根据两点坐标，绘制连线
            if(i<500)
            canvas.drawLine(startX+i, startY-i, startX+i, startY, paint);
            else
            canvas.drawLine(startX+i,(float)Math.sin(i%180*Math.PI/180)*500, startX+i, startY, paint);
        }

            // 把图片展示到ImageView中
            canvas_sega.setImageBitmap(baseBitmap);

        }
    public void paint(){
        Thread workthread1=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while(true){
                        Thread.sleep(10);
                        float value= (float)Math.random()*500;
                        if(list.size()<1240)
                            list.add(value);
                        else{
                            list.removeFirst();
                            list.addLast(value);
                        }
                        paintWithList();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
         },"workthread1");
        workthread1.start();
    }
    /**
     * 清除画板
     */
    protected void initCanvas() {
        // 手动清除画板的绘图，重新创建一个画板
            baseBitmap = Bitmap.createBitmap(canvas_sega.getWidth(),
                    canvas_sega.getHeight(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(baseBitmap);
            canvas.drawColor(Color.WHITE);
    }
    protected void paintWithList(){
        initCanvas();
        for(int i=0;i<1240;i++){
            canvas.drawLine(startX+i, startY-(list.size()>i?list.get(i):0), startX+i, startY, paint);
        }
        canvas_sega.post(
                new Runnable() {
                    @Override
                    public void run() {
                        canvas_sega.setImageBitmap(baseBitmap);
                    }
                }
        );
    }
    }
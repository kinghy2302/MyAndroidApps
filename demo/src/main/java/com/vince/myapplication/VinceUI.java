package com.vince.myapplication;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by vince on 2014/10/22.
 */
public class VinceUI extends TextView{
    int mNum;
    int mColor;

    public VinceUI(Context context,AttributeSet attrs){
        super(context,attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.VinceUI);
        mNum=typedArray.getInteger(R.styleable.VinceUI_num,8);
        mColor=typedArray.getColor(R.styleable.VinceUI_col,android.R.color.holo_blue_dark);
        super.setBackgroundColor(mColor);
        super.setText(getText()+String.valueOf(mNum));

    }
}

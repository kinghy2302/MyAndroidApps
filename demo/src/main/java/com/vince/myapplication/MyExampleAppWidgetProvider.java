package com.vince.myapplication;

import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class MyExampleAppWidgetProvider extends AppWidgetProvider {

    private final static String TAG="appwidgetdemo";

    public MyExampleAppWidgetProvider() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d(TAG,"call onReceive method.");
        Log.d(TAG,intent.getAction());
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG,"call onUpdate method.");
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(TAG,"call onDeleted method.");
        super.onDeleted(context, appWidgetIds);

    }

    @Override
    public void onEnabled(Context context) {
        Log.d(TAG,"call onEnabled method.");
        super.onEnabled(context);

    }

    @Override
    public void onDisabled(Context context) {
        Log.d(TAG,"call onDisabled method.");
        super.onDisabled(context);

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        Log.d(TAG,"call onAppWidgetOptionsChanged method.");
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);

    }

}

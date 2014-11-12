package com.vince.myapplication;

        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    public BootReceiver() {
}

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MyActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}

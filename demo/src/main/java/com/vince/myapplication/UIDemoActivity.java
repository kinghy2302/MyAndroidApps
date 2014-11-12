package com.vince.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vince.myapplication.view.MyTimePickerDialog;
import com.vince.myapplication.view.TimePicker;



public class UIDemoActivity extends Activity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uidemo);
        button=(Button)findViewById(R.id.customTimePicker);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyTimePickerDialog(UIDemoActivity.this,new MyTimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute, int seconds) {
                        Toast.makeText(UIDemoActivity.this,"您刚才选择的时间为"+hourOfDay+":"+minute+":"+seconds,Toast.LENGTH_SHORT).show();
                    }
                },0,0,0).show();
            }
        });
//        startService(new Intent(UIDemoActivity.this, MyService.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.uidemo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this,MyActivity4.class));
            return true;
        }
/*        if(id==R.id.paint){
            startActivity(new Intent(this,PaintSega.class));
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }
}

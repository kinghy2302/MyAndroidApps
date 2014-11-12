package com.vince.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.widget.Spinner;
import android.widget.Toast;

import com.vince.myapplication.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyActivity4 extends Activity {

    private Spinner spinner;
    private Button button1,button3;
    final static String[] spinner_data={"2通道电缆","4通道电缆","6通道电缆","8通道电缆"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity4);
        ActionBar actionBar=getActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayHomeAsUpEnabled(true);
        spinner=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.item_spinner,spinner_data);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MyActivity4.this,"你刚才选择了"+spinner_data[position]+"!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new TimePickerDialog(MyActivity4.this,null,10,30,true);
                dialog.show();
            }
        });
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MyActivity4.this);
                builder.setTitle("痉挛检测提示")
                        .setMessage("在系统运行期间检测到肌肉痉挛，治疗已自行终止！")
                        .setPositiveButton("继续",new DialogInterface.OnClickListener() {
                    @Override
                        public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("停止",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setCancelable(false).create().show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity4, menu);
        MenuItem shareItem=menu.findItem(R.id.share);
        ShareActionProvider mShareActionProvider = (ShareActionProvider)shareItem.getActionProvider();
        mShareActionProvider.setShareIntent(getDefaultIntent());
        MenuItem searchItem=menu.findItem(R.id.search);
        SearchView searchView=(SearchView)searchItem.getActionView();
        return super.onCreateOptionsMenu(menu);
    }
    private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings :
                finish();
                return true;
            case android.R.id.home :
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);
    }
    public static void main(String[] args){
        boolean isWrite=true;

        if(isWrite){
        ObjectOutputStream objectOutputStream=null;
        FileOutputStream fileOutputStream=null;
        Husband h=new Husband("vince",31);

        try {
            File file=new File("D://1.txt");
            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(h);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(objectOutputStream!=null)
                objectOutputStream.close();
            if(fileOutputStream!=null)
                fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
        ObjectInputStream objectInputStream=null;
        FileInputStream fileInputStream=null;
        try{
            File file=new File("D://1.txt");
            fileInputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);
            Husband h=(Husband)objectInputStream.readObject();
            System.out.println(h.name+h.age);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(objectInputStream!=null)
                    objectInputStream.close();
                if(fileInputStream!=null)
                    fileInputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }}
        }
    }

class Husband implements Serializable{
        String name;
        int age;
        Husband(String mname,int mage){
            name=mname;
            age=mage;
        }
    public void test(){
        System.out.println(name+age);
    }
    }


package com.vince.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by vince on 2014/9/2.
 */
public class Dbhelper extends SQLiteOpenHelper{
    public Dbhelper(Context context) {
        super(context, "yasi", null, 5);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS mytable('id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,'name' TEXT,'count' INTEGER)");
        db.execSQL("insert into mytable(name,count) values('number1',1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion<=1){
            db.execSQL("alter table mytable add column remark TEXT");
        }
        if(oldVersion<=2){
            db.execSQL("alter table mytable add column remark2 TEXT");
        }
        if(oldVersion<=3){
            db.execSQL("insert into mytable(name,count) values('测试数据',100)");
        }
        if(oldVersion<=4){
            db.execSQL("create table IF NOT EXISTS mytable2('table1_id' INTEGER NOT NULL,'descriptor' TEXT)");
            db.execSQL("insert into mytable2 values('1','据说关联表只能走sql查询方式')");
        }
    }

}

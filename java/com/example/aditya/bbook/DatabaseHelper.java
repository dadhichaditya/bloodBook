package com.example.aditya.bbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aditya on 13/4/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Databasename = "Blood.db";
//    public static final String TableName1 = "seek";
//    public static final String COL11 = "b_seek";
//    public static final String COL12 = "unit";
    public static final String TableName = "user";
    public static final String COL1 = "uid";
    public static final String COL2 = "name";
    public static final String COL3 = "email";
    public static final String COL4 = "password";
    public static final String COL5 = "contact";
    public static final String COL6 = "bloodgrp";
    public static final String COL7 = "dob";



    public DatabaseHelper(Context context) {
        super(context,Databasename, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("create table "+ TableName1+ "(blood_group varchar(5),units int)");
        sqLiteDatabase.execSQL("create table "+ TableName+"(uid integer primary key autoincrement,name text,email text,password text,contact text,bloodgrp text,dob text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table "+ TableName );

        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String name,String email, String password, String contact,String bloodgrp, String dob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,email);
        contentValues.put(COL4,password);
        contentValues.put(COL5,contact);
        contentValues.put(COL6,bloodgrp);
        contentValues.put(COL7,dob);

        long result = db.insert(TableName,null,contentValues);
        if(result == -1)
        return false;
        else {
            return true;
        }

    }
//    public boolean insertseeker(String blood_grp,Integer unit){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues1 = new ContentValues();
//        contentValues1.put(COL11,blood_grp);
//        contentValues1.put(COL12,unit);
//        long res= db.insert(TableName1,null,contentValues1);
//        if(res!=-1)
//            return true;
//        else
//            return false;
//    }
   public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TableName,null);
        return res;
    }
//    public Cursor getseekerdata()
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from "+ TableName1 ,null);
//        return res;
//    }
    public Cursor checkLogin(String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TableName,null);
        return res;
    }
}

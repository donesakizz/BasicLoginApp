package com.example.instagrambenzeriodev1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "userdata",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Userdetails(username TEXT primary key,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists Userdetails");
    }

    public Boolean insertdata(String username ,String password){
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username" ,username);
        contentValues.put("password",password);
        long result =DB.insert("userdetails",null,contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }


    public Boolean checkusername(String username){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where username=?",new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean checkusernamepassword(String username,String password) {
        SQLiteDatabase DB =this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where username=? and password=?" ,new String[] {username , password} );
        if(cursor.getCount() >0){
            return false;
        }
        else {
            return false;
        }
    }
}

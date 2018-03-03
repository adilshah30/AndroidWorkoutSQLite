package com.adilshah.adil.androidworkoutsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Admin on 29/01/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;

    private static final int DATABSE_VERSION= 1;
    private static final String DATABASE_NAME = "android_workout.db";
    private static final String TABLE_NAME_USER = "user";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_FULLNAME = "fullname";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD ="password";
    private static final String COLUMN_EMAIL =  "email";
    private static final String COLUMN_AGE = "age";



    private static final String TABLE_CREATE_USER = "CREATE TABLE "+TABLE_NAME_USER +" (ID INTEGER PRIMARY KEY NOT NULL ,"+
            "fullname TEXT NOT NULL, username TEXT NOT NULL,password TEXT NOT NULL, email TEXT, age TEXT );";


    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USER);
        this.db= db;
    }

    public boolean registerUser(user u){

        boolean status = false ;
        Long getEntryStatus;

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FULLNAME,u.getFullname());
        values.put(COLUMN_USERNAME, u.getUsername());
        values.put(COLUMN_PASSWORD,u.getPassword());
        values.put(COLUMN_EMAIL,u.getEmail());
        values.put(COLUMN_AGE,u.getAge());

        getEntryStatus = db.insert(TABLE_NAME_USER,null,values);
        Log.d("Request", "Request Comes here");
        if(getEntryStatus.equals(-1)){
            return status =  false;

        }else{
           return status =  true;
        }


    }

    public String authenticateLogin(String username){

        db = this.getReadableDatabase();
        String query = "SELECT username , password FROM "+TABLE_NAME_USER;
        Cursor resultCursor = db.rawQuery(query,null);

        String dbusername , dbpassword;
        dbpassword = "Invalid Username/Password";

        if(resultCursor != null){
            if (resultCursor.moveToFirst()){
                do {
                    dbusername = resultCursor.getString(0);
                    if (dbusername.equals(username)){
                        dbpassword = resultCursor.getString(1);
                    }

                }
                while (resultCursor.moveToNext());
            }
        }

        return dbpassword;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP IF EXISTS "+TABLE_NAME_USER;
        db.execSQL(query);
        this.onCreate(db);
    }
}

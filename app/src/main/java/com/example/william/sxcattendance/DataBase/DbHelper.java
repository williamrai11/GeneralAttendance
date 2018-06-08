package com.example.william.sxcattendance.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by william on 3/21/18.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sxcAttend.db";
    private static final int DATABASE_VERSION = 1;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(DbContract.DepartmentEntry.SQL_CREATE_TABLE);
        db.execSQL(DbContract.SemesterEntry.SQL_CREATE_TABLE);
        db.execSQL(DbContract.StudentsEntry.SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {


          //  db.execSQL("ALTER TABLE schedules ADD COLUMN position");

        }



    }
}

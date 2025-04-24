package com.example.androidpracticals

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class MyDBHelper(context: Context) : SQLiteOpenHelper(context,"USERDB",null,1) {

    companion object {
        var TABLE_NAME = "USERS"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE TABLE_NAME (USERID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASS TEXT)")
        db?.execSQL("INSERT INTO TABLE_NAME (UNAME,PASS) VALUES ('NIL','0009')")
        db?.execSQL("INSERT INTO TABLE_NAME (UNAME,PASS) VALUES ('NIL1','0912')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME)
        onCreate(db)
    }


}
package com.example.aoc.databeseexample;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    static final String DB_NAME="mydb";
    static final int DB_CURRENT_VERSION = 1;
    protected SQLiteDatabase db;
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_CURRENT_VERSION);
        open();
    }

    //Когато се опитаме да използваме базата но тя не е  създадена Инициализация на базата данни
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(MainActivity.dbCreate);//Изпълняваме sql  за създаване на базата данни заявката е изнесена в ресурси
        Log.d("D1","Createdb");
    }

    //Когато базата дани вече е създадена и има нова версия примерно да добавим нови полета
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void open() throws SQLException{ // Метод за отваряне на базата данни
        db=getWritableDatabase();
    }

    public void close(){ //Метод за затваряне на базата данни
        db.close();
    }
}

package com.example.aoc.databeseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;


public class DBPref extends DBHelper {

    public DBPref(Context context) {
        super(context);
    }

    public void addRecord(String val){
        ContentValues cv = new ContentValues(); //Правим си обек с който да лагаме в базата
        cv.put("val", val); // В полето val в базата слагаме съответната стойност
        this.db.insert("preferences",null,cv); //Името на базата  обекта който държи стойностите и изпълняваме записа
    }

    public Cursor getVals(){
        return this.db.query("preferences",new String[]{"val"},null,null,null,null,null); //Изпълняваме sql то си пише кое е where, order by и т.н.
    }

    public boolean delete(String name)
    {
       return db.delete("preferences","val=?",new String[]{name}) > 0;
    }
}

package com.exerciseapp.mattiapalmas.solovegan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mattia palmas on 2017-12-13.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Components.db";
    public static final String TABLE_NAME = "Components_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "IS_VEGAN";
    public static final String COL_5 = "IS_NOT_VEGAN";
    public static final String COL_6 = "CAN_BE_BOTH";
    public static final String COL_7 = "TYPE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 + " TEXT, " + COL_3 + " TEXT, " + COL_4 + " BOOLEAN, " + COL_5 + " BOOLEAN, " + COL_6 + " BOOLEAN, " + COL_7 + " TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String name, String description, boolean is_vegan, boolean is_not_vegan, boolean can_be_both, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, is_vegan);
        contentValues.put(COL_5, is_not_vegan);
        contentValues.put(COL_6, can_be_both);
        contentValues.put(COL_7, type);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public ArrayList<String> getAllRecordsName() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<String> componentNames = new ArrayList<>();
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                componentNames.add(cursor.getString(1));
            }
        }
        cursor.close();
        database.close();
        return componentNames;
    }

    public ArrayList<String> getFoodsRecordsName() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_7 + " = 'food'", null);
        ArrayList<String> componentNames = new ArrayList<>();
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                componentNames.add(cursor.getString(1));
            }
        }
        cursor.close();
        database.close();
        return componentNames;
    }

    public ArrayList<String> onSearchApply(String searchText) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_2 + " LIKE '" + searchText + "%'", null);
        ArrayList<String> componentNames = new ArrayList<>();
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                componentNames.add(cursor.getString(1));
            }
        }
        cursor.close();
        database.close();
        return componentNames;
    }
}

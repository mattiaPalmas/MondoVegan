package com.exerciseapp.mattiapalmas.solovegan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by mattia palmas on 2017-12-13.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Vegan.db";

    public static final String TABLE_COMPONENTS = "Components_table";
    public static final String COMPONENTS_ID = "ID";
    public static final String COMPONENTS_NAME = "NAME";
    public static final String COMPONENTS_DESC = "DESCRIPTION";
    public static final String COMPONENTS_IS_VEGAN = "IS_VEGAN";
    public static final String COMPONENTS_IS_NOT_VEGAN = "IS_NOT_VEGAN";
    public static final String COMPONENTS_CAN_BE_NOTH = "CAN_BE_BOTH";
    public static final String COMPONENTS_TYPE = "TYPE";

    public static final String TABLE_BRANDS = "Brands_table";
    public static final String BRANDS_ID = "BRANDS_ID";
    public static final String BRANDS_NAME = "BRANDS_NAME";
    public static final String BRANDS_CATEGORIES = "BRANDS_CATEGORIES";
    public static final String BRANDS_TYPE = "BRANDS_TYPE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_COMPONENTS + "(" + COMPONENTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COMPONENTS_NAME + " TEXT, " + COMPONENTS_DESC + " TEXT, " + COMPONENTS_IS_VEGAN + " BOOLEAN, " + COMPONENTS_IS_NOT_VEGAN + " BOOLEAN, " + COMPONENTS_CAN_BE_NOTH + " BOOLEAN, " + COMPONENTS_TYPE + " TEXT)");
        db.execSQL("create table " + TABLE_BRANDS + "(" + BRANDS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BRANDS_NAME + " TEXT, " + BRANDS_CATEGORIES + " TEXT, " + BRANDS_TYPE + " TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPONENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRANDS);
        onCreate(db);
    }


    public boolean insertComponentsData(String name, String description, boolean is_vegan, boolean is_not_vegan, boolean can_be_both, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COMPONENTS_NAME, name);
        contentValues.put(COMPONENTS_DESC, description);
        contentValues.put(COMPONENTS_IS_VEGAN, is_vegan);
        contentValues.put(COMPONENTS_IS_NOT_VEGAN, is_not_vegan);
        contentValues.put(COMPONENTS_CAN_BE_NOTH, can_be_both);
        contentValues.put(COMPONENTS_TYPE, type);
        long result = db.insert(TABLE_COMPONENTS, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertBrandsData(String name, String category, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BRANDS_NAME, name);
        contentValues.put(BRANDS_CATEGORIES, category);
        contentValues.put(BRANDS_TYPE, type);
        long result = db.insert(TABLE_BRANDS, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllComponents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_COMPONENTS, null);
        return res;
    }

    public Cursor getAllBrands() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_BRANDS, null);
        return res;
    }

    public ArrayList<String> getAllDataFromDataBase(String query) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        return  loopThroughDatas(cursor,database);
    }

    public ArrayList<String> onSearchComponentsApply(String searchText, String category) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_COMPONENTS + " WHERE " + COMPONENTS_NAME + " LIKE '%" + searchText + "%'" + category, null);
        return  loopThroughDatas(cursor,database);
    }

    public ArrayList<String> onSearchBrandsApply(String searchText) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_BRANDS + " WHERE " + BRANDS_NAME.toLowerCase() + " LIKE '" + searchText.toLowerCase() + "%'", null);
        loopThroughDatas(cursor,database);
        return  loopThroughDatas(cursor,database);
    }

    public ArrayList<String> getDetailsComponent(String query) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        ArrayList<String> componentNames = new ArrayList<>();
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                componentNames.add(cursor.getString(1));
                componentNames.add(cursor.getString(2));
                componentNames.add(cursor.getString(3));
                componentNames.add(cursor.getString(4));
                componentNames.add(cursor.getString(5));

            }
        }
        cursor.close();
        database.close();
        return componentNames;
    }

    private ArrayList<String> loopThroughDatas(Cursor cursor,SQLiteDatabase database){
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

    public ArrayList<String> getBrandsByCategoryType(String type){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_BRANDS + " WHERE " + BRANDS_TYPE + " = '" + type+"'", null);
        return  loopThroughDatas(cursor,database);
    }
}

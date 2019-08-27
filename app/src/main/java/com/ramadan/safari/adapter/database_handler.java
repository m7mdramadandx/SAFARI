package com.ramadan.safari.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class database_handler extends SQLiteOpenHelper {
    protected static final String safari_database = "safari.db";
    protected static final int version = 2;
    protected static final String user_table = "User";
    protected static final String create_user_table = "create table user (phone int(11) primary key, full_name text, age int(2), password text)";
    protected static final String drop_user_table = "drop table if exists user";
    ////////////////////////////////////////////////////////////////////////////////////////////
    protected static final String offer_table = "Hotel_blog";
    protected static final String create_offer_table = "create table offer (offer_id text primary key, hotel_name text, location text, duration text, transportation text, rate float, cost int)";
    protected static final String drop_offer_table = "drop table if exists offer ";
    private Context context;

    public database_handler(Context context) {
        super(context, safari_database, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(create_user_table);
            sqLiteDatabase.execSQL(create_offer_table);
        } catch (SQLException e) {
            Toast.makeText(context, "error in creating database", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            sqLiteDatabase.execSQL(drop_user_table);
            sqLiteDatabase.execSQL(drop_offer_table);
            onCreate(sqLiteDatabase);
        } catch (SQLException e) {
            Toast.makeText(context, "error in upgrading database", Toast.LENGTH_SHORT).show();
        }
    }

    public void insert_user(int phone, String full_name, int age, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("full_name", full_name);
        contentValues.put("age", age);
        contentValues.put("password", password);
        db.insert(user_table, null, contentValues);
        db.close();
    }

    public boolean search_user(int phone, String password) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where phone = " + phone + " and password = " + password + " ", null);
        boolean result = false;
        if (cursor.moveToNext()) {
            result = true;
        }
        return result;
    }

    ///////////////////////////////////////----OFFER ROLE----//////////////////////////////////////

    public void insert_offer(String offer_id, String hotel_name, String location, String duration, String transportation, float rate, int cost) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("offer_id", offer_id);
        contentValues.put("hotel_name", hotel_name);
        contentValues.put("location", location);
        contentValues.put("duration", duration);
        contentValues.put("rate", rate);
        contentValues.put("transportation", transportation);
        contentValues.put("cost", cost);
        db.insert(offer_table, null, contentValues);
        db.close();
    }

    public String search_offer(String offer_id) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from offer where offer_id = ?", new String[]{offer_id});
        String offer = null;
        if (cursor.moveToNext()) {
            String offer_id_ = cursor.getString(cursor.getColumnIndex("offer_id"));
            String hotel_name_ = cursor.getString(cursor.getColumnIndex("hotel_name"));
            String location_ = cursor.getString(cursor.getColumnIndex("location"));
            String duration_ = cursor.getString(cursor.getColumnIndex("duration"));
            String transportation_ = cursor.getString(cursor.getColumnIndex("transportation"));
            float rate_ = Float.parseFloat(cursor.getString(cursor.getColumnIndex("rate")));
            int cost_ = Integer.parseInt(cursor.getString(cursor.getColumnIndex("cost")));
            offer = offer_id_ + " is exist" + "\n" + hotel_name_ + " | " + location_ + " | " + duration_ + " | " + transportation_ + " | " + rate_ + " | " + cost_;
        } else {
            offer = offer_id + " is not exist";
        }
        return offer;
    }

    public boolean update_offer(String offer_id, String hotel_name, String location, String duration, String transportation, float rate, int cost) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("offer_id", offer_id);
        contentValues.put("hotel_name", hotel_name);
        contentValues.put("location", location);
        contentValues.put("duration", duration);
        contentValues.put("rate", rate);
        contentValues.put("transportation", transportation);
        contentValues.put("cost", cost);
        long result = sqLiteDatabase.update(offer_table, contentValues, " offer_id= ?", new String[]{offer_id});
        return result > 0;
    }

    public boolean delete_offer(String offer_id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long result = sqLiteDatabase.delete(offer_table, "offer_id=?", new String[]{offer_id});
        return result > 0;
    }


    public ArrayList get_offer() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" select * from offer ;", null);
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            String offer_id = cursor.getString(cursor.getColumnIndex("offer_id"));
            String hotel_name = cursor.getString(cursor.getColumnIndex("hotel_name"));
            String location = cursor.getString(cursor.getColumnIndex("location"));
            String duration = cursor.getString(cursor.getColumnIndex("duration"));
            String transportation = cursor.getString(cursor.getColumnIndex("transportation"));
            float rate = Float.parseFloat(cursor.getString(cursor.getColumnIndex("rate")));
            int cost = Integer.parseInt(cursor.getString(cursor.getColumnIndex("cost")));
            arrayList.add(offer_id + " | " + hotel_name + " | " + location + " | " + duration + " | " + transportation + " | " + rate + " | " + cost);
        }
        return arrayList;
    }


}

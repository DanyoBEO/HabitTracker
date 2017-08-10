package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 3/25/2017.
 */

public class HabitHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HabitTracker";
    Context context;

    public HabitHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HabitContract.Table1.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionOld, int versionNew) {
        context.deleteDatabase(DATABASE_NAME);
        onCreate(db);
    }

    void addHabit(HabitDetails habitDetails) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitContract.Table1.KEY_TITLE, habitDetails.getHabitTitle());
        values.put(HabitContract.Table1.KEY_FREQUENCY, habitDetails.getHabitFrequency());

        db.insert(HabitContract.Table1.TABLE_NAME, null, values);
        db.close();
    }

    public Cursor getDetails(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(HabitContract.Table1.TABLE_NAME, new String[]{HabitContract.Table1.KEY_ID,
                        HabitContract.Table1.KEY_TITLE, HabitContract.Table1.KEY_FREQUENCY}, HabitContract.Table1.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    public void updateHabitRow(double rowId, String title, String frequency) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.Table1.KEY_TITLE, title);
        values.put(HabitContract.Table1.KEY_FREQUENCY, frequency);
        db.update(HabitContract.Table1.TABLE_NAME, values, HabitContract.Table1.KEY_ID + "=" + rowId, null);

    }

    // Deleting single habit from the table
    public void deleteHabitTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + HabitContract.Table1.TABLE_NAME);
    }


}

package com.example.android.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitHandler db = new HabitHandler(this);
        Log.v("DB", "OK");
        Log.v("Query: ", HabitContract.Table1.CREATE_TABLE);



        Log.d("Insert: ", "Inserting ..");

        Log.d("Reading: ", "Reading contacts..");
        db.addHabit(new HabitDetails("Work", 8));
        db.addHabit(new HabitDetails("Sleep", 5));
        db.addHabit(new HabitDetails("Video Game", 2));

        Cursor c = db.getDetails(2);
        HabitDetails H = new HabitDetails(c.getString(1), Integer.parseInt(c.getString(2)));

        Log.d("Reading: ", "Reading contacts..");
        Log.v("Update: ", H.getHabitTitle() + " " + H.getHabitFrequency());
    }
}

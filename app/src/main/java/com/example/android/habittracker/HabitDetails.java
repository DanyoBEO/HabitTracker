package com.example.android.habittracker;

/**
 * Created by Daniel on 3/25/2017.
 */

public class HabitDetails {
    int habitID;
    String habitTitle;
    int habitFrequency;

    public HabitDetails(String habitTitle, int habitFrequency) {
        this.habitTitle = habitTitle;
        this.habitFrequency = habitFrequency;
    }

    public int getHabitID() {
        return habitID;
    }

    public void setHabitID(int habitID) {
        this.habitID = habitID;
    }

    public String getHabitTitle() {
        return habitTitle;
    }

    public void setHabitTitle(String habitTitle) {
        this.habitTitle = habitTitle;
    }

    public int getHabitFrequency() {
        return habitFrequency;
    }

    public void setHabitFrequency(int habitFrequency) {
        this.habitFrequency = habitFrequency;
    }
}

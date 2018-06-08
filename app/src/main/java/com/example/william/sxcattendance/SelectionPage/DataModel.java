package com.example.william.sxcattendance.SelectionPage;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DataModel {

    public static ArrayList<String> getDatas(){
        ArrayList<String> semester = new ArrayList<>();
        semester.add("1st Semester");
        semester.add("3rd Semester");
        semester.add("5th Semester");
        semester.add("7th Semester");

        return semester;
    }


}

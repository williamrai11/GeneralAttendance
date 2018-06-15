package com.example.william.sxcattendance.AttendancePage.Util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.william.sxcattendance.AttendancePage.Util.StaticDatas.suffixes;

public class Helper {

    public static String getCurrentDate(){

        Date today = Calendar.getInstance().getTime();
        // (2) create a date "formatter" (the date format we want)
        SimpleDateFormat formatter = new SimpleDateFormat("MMM d");
        // (3) create a new String using the date format we want
        String  cD = formatter.format(today);

        /********get date ordinal indicator*************/
        Date date = new Date();
        SimpleDateFormat formatDayOfMonth  = new SimpleDateFormat("d");;
        String day = formatDayOfMonth.format(date);
        String dayStr =  suffixes[Integer.parseInt(day)];
        Log.d("yes", "getCurrentDay: "+dayStr);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y");
        String year = simpleDateFormat.format(date);
        Log.d("yes", "getCurrentDay: "+year);


        String newDate = cD +dayStr+" "+year;


        return newDate;
    }

    /***********getCurrentDate***********/
    public static String getDate(){
        Date today = Calendar.getInstance().getTime();
        // (2) create a date "formatter" (the date format we want)
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // (3) create a new String using the date format we want
        String  cD = formatter.format(today);

        return cD;
    }



}

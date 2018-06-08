package com.example.william.sxcattendance.root;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;


import com.facebook.stetho.Stetho;

/**
 * Created by william on 3/4/18.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();



        Stetho.initializeWithDefaults(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);


    }

}

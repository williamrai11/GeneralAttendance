package com.example.william.sxcattendance.Network.Util;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Created by william on 2/3/18.
 */

public  final class ConnectionDetector {

    private static Context context;

    public ConnectionDetector(Context context){
        this.context = context;
    }

    public static boolean isConnected(Context context){
        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info!=null){
                if(info.getState()== NetworkInfo.State.CONNECTED)
                    return true;
            }

        }

        return false;
    }

}

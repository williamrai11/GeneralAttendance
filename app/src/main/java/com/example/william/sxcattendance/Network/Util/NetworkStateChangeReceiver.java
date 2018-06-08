package com.example.william.sxcattendance.Network.Util;

/**
 * Created by william on 2/4/18.
 */

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class NetworkStateChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


    }

    public boolean isNetworAvailable(Context context, int[] typeNetworks){
        try {
             ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
            for(int typeNetwork: typeNetworks){
                NetworkInfo networkInfo = cm.getNetworkInfo(typeNetwork);
                if(networkInfo!=null && networkInfo.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }

        }catch (Exception e){
            return  false;
        }
            return false;
    }
}
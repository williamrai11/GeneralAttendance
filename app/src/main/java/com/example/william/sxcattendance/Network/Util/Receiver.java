package com.example.william.sxcattendance.Network.Util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

public final class Receiver {

    private static BroadcastReceiver broadcastReceiver;

    public static void CheckInternetActivity(Context context) {
        IntentFilter intentFilter =
                new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");

        final NetworkStateChangeReceiver networkStateChangeReceiver = new NetworkStateChangeReceiver();
        final int type[] = {ConnectivityManager.TYPE_MOBILE, ConnectivityManager.TYPE_WIFI};

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (networkStateChangeReceiver.isNetworAvailable(context, type) == true) {


                }

            }
       };

        context.registerReceiver(broadcastReceiver,intentFilter);

    }

}

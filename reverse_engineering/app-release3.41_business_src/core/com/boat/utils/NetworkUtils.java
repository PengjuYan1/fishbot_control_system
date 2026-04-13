package com.boat.utils;
public class NetworkUtils {

    public NetworkUtils()
    {
        return;
    }

    public static boolean isConnected(android.content.Context p3)
    {
        if (p3 != null) {
            android.net.ConnectivityManager v1_2 = ((android.net.ConnectivityManager) p3.getSystemService("connectivity"));
            if (v1_2 != null) {
                android.net.NetworkInfo v2 = v1_2.getActiveNetworkInfo();
                if (v2 != null) {
                    return v2.isAvailable();
                }
            } else {
                return 0;
            }
        }
        return 0;
    }

    public static boolean isNetworkAvailable(android.content.Context p5)
    {
        android.net.ConnectivityManager v0_2 = ((android.net.ConnectivityManager) p5.getSystemService("connectivity"));
        if (v0_2 != null) {
            int v1_1 = v0_2.getAllNetworkInfo();
            if (v1_1 != 0) {
                int v2 = 0;
                while (v2 < v1_1.length) {
                    if (v1_1[v2].getState() != android.net.NetworkInfo$State.CONNECTED) {
                        v2++;
                    } else {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}

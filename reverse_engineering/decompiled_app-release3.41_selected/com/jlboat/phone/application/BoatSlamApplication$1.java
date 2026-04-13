package com.jlboat.phone.application;
 class BoatSlamApplication$1 extends android.net.ConnectivityManager$NetworkCallback {
    final synthetic android.net.ConnectivityManager val$connectivityManager;

    BoatSlamApplication$1(android.net.ConnectivityManager p1)
    {
        this.val$connectivityManager = p1;
        return;
    }

    public void onAvailable(android.net.Network p3)
    {
        super.onAvailable(p3);
        android.util.Log.i("test", "\u5df2\u6839\u636e\u529f\u80fd\u548c\u4f20\u8f93\u7c7b\u578b\u627e\u5230\u5408\u9002\u7684\u7f51\u7edc");
        android.net.ConnectivityManager.setProcessDefaultNetwork(p3);
        this.val$connectivityManager.unregisterNetworkCallback(this);
        return;
    }
}

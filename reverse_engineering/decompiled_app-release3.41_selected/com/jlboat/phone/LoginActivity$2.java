package com.jlboat.phone;
 class LoginActivity$2 extends android.net.ConnectivityManager$NetworkCallback {
    final synthetic com.jlboat.phone.LoginActivity this$0;
    final synthetic android.net.ConnectivityManager val$connectivityManager;

    LoginActivity$2(com.jlboat.phone.LoginActivity p1, android.net.ConnectivityManager p2)
    {
        this.this$0 = p1;
        this.val$connectivityManager = p2;
        return;
    }

    public void onAvailable(android.net.Network p3)
    {
        super.onAvailable(p3);
        android.net.ConnectivityManager.setProcessDefaultNetwork(p3);
        this.val$connectivityManager.unregisterNetworkCallback(this);
        android.util.Log.d("LoginActivity", "onAvailable:  \u8bbe\u7f6e\u6d41\u91cf");
        return;
    }

    public void onLost(android.net.Network p1)
    {
        super.onLost(p1);
        return;
    }
}

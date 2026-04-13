package com.jlboat.phone;
 class LoginActivity$4 extends android.net.ConnectivityManager$NetworkCallback {
    final synthetic com.jlboat.phone.LoginActivity this$0;
    final synthetic android.net.ConnectivityManager val$connectivityManager;
    final synthetic boolean val$isIntent;

    LoginActivity$4(com.jlboat.phone.LoginActivity p1, android.net.ConnectivityManager p2, boolean p3)
    {
        this.this$0 = p1;
        this.val$connectivityManager = p2;
        this.val$isIntent = p3;
        return;
    }

    public void onAvailable(android.net.Network p3)
    {
        super.onAvailable(p3);
        android.net.ConnectivityManager.setProcessDefaultNetwork(p3);
        this.val$connectivityManager.unregisterNetworkCallback(this);
        android.util.Log.d("LoginActivity", "onAvailable:  \u8bbe\u7f6ewifi");
        if (this.val$isIntent) {
            android.util.Log.d("LoginActivity", "onAvailable:  \u8bbe\u7f6ewifi 2");
            com.jlboat.phone.LoginActivity.access$000(this.this$0);
        }
        return;
    }
}

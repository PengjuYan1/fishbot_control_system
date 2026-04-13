package com.jlboat.phone.activity;
 class RobotWifiActivity$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotWifiActivity this$0;

    RobotWifiActivity$1(com.jlboat.phone.activity.RobotWifiActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p3)
    {
        android.util.Log.d(com.jlboat.phone.activity.RobotWifiActivity.access$000(this.this$0), "\u53d1\u9001\u6210\u529f onNewMessage: ");
        this.this$0.toast("\u53d1\u9001\u6210\u529f");
        this.this$0.runOnUiThread(new com.jlboat.phone.activity.RobotWifiActivity$1$1(this));
        return;
    }
}

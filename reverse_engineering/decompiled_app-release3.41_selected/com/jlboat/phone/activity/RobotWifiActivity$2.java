package com.jlboat.phone.activity;
 class RobotWifiActivity$2 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.RobotWifiActivity this$0;
    final synthetic String val$text;

    RobotWifiActivity$2(com.jlboat.phone.activity.RobotWifiActivity p1, String p2)
    {
        this.this$0 = p1;
        this.val$text = p2;
        return;
    }

    public void run()
    {
        this.this$0.send.setEnabled(1);
        android.widget.Toast.makeText(this.this$0, this.val$text, 0).show();
        return;
    }
}

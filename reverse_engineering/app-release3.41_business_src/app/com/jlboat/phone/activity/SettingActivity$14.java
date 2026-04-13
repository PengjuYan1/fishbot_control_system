package com.jlboat.phone.activity;
 class SettingActivity$14 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;
    final synthetic String val$text;

    SettingActivity$14(com.jlboat.phone.activity.SettingActivity p1, String p2)
    {
        this.this$0 = p1;
        this.val$text = p2;
        return;
    }

    public void run()
    {
        android.widget.Toast.makeText(this.this$0, this.val$text, 0).show();
        return;
    }
}

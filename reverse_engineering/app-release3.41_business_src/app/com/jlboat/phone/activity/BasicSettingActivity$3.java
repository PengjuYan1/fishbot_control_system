package com.jlboat.phone.activity;
 class BasicSettingActivity$3 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.BasicSettingActivity this$0;
    final synthetic String val$text;

    BasicSettingActivity$3(com.jlboat.phone.activity.BasicSettingActivity p1, String p2)
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

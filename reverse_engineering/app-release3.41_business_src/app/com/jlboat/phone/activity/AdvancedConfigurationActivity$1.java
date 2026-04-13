package com.jlboat.phone.activity;
 class AdvancedConfigurationActivity$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.AdvancedConfigurationActivity this$0;
    final synthetic String val$text;

    AdvancedConfigurationActivity$1(com.jlboat.phone.activity.AdvancedConfigurationActivity p1, String p2)
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

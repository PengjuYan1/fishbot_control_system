package com.jlboat.phone.activity;
 class ErrorMessageActivity$2 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.ErrorMessageActivity this$0;
    final synthetic String val$text;

    ErrorMessageActivity$2(com.jlboat.phone.activity.ErrorMessageActivity p1, String p2)
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

package com.jlboat.phone;
 class LoginActivity$5 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.LoginActivity this$0;
    final synthetic String val$text;

    LoginActivity$5(com.jlboat.phone.LoginActivity p1, String p2)
    {
        this.this$0 = p1;
        this.val$text = p2;
        return;
    }

    public void run()
    {
        android.widget.Toast.makeText(this.this$0.mContext.getApplicationContext(), this.val$text, 0).show();
        return;
    }
}

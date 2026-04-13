package com.jlboat.phone.base;
 class BaseFullActivity$4 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.base.BaseFullActivity this$0;
    final synthetic CharSequence val$text;

    BaseFullActivity$4(com.jlboat.phone.base.BaseFullActivity p1, CharSequence p2)
    {
        this.this$0 = p1;
        this.val$text = p2;
        return;
    }

    public void run()
    {
        android.widget.Toast.makeText(this.this$0.getBaseContext().getApplicationContext(), this.val$text, 0).show();
        return;
    }
}

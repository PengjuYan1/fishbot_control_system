package com.jlboat.phone;
 class LoginActivity$3 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.LoginActivity this$0;
    final synthetic boolean val$isIntent;

    LoginActivity$3(com.jlboat.phone.LoginActivity p1, boolean p2)
    {
        this.this$0 = p1;
        this.val$isIntent = p2;
        return;
    }

    public void run()
    {
        try {
            Thread.sleep(200);
        } catch (com.jlboat.phone.LoginActivity v0_1) {
            v0_1.printStackTrace();
        }
        this.this$0.setNetWorkManager2(this.val$isIntent);
        return;
    }
}

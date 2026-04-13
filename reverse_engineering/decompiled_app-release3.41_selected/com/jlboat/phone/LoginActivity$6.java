package com.jlboat.phone;
 class LoginActivity$6 implements android.content.DialogInterface$OnClickListener {
    final synthetic com.jlboat.phone.LoginActivity this$0;

    LoginActivity$6(com.jlboat.phone.LoginActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(android.content.DialogInterface p4, int p5)
    {
        android.content.Intent v0_1 = new android.content.Intent();
        v0_1.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        v0_1.addCategory("android.intent.category.DEFAULT");
        v0_1.setData(android.net.Uri.parse(new StringBuilder().append("package:").append(this.this$0.getPackageName()).toString()));
        v0_1.addFlags(268435456);
        v0_1.addFlags(1073741824);
        v0_1.addFlags(8388608);
        this.this$0.startActivity(v0_1);
        return;
    }
}

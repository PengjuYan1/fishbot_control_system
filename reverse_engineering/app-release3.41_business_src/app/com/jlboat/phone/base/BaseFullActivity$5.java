package com.jlboat.phone.base;
 class BaseFullActivity$5 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.base.BaseFullActivity this$0;

    BaseFullActivity$5(com.jlboat.phone.base.BaseFullActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(android.view.View p4)
    {
        this.this$0.startActivity(new android.content.Intent(this.this$0, com.jlboat.phone.activity.ErrorMessageActivity));
        return;
    }
}

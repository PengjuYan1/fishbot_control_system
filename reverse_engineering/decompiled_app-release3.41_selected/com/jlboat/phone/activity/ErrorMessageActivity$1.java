package com.jlboat.phone.activity;
 class ErrorMessageActivity$1 extends android.content.BroadcastReceiver {
    final synthetic com.jlboat.phone.activity.ErrorMessageActivity this$0;

    ErrorMessageActivity$1(com.jlboat.phone.activity.ErrorMessageActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onReceive(android.content.Context p3, android.content.Intent p4)
    {
        if ("ERRMSG_UPDATE".equals(p4.getAction())) {
            com.jlboat.phone.activity.ErrorMessageActivity.access$000(this.this$0);
        }
        return;
    }
}

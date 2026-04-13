package com.jlboat.phone.activity;
 class TestResultActivity202508$2$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.TestResultActivity202508$2 this$1;
    final synthetic com.boat.jrosbridge.message.std_msgs.Int32 val$message;

    TestResultActivity202508$2$1(com.jlboat.phone.activity.TestResultActivity202508$2 p1, com.boat.jrosbridge.message.std_msgs.Int32 p2)
    {
        this.this$1 = p1;
        this.val$message = p2;
        return;
    }

    public void run()
    {
        com.jlboat.phone.activity.TestResultActivity202508.access$500(this.this$1.this$0).setText(new StringBuilder().append(this.val$message.getData()).append("").toString());
        return;
    }
}

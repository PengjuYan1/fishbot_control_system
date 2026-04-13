package com.jlboat.phone.activity;
 class TestResultActivity202508$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.TestResultActivity202508 this$0;

    TestResultActivity202508$2(com.jlboat.phone.activity.TestResultActivity202508 p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int32) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int32 p3)
    {
        android.util.Log.d("TestResultActivity", new StringBuilder().append("onNewMessage: time ").append(p3.getData()).toString());
        if (p3.getData() >= 0) {
            com.jlboat.phone.activity.TestResultActivity202508.access$500(this.this$0).post(new com.jlboat.phone.activity.TestResultActivity202508$2$1(this, p3));
        }
        return;
    }
}

package com.jlboat.phone.activity;
 class TestResultActivity$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.TestResultActivity this$0;

    TestResultActivity$2(com.jlboat.phone.activity.TestResultActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetNaviTestResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetNaviTestResponse p1)
    {
        return;
    }
}

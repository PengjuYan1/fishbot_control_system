package com.jlboat.phone.activity;
 class DiyPointPathActivity$12 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;

    DiyPointPathActivity$12(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.PointMaunSetResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.PointMaunSetResponse p4)
    {
        android.util.Log.d("DiyPointPathActivity", new StringBuilder().append("onNewMessage: addMenuPoint \u6307\u4ee4\u53d1\u9001\u6210\u529f ").append(p4.getResult()).toString());
        return;
    }
}

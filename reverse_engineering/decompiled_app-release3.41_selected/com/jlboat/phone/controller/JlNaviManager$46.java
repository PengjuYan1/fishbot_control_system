package com.jlboat.phone.controller;
 class JlNaviManager$46 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$46(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "topic getWallUpdateMsg: \u6536\u5230\u5730\u56fe\u6570\u636e\u66f4\u65b0");
        this.this$0.getFloor(0);
        return;
    }
}

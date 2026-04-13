package com.jlboat.phone.controller;
 class JlNaviManager$70 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$70(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ScaleTestResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ScaleTestResponse p3)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "onNewMessage: \u81ea\u52a8\u91cd\u5b9a\u4f4d");
        return;
    }
}

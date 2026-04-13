package com.jlboat.phone.controller;
 class JlNaviManager$34 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$34(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ImportConfigSetResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ImportConfigSetResponse p4)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("slamDownLoadMapData: \u901a\u77e5\u5e95\u76d8\u4e0b\u8f7d\u5730\u56fe\u6587\u4ef6 message.status\uff1a").append(p4.status).toString());
        if (p4.status) {
            android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "slamDownLoadMapData: \u5bfc\u822a\u6536\u5230\u4e0b\u8f7d\u5730\u56fe\u6587\u4ef6\u6d88\u606f");
        }
        return;
    }
}

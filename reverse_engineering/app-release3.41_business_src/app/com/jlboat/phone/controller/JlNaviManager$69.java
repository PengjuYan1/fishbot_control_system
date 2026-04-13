package com.jlboat.phone.controller;
 class JlNaviManager$69 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$69(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p4)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("slamDownMapStateMsg: \u5e95\u76d8\u4e0a\u62a5 \u5bfc\u5165\u914d\u7f6e\u6587\u4ef6\u4e0b\u8f7d\u5730\u56fe\u6587\u4ef6\u72b6\u6001\uff1a ").append(p4.data).toString());
        if (p4.data == 0) {
            com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(1032);
        }
        return;
    }
}

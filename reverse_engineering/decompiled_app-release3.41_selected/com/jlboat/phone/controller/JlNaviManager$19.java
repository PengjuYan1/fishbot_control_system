package com.jlboat.phone.controller;
 class JlNaviManager$19 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$19(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SaveMapResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SaveMapResponse p5)
    {
        this.this$0.toast(new StringBuilder().append(this.this$0.getApp().getResources().getString(2131493249)).append("\u64e6\u9664 ").toString());
        return;
    }
}

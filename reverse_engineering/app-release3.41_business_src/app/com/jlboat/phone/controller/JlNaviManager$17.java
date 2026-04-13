package com.jlboat.phone.controller;
 class JlNaviManager$17 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$17(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ClearMapResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ClearMapResponse p3)
    {
        this.this$0.toast("\u6269\u5c55\u5931\u8d25");
        return;
    }
}

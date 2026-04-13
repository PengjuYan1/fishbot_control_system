package com.jlboat.phone.controller;
 class JlNaviManager$43 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$43(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p3)
    {
        com.jlboat.phone.controller.JlNaviManager.access$2102(this.this$0, p3.getData());
        com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(16);
        return;
    }
}

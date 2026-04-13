package com.jlboat.phone.controller;
 class JlNaviManager$30 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$30(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetConfigsResponse p3)
    {
        if (p3.status != 0) {
            this.this$0.toast(2131493305);
        } else {
            this.this$0.toast(2131493306);
        }
        com.jlboat.phone.controller.JlNaviManager.access$3700(this.this$0);
        return;
    }
}

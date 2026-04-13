package com.jlboat.phone.activity;
 class DiyPointPathActivity$10 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;

    DiyPointPathActivity$10(com.jlboat.phone.activity.DiyPointPathActivity p1)
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
            com.jlboat.phone.activity.DiyPointPathActivity.access$2200(this.this$0);
        }
        return;
    }
}

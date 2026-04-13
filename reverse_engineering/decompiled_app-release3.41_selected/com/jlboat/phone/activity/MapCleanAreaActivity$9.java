package com.jlboat.phone.activity;
 class MapCleanAreaActivity$9 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity this$0;
    final synthetic boolean val$isadd;

    MapCleanAreaActivity$9(com.jlboat.phone.activity.MapCleanAreaActivity p1, boolean p2)
    {
        this.this$0 = p1;
        this.val$isadd = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetCleanAreaResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetCleanAreaResponse p3)
    {
        if (!this.val$isadd) {
            this.this$0.toast(2131492917);
        } else {
            this.this$0.toast(2131492918);
        }
        return;
    }
}

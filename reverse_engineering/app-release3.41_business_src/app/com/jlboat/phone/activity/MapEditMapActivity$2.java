package com.jlboat.phone.activity;
 class MapEditMapActivity$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditMapActivity this$0;

    MapEditMapActivity$2(com.jlboat.phone.activity.MapEditMapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SaveMapResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SaveMapResponse p3)
    {
        this.this$0.toast(2131493306);
        return;
    }
}

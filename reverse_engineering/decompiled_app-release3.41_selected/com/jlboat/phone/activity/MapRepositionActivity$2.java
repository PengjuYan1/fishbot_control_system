package com.jlboat.phone.activity;
 class MapRepositionActivity$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapRepositionActivity this$0;

    MapRepositionActivity$2(com.jlboat.phone.activity.MapRepositionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetRelocationResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetRelocationResponse p1)
    {
        return;
    }
}

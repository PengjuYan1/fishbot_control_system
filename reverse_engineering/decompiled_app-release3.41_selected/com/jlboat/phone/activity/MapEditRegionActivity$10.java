package com.jlboat.phone.activity;
 class MapEditRegionActivity$10 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditRegionActivity this$0;

    MapEditRegionActivity$10(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetShapeResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetShapeResponse p3)
    {
        this.this$0.toast(2131493268);
        return;
    }
}

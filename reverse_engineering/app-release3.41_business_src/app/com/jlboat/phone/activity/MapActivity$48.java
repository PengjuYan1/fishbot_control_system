package com.jlboat.phone.activity;
 class MapActivity$48 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$48(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.PointSetResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.PointSetResponse p2)
    {
        com.jlboat.phone.activity.MapActivity.access$4400(this.this$0);
        return;
    }
}

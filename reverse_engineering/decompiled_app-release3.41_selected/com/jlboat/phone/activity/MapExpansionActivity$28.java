package com.jlboat.phone.activity;
 class MapExpansionActivity$28 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;

    MapExpansionActivity$28(com.jlboat.phone.activity.MapExpansionActivity p1)
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
        com.jlboat.phone.activity.MapExpansionActivity.access$1800(this.this$0);
        return;
    }
}

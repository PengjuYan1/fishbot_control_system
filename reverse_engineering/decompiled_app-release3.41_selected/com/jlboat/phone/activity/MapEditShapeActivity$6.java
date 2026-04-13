package com.jlboat.phone.activity;
 class MapEditShapeActivity$6 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditShapeActivity this$0;

    MapEditShapeActivity$6(com.jlboat.phone.activity.MapEditShapeActivity p1)
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
        this.this$0.linesList.clear();
        this.this$0.toast(2131493249);
        return;
    }
}

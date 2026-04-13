package com.jlboat.phone.view;
 class MapView$21 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.view.MapView this$0;

    MapView$21(com.jlboat.phone.view.MapView p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.sensor_msgs.LaserScan) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.sensor_msgs.LaserScan p3)
    {
        com.jlboat.phone.view.MapView.access$700(this.this$0, p3, com.jlboat.phone.view.MapView.access$600(this.this$0));
        return;
    }
}

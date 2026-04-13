package com.jlboat.phone.view;
 class MapView$19 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.view.MapView this$0;

    MapView$19(com.jlboat.phone.view.MapView p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.nav_msgs.OccupancyGrid) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p2)
    {
        com.jlboat.phone.view.MapView.access$300(this.this$0, p2);
        return;
    }
}

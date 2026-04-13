package com.jlboat.phone.communication;
 class MapListener$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.communication.MapListener this$0;

    MapListener$1(com.jlboat.phone.communication.MapListener p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.nav_msgs.OccupancyGrid) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p3)
    {
        if (!this.this$0.isUpdate) {
            this.this$0.isUpdate = 1;
            com.jlboat.phone.communication.MapListener.access$000(this.this$0, p3);
            this.this$0.isUpdate = 0;
        }
        return;
    }
}

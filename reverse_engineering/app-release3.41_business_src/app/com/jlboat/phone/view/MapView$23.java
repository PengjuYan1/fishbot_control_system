package com.jlboat.phone.view;
 class MapView$23 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.view.MapView this$0;

    MapView$23(com.jlboat.phone.view.MapView p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.visualization_msgs.Marker) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.visualization_msgs.Marker p3)
    {
        com.jlboat.phone.view.MapView.access$1602(this.this$0, 1);
        com.jlboat.phone.view.MapView.access$1702(this.this$0, java.util.Arrays.asList(p3.getPoints()));
        this.this$0.post(new com.jlboat.phone.view.MapView$23$1(this));
        if (com.jlboat.phone.view.MapView.access$1800(this.this$0) != null) {
            com.jlboat.phone.view.MapView.access$1800(this.this$0).onPath(com.jlboat.phone.view.MapView.access$1700(this.this$0));
        }
        return;
    }
}

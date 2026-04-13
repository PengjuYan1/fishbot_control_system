package com.jlboat.phone.view;
 class MapView$20 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.view.MapView this$0;

    MapView$20(com.jlboat.phone.view.MapView p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.geometry_msgs.Pose) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.geometry_msgs.Pose p4)
    {
        android.util.Log.d("MapView", new StringBuilder().append("scanPoseSub onNewMessage: ").append(p4.getPosition().getX()).toString());
        com.jlboat.phone.view.MapView.access$402(this.this$0, p4.getPosition().getX());
        com.jlboat.phone.view.MapView.access$502(this.this$0, p4.getPosition().getY());
        return;
    }
}

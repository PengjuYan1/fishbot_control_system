package com.jlboat.phone.activity;
 class MapCleanAreaActivity$8 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity this$0;

    MapCleanAreaActivity$8(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int32) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int32 p3)
    {
        if (this.this$0.mapView != null) {
            this.this$0.mapView.setProhibition(new java.util.LinkedList());
            this.this$0.mapView.setPoints(new java.util.LinkedList());
            this.this$0.mapView.setCleanAreas(new java.util.LinkedList());
        }
        this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapCleanAreaActivity$8$1(this));
        com.jlboat.phone.activity.MapCleanAreaActivity.access$1400(this.this$0).getMapsService(new com.jlboat.phone.activity.MapCleanAreaActivity$8$2(this));
        return;
    }
}

package com.jlboat.phone.activity;
 class MapEditShapeActivity$5 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditShapeActivity this$0;

    MapEditShapeActivity$5(com.jlboat.phone.activity.MapEditShapeActivity p1)
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
            this.this$0.mapView.setProhibition(new java.util.LinkedList());
            this.this$0.mapView.setPoints(new java.util.ArrayList());
            if (this.this$0.shapeListAdapter != null) {
                this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapEditShapeActivity$5$1(this));
            }
        }
        com.jlboat.phone.activity.MapEditShapeActivity.access$1100(this.this$0).getMapsService(new com.jlboat.phone.activity.MapEditShapeActivity$5$2(this));
        return;
    }
}

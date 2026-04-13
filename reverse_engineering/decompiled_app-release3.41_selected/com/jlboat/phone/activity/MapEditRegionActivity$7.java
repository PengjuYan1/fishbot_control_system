package com.jlboat.phone.activity;
 class MapEditRegionActivity$7 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditRegionActivity this$0;

    MapEditRegionActivity$7(com.jlboat.phone.activity.MapEditRegionActivity p1)
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
            this.this$0.mapView.setPoints(new java.util.ArrayList());
            this.this$0.mapView.setRegion(new java.util.LinkedList());
            if (this.this$0.RegionListAdapter != null) {
                this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapEditRegionActivity$7$1(this));
            }
        }
        com.jlboat.phone.activity.MapEditRegionActivity.access$2100(this.this$0).getMapsService(new com.jlboat.phone.activity.MapEditRegionActivity$7$2(this));
        return;
    }
}

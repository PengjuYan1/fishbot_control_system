package com.jlboat.phone.activity;
 class MapEditMapActivity2025$5$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapEditMapActivity2025$5 this$1;
    final synthetic com.boat.jrosbridge.message.nav_msgs.OccupancyGrid val$o;

    MapEditMapActivity2025$5$1(com.jlboat.phone.activity.MapEditMapActivity2025$5 p1, com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p2)
    {
        this.this$1 = p1;
        this.val$o = p2;
        return;
    }

    public void run()
    {
        this.this$1.this$0.mapView.updateMap(this.val$o.getDataS());
        return;
    }
}

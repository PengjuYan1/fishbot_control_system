package com.jlboat.phone.view;
 class MapView$18 extends java.util.TimerTask {
    final synthetic com.jlboat.phone.view.MapView this$0;

    MapView$18(com.jlboat.phone.view.MapView p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        if (com.jlboat.phone.view.MapView.access$000(this.this$0) == 10) {
            com.jlboat.phone.view.MapView.access$100(this.this$0).getAppManager().getNetWorkManager().get(com.jlboat.phone.view.MapView.access$100(this.this$0), com.jlboat.phone.application.BoatSlamApplication.mapApiGetMap, com.boat.jrosbridge.message.nav_msgs.OccupancyGrid, new com.jlboat.phone.view.MapView$18$1(this));
        }
        com.jlboat.phone.view.MapView.access$010(this.this$0);
        if (com.jlboat.phone.view.MapView.access$000(this.this$0) == 0) {
            com.jlboat.phone.view.MapView.access$002(this.this$0, 10);
        }
        return;
    }
}

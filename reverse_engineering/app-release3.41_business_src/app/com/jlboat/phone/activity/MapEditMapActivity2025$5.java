package com.jlboat.phone.activity;
 class MapEditMapActivity2025$5 implements com.boat.manager.NetWorkManager$CallBack {
    final synthetic com.jlboat.phone.activity.MapEditMapActivity2025 this$0;

    MapEditMapActivity2025$5(com.jlboat.phone.activity.MapEditMapActivity2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onError()
    {
        return;
    }

    public void onNetworkDisconnected()
    {
        return;
    }

    public void onSuccess(com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p5)
    {
        com.jlboat.phone.activity.MapEditMapActivity2025.access$100(this.this$0).postDelayed(new com.jlboat.phone.activity.MapEditMapActivity2025$5$1(this, p5), 500);
        return;
    }

    public bridge synthetic void onSuccess(Object p1)
    {
        this.onSuccess(((com.boat.jrosbridge.message.nav_msgs.OccupancyGrid) p1));
        return;
    }
}

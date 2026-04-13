package com.jlboat.phone.view;
 class MapView$18$1 implements com.boat.manager.NetWorkManager$CallBack {
    final synthetic com.jlboat.phone.view.MapView$18 this$1;

    MapView$18$1(com.jlboat.phone.view.MapView$18 p1)
    {
        this.this$1 = p1;
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

    public void onSuccess(com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p2)
    {
        com.jlboat.phone.view.MapView.access$200(this.this$1.this$0, p2);
        return;
    }

    public bridge synthetic void onSuccess(Object p1)
    {
        this.onSuccess(((com.boat.jrosbridge.message.nav_msgs.OccupancyGrid) p1));
        return;
    }
}

package com.jlboat.phone.activity;
 class MapActivity$40 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic com.boat.support.slam.entity.floors.Maps val$map;

    MapActivity$40(com.jlboat.phone.activity.MapActivity p1, com.boat.support.slam.entity.floors.Maps p2)
    {
        this.this$0 = p1;
        this.val$map = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p3)
    {
        android.util.Log.d("MapActivity", new StringBuilder().append("\u7ea7\u8054\u5220\u9664\uff1a\u5730\u56fe").append(this.val$map.getMapName()).append("\u6210\u529f").toString());
        return;
    }
}

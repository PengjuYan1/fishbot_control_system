package com.jlboat.phone.activity;
 class MapActivity$53 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$53(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ScaleTestResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ScaleTestResponse p3)
    {
        android.util.Log.d("MapActivity", "onNewMessage: \u81ea\u52a8\u91cd\u5b9a\u4f4d");
        return;
    }
}

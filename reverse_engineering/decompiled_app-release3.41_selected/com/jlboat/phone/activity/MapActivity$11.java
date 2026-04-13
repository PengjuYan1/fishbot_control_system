package com.jlboat.phone.activity;
 class MapActivity$11 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$11(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.RobotSshResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.RobotSshResponse p4)
    {
        p4.getStatus();
        android.util.Log.d("MapActivity", new StringBuilder().append("onSuccess:reboot ").append(p4.getData()).toString());
        return;
    }
}

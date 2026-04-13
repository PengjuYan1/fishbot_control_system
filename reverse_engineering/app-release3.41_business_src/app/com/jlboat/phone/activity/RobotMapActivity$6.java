package com.jlboat.phone.activity;
 class RobotMapActivity$6 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;

    RobotMapActivity$6(com.jlboat.phone.activity.RobotMapActivity p1)
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
        android.util.Log.d("RobotMapActivity", new StringBuilder().append("onSuccess:reboot").append(p4.getStatus()).toString());
        return;
    }
}

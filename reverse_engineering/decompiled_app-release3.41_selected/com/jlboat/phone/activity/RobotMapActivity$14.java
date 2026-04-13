package com.jlboat.phone.activity;
 class RobotMapActivity$14 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;

    RobotMapActivity$14(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ClearMapResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ClearMapResponse p3)
    {
        com.jlboat.phone.activity.RobotMapActivity.access$302(this.this$0, 1);
        return;
    }
}

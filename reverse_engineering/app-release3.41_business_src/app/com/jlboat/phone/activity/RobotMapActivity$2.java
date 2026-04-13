package com.jlboat.phone.activity;
 class RobotMapActivity$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;

    RobotMapActivity$2(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p3)
    {
        if (com.jlboat.phone.activity.RobotMapActivity.access$300(this.this$0)) {
            com.jlboat.phone.activity.RobotMapActivity.access$302(this.this$0, 0);
            com.jlboat.phone.activity.RobotMapActivity.access$400(this.this$0);
        }
        return;
    }
}

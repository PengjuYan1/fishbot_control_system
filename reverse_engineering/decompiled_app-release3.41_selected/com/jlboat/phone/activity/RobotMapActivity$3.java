package com.jlboat.phone.activity;
 class RobotMapActivity$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;

    RobotMapActivity$3(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int32) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int32 p3)
    {
        if (com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$0) != null) {
            com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$0).setProhibition(new java.util.LinkedList());
            com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$0).setPoints(new java.util.LinkedList());
            com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$0).setGlobalPlans(new java.util.LinkedList());
        }
        com.jlboat.phone.activity.RobotMapActivity.access$1400(this.this$0).getMapsService(new com.jlboat.phone.activity.RobotMapActivity$3$1(this));
        com.jlboat.phone.activity.RobotMapActivity.access$1400(this.this$0).getBuildPointsService(new com.jlboat.phone.activity.RobotMapActivity$3$2(this));
        return;
    }
}

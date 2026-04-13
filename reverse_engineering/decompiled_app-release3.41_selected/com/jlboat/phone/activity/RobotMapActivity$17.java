package com.jlboat.phone.activity;
 class RobotMapActivity$17 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;

    RobotMapActivity$17(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p4)
    {
        com.jlboat.phone.activity.RobotMapActivity.access$2300(this.this$0);
        com.jlboat.phone.activity.RobotMapActivity.access$102(this.this$0, 0);
        com.jlboat.phone.activity.RobotMapActivity.access$1000(this.this$0).clear();
        com.jlboat.phone.activity.RobotMapActivity.access$1300(this.this$0).sendEmptyMessage(1);
        com.jlboat.phone.activity.RobotMapActivity.access$1100(this.this$0).clear();
        com.jlboat.phone.activity.RobotMapActivity.access$1500(this.this$0).clear();
        com.jlboat.phone.activity.RobotMapActivity.access$1600(this.this$0).clear();
        com.jlboat.phone.activity.RobotMapActivity.access$1700(this.this$0).clear();
        com.jlboat.phone.activity.RobotMapActivity.access$2400(this.this$0);
        return;
    }
}

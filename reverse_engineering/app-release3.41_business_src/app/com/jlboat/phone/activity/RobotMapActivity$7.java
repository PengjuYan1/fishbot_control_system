package com.jlboat.phone.activity;
 class RobotMapActivity$7 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;
    final synthetic int val$type;

    RobotMapActivity$7(com.jlboat.phone.activity.RobotMapActivity p1, int p2)
    {
        this.this$0 = p1;
        this.val$type = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p3)
    {
        android.util.Log.i("RobotMapActivity", "loadMap() Success");
        if (this.val$type == 0) {
            com.jlboat.phone.activity.RobotMapActivity.access$302(this.this$0, 1);
        }
        return;
    }
}

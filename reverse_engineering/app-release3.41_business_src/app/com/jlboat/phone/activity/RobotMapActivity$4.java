package com.jlboat.phone.activity;
 class RobotMapActivity$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;

    RobotMapActivity$4(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p4)
    {
        short v0 = p4.getData();
        android.util.Log.d("RobotMapActivity", new StringBuilder().append("topic getMapBuildStatusMsg: ").append(v0).toString());
        com.jlboat.phone.activity.RobotMapActivity.access$902(v0);
        if (com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$0) != null) {
            int v2_1;
            com.jlboat.phone.view.MapView vtmp8 = com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$0);
            if (v0 == 0) {
                v2_1 = 0;
            } else {
                v2_1 = 1;
            }
            vtmp8.setBuildType(v2_1);
        }
        com.jlboat.phone.activity.RobotMapActivity.access$1800(this.this$0);
        return;
    }
}

package com.jlboat.phone.controller;
 class JlNaviManager$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$4(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.RobotSshResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.RobotSshResponse p5)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onSuccess:reboot").append(p5.getStatus()).toString());
        return;
    }
}

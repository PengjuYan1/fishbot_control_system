package com.jlboat.phone.activity;
 class SettingActivity$15 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$15(com.jlboat.phone.activity.SettingActivity p1)
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
        android.util.Log.d(com.jlboat.phone.activity.SettingActivity.access$000(this.this$0), new StringBuilder().append("onSuccess:reboot").append(p5.getStatus()).toString());
        return;
    }
}

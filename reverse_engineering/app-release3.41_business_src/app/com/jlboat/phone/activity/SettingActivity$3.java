package com.jlboat.phone.activity;
 class SettingActivity$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$3(com.jlboat.phone.activity.SettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.RobotSpeedListResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.RobotSpeedListResponse p5)
    {
        com.jlboat.phone.activity.SettingActivity.access$200(this.this$0);
        android.util.Log.d(com.jlboat.phone.activity.SettingActivity.access$000(this.this$0), new StringBuilder().append("onSuccess: updateSpeed: ").append(p5.getSpeed()).toString());
        com.jlboat.phone.activity.SettingActivity.access$302(this.this$0, p5.getSpeed());
        com.jlboat.phone.activity.SettingActivity.access$400(this.this$0).sendEmptyMessage(2);
        return;
    }
}

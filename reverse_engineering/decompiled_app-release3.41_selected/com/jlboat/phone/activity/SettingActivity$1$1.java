package com.jlboat.phone.activity;
 class SettingActivity$1$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.SettingActivity$1 this$1;

    SettingActivity$1$1(com.jlboat.phone.activity.SettingActivity$1 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetConfigsResponse p4)
    {
        android.util.Log.i(com.jlboat.phone.activity.SettingActivity.access$000(this.this$1.this$0), new StringBuilder().append("robotAutoChangePowerBt.getStatus:").append(p4.getStatus()).toString());
        return;
    }
}

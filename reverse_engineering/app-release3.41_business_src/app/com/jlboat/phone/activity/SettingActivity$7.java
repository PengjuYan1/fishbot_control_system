package com.jlboat.phone.activity;
 class SettingActivity$7 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$7(com.jlboat.phone.activity.SettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetConfigsResponse p3)
    {
        this.this$0.getConfigs(9);
        return;
    }
}

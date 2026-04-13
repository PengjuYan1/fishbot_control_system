package com.jlboat.phone.activity;
 class SettingActivity$10 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$10(com.jlboat.phone.activity.SettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.NavigationSafeSetResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.NavigationSafeSetResponse p6)
    {
        com.jlboat.phone.activity.SettingActivity.access$2100(this.this$0).setEnabled(1);
        com.jlboat.phone.activity.SettingActivity.access$2200(this.this$0).setEnabled(1);
        if (p6.getResult() == 0) {
            this.this$0.toast("\u5b89\u5168\u8bbe\u7f6e\u6210\u529f");
        }
        com.jlboat.phone.activity.SettingActivity.access$2300(this.this$0);
        return;
    }
}

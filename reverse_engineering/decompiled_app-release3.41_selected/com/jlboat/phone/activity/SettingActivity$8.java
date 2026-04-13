package com.jlboat.phone.activity;
 class SettingActivity$8 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$8(com.jlboat.phone.activity.SettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.RobotSpeedSetResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.RobotSpeedSetResponse p6)
    {
        com.jlboat.phone.activity.SettingActivity.access$1100(this.this$0).setEnabled(1);
        com.jlboat.phone.activity.SettingActivity.access$1200(this.this$0).setEnabled(1);
        com.jlboat.phone.activity.SettingActivity.access$1300(this.this$0).setEnabled(1);
        com.jlboat.phone.activity.SettingActivity.access$1400(this.this$0).setEnabled(1);
        com.jlboat.phone.activity.SettingActivity.access$1500(this.this$0).setEnabled(1);
        com.jlboat.phone.activity.SettingActivity.access$1600(this.this$0).setEnabled(1);
        if (p6.getResult() == 0) {
            this.this$0.toast("\u901f\u5ea6\u8bbe\u7f6e\u6210\u529f");
        }
        com.jlboat.phone.activity.SettingActivity.access$1700(this.this$0);
        return;
    }
}

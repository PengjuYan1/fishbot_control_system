package com.jlboat.phone.activity;
 class SettingActivity$6$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.SettingActivity$6 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.Config val$config;

    SettingActivity$6$1(com.jlboat.phone.activity.SettingActivity$6 p1, com.jlboat.phone.message.map_msgs.Config p2)
    {
        this.this$1 = p1;
        this.val$config = p2;
        return;
    }

    public void run()
    {
        if (!this.val$config.getConfigValue().equals("True")) {
            com.jlboat.phone.activity.SettingActivity.access$700(this.this$1.this$0).setChecked(0);
        } else {
            com.jlboat.phone.activity.SettingActivity.access$700(this.this$1.this$0).setChecked(1);
        }
        com.jlboat.phone.activity.SettingActivity.access$700(this.this$1.this$0).setEnabled(1);
        return;
    }
}

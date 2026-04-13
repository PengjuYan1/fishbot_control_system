package com.jlboat.phone.activity;
 class SettingActivity$6$3 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.SettingActivity$6 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.Config val$config;

    SettingActivity$6$3(com.jlboat.phone.activity.SettingActivity$6 p1, com.jlboat.phone.message.map_msgs.Config p2)
    {
        this.this$1 = p1;
        this.val$config = p2;
        return;
    }

    public void run()
    {
        com.jlboat.phone.activity.SettingActivity.access$802(this.this$1.this$0, Integer.parseInt(this.val$config.getConfigValue()));
        com.jlboat.phone.activity.SettingActivity.access$1000(this.this$1.this$0).setText(this.val$config.getConfigValue());
        return;
    }
}

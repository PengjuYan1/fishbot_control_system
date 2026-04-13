package com.jlboat.phone.activity;
 class SettingActivity$12 implements android.content.DialogInterface$OnClickListener {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$12(com.jlboat.phone.activity.SettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(android.content.DialogInterface p3, int p4)
    {
        p3.dismiss();
        com.jlboat.phone.activity.SettingActivity.access$2600(this.this$0).publish(new com.boat.jrosbridge.message.std_msgs.Int16());
        return;
    }
}

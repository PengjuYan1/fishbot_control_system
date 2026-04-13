package com.jlboat.phone.activity;
 class SettingActivity$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$4(com.jlboat.phone.activity.SettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.NavigationCreamSetListResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.NavigationCreamSetListResponse p5)
    {
        com.jlboat.phone.activity.SettingActivity.access$200(this.this$0);
        android.util.Log.d(com.jlboat.phone.activity.SettingActivity.access$000(this.this$0), new StringBuilder().append("onSuccess: updateCream: ").append(p5.getOp()).toString());
        com.jlboat.phone.activity.SettingActivity.access$502(this.this$0, p5.getOp());
        com.jlboat.phone.activity.SettingActivity.access$400(this.this$0).sendEmptyMessage(6);
        return;
    }
}

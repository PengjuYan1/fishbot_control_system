package com.jlboat.phone.activity;
 class SettingActivity$9 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;
    final synthetic long val$op;

    SettingActivity$9(com.jlboat.phone.activity.SettingActivity p1, long p2)
    {
        this.this$0 = p1;
        this.val$op = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.NavigationCreamSetResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.NavigationCreamSetResponse p6)
    {
        android.util.Log.e(com.jlboat.phone.activity.SettingActivity.access$000(this.this$0), new StringBuilder().append("onNewMessage").append(this.val$op).toString());
        com.jlboat.phone.activity.SettingActivity.access$1800(this.this$0).setEnabled(1);
        com.jlboat.phone.activity.SettingActivity.access$1900(this.this$0).setEnabled(1);
        if (p6.getResult() == 0) {
            this.this$0.toast("\u6444\u50cf\u5934\u8bbe\u7f6e\u6210\u529f");
        }
        com.jlboat.phone.activity.SettingActivity.access$2000(this.this$0);
        return;
    }
}

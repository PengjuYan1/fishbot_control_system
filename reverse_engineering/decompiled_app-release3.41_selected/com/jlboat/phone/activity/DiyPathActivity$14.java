package com.jlboat.phone.activity;
 class DiyPathActivity$14 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;

    DiyPathActivity$14(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetGlobalPlanResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetGlobalPlanResponse p3)
    {
        android.util.Log.e("DiyPathActivity", new StringBuilder().append("onNewMessage \u4fee\u6539\u540d\u79f0 \u65b9\u5411: ").append(p3.isResult()).toString());
        if ((p3 == null) || (!p3.isResult())) {
            this.this$0.toast(2131493305);
        } else {
            this.this$0.toast(2131493306);
            com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1004);
        }
        com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1003);
        return;
    }
}

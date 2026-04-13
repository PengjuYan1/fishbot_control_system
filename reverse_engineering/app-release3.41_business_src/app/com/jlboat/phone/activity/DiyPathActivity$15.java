package com.jlboat.phone.activity;
 class DiyPathActivity$15 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;

    DiyPathActivity$15(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.AddPointsGlobalPlanResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.AddPointsGlobalPlanResponse p3)
    {
        android.util.Log.e("DiyPathActivity", new StringBuilder().append("onNewMessage \u5220\u9664\u5bfc\u822a\u70b9\u5bf9: ").append(p3.isResult()).toString());
        if ((p3 != null) && (p3.isResult())) {
            com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1004);
            com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1003);
            this.this$0.toast(2131493257);
        }
        return;
    }
}

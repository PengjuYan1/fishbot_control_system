package com.jlboat.phone.activity;
 class PointBindPathActivity$5 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.PointBindPathActivity this$0;

    PointBindPathActivity$5(com.jlboat.phone.activity.PointBindPathActivity p1)
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
        android.util.Log.e("PointBindPathActivity", new StringBuilder().append("onNewMessage \u5220\u9664\u5bfc\u822a\u70b9\u5bf9: ").append(p3.isResult()).toString());
        if ((p3 != null) && (p3.isResult())) {
            com.jlboat.phone.activity.PointBindPathActivity.access$1400(this.this$0).sendEmptyMessage(1002);
            this.this$0.toast(2131493257);
        }
        return;
    }
}

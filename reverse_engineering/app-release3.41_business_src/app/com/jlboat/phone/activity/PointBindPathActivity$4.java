package com.jlboat.phone.activity;
 class PointBindPathActivity$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.PointBindPathActivity this$0;

    PointBindPathActivity$4(com.jlboat.phone.activity.PointBindPathActivity p1)
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
        com.jlboat.phone.activity.PointBindPathActivity.access$1810(this.this$0);
        if (com.jlboat.phone.activity.PointBindPathActivity.access$1800(this.this$0) != 0) {
            if (!p3.isResult()) {
                this.this$0.toast(2131493291);
            }
        } else {
            if (!p3.isResult()) {
                this.this$0.toast(2131493291);
            } else {
                this.this$0.toast(2131493292);
            }
        }
        return;
    }
}

package com.jlboat.phone.activity;
 class MapActivity$43 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$43(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p4)
    {
        com.jlboat.phone.activity.MapActivity.access$4400(this.this$0);
        com.jlboat.phone.activity.MapActivity.access$102(this.this$0, 0);
        com.jlboat.phone.activity.MapActivity.access$1700(this.this$0).clear();
        com.jlboat.phone.activity.MapActivity.access$2000(this.this$0).sendEmptyMessage(1);
        com.jlboat.phone.activity.MapActivity.access$1800(this.this$0).clear();
        com.jlboat.phone.activity.MapActivity.access$2200(this.this$0).clear();
        com.jlboat.phone.activity.MapActivity.access$2300(this.this$0).clear();
        com.jlboat.phone.activity.MapActivity.access$2400(this.this$0).clear();
        com.jlboat.phone.activity.MapActivity.access$1100(this.this$0);
        return;
    }
}

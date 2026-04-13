package com.jlboat.phone.activity;
 class MapActivity$49 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$49(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.PointUpdateResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.PointUpdateResponse p6)
    {
        com.jlboat.phone.activity.MapActivity.access$4400(this.this$0);
        if (p6.getResult() == 0) {
            this.this$0.toast(2131493252);
        }
        return;
    }
}

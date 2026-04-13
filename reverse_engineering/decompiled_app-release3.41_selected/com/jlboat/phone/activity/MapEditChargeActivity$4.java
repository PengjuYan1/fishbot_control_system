package com.jlboat.phone.activity;
 class MapEditChargeActivity$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditChargeActivity this$0;

    MapEditChargeActivity$4(com.jlboat.phone.activity.MapEditChargeActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetInt64ArrayResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetInt64ArrayResponse p3)
    {
        this.this$0.toast(2131493252);
        return;
    }
}

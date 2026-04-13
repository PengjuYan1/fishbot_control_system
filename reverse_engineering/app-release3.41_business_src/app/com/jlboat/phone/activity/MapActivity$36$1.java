package com.jlboat.phone.activity;
 class MapActivity$36$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity$36 this$1;

    MapActivity$36$1(com.jlboat.phone.activity.MapActivity$36 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetInt64ArrayResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetInt64ArrayResponse p3)
    {
        this.this$1.this$0.toast(2131493252);
        return;
    }
}

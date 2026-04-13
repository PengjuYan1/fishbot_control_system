package com.jlboat.phone.activity;
 class MapEditMapActivity2025$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditMapActivity2025 this$0;

    MapEditMapActivity2025$4(com.jlboat.phone.activity.MapEditMapActivity2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SaveMapStringResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SaveMapStringResponse p3)
    {
        this.this$0.toast(2131493306);
        com.jlboat.phone.activity.MapEditMapActivity2025.access$200(this.this$0);
        com.jlboat.phone.activity.MapEditMapActivity2025.access$100(this.this$0).post(new com.jlboat.phone.activity.MapEditMapActivity2025$4$1(this));
        com.jlboat.phone.activity.MapEditMapActivity2025.access$500(this.this$0);
        return;
    }
}

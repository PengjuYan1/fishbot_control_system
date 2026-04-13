package com.jlboat.phone.activity;
 class MapExpansionActivity$29 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;

    MapExpansionActivity$29(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.PointRenameResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.PointRenameResponse p5)
    {
        com.jlboat.phone.activity.MapExpansionActivity.access$1800(this.this$0);
        this.this$0.toast(new StringBuilder().append(p5.getResult()).append("").toString());
        return;
    }
}

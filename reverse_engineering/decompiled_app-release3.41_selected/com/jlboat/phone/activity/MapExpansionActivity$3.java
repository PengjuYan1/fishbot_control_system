package com.jlboat.phone.activity;
 class MapExpansionActivity$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;

    MapExpansionActivity$3(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p3)
    {
        if (com.jlboat.phone.activity.MapExpansionActivity.access$300(this.this$0)) {
            com.jlboat.phone.activity.MapExpansionActivity.access$302(this.this$0, 0);
            com.jlboat.phone.activity.MapExpansionActivity.access$400(this.this$0);
        }
        return;
    }
}

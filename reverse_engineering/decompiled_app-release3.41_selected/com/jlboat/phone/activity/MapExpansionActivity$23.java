package com.jlboat.phone.activity;
 class MapExpansionActivity$23 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;

    MapExpansionActivity$23(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SaveMapResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SaveMapResponse p3)
    {
        if (p3.getStatus() == 0) {
            com.jlboat.phone.activity.MapExpansionActivity.access$302(this.this$0, 1);
            return;
        } else {
            com.jlboat.phone.activity.MapExpansionActivity.access$1800(this.this$0);
            this.this$0.toast(p3.getMessage());
            return;
        }
    }
}

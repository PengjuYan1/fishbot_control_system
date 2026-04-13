package com.jlboat.phone.activity;
 class MapExpansionActivity$27 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;

    MapExpansionActivity$27(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.DeleteTestPointResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.DeleteTestPointResponse p6)
    {
        com.jlboat.phone.activity.MapExpansionActivity.access$1800(this.this$0);
        if (p6.getResult() != 0) {
            if (p6.getResult() != 4) {
                this.this$0.toast(2131493241);
            } else {
                this.this$0.toast(2131493277);
            }
        } else {
            this.this$0.toast(2131493252);
        }
        return;
    }
}

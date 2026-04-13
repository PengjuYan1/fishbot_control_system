package com.jlboat.phone.activity;
 class MapActivity$47 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$47(com.jlboat.phone.activity.MapActivity p1)
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
        com.jlboat.phone.activity.MapActivity.access$4400(this.this$0);
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

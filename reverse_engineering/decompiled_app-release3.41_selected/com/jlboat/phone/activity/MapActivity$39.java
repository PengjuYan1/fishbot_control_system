package com.jlboat.phone.activity;
 class MapActivity$39 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$39(com.jlboat.phone.activity.MapActivity p1)
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
            com.jlboat.phone.activity.MapActivity.access$502(this.this$0, 1);
            if (this.this$0.isFinish == 1) {
                this.this$0.isFinish = 2;
            }
            return;
        } else {
            com.jlboat.phone.activity.MapActivity.access$4400(this.this$0);
            this.this$0.toast(p3.getMessage());
            return;
        }
    }
}

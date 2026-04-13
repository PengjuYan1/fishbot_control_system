package com.jlboat.phone.activity;
 class MapActivity$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$4(com.jlboat.phone.activity.MapActivity p1)
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
        if (com.jlboat.phone.activity.MapActivity.access$500(this.this$0)) {
            com.jlboat.phone.activity.MapActivity.access$502(this.this$0, 0);
            com.jlboat.phone.activity.MapActivity.access$600(this.this$0);
            if (this.this$0.isFinish == 2) {
                this.this$0.finish();
            }
        }
        this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapActivity$4$1(this, p3));
        return;
    }
}

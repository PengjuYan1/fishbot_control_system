package com.jlboat.phone.activity;
 class MapActivity$51$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity$51 this$1;

    MapActivity$51$1(com.jlboat.phone.activity.MapActivity$51 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p3)
    {
        android.util.Log.d("MapActivity", new StringBuilder().append("locationStatus onNewMessage: ").append(p3.getData()).toString());
        com.jlboat.phone.activity.MapActivity.access$4700(this.this$1.this$0).unsubscribe();
        if ((p3.getData() == 0) || (p3.getData() == 1)) {
            com.jlboat.phone.activity.MapActivity.access$4800(this.this$1.this$0);
        }
        return;
    }
}

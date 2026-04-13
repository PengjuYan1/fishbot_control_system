package com.jlboat.phone.activity;
 class MapActivity$12 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic int val$type;

    MapActivity$12(com.jlboat.phone.activity.MapActivity p1, int p2)
    {
        this.this$0 = p1;
        this.val$type = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p3)
    {
        android.util.Log.i("MapActivity", "loadMap() Success");
        if (this.val$type == 0) {
            com.jlboat.phone.activity.MapActivity.access$502(this.this$0, 1);
        }
        com.jlboat.phone.activity.MapActivity.access$900(this.this$0).clearPoints();
        return;
    }
}

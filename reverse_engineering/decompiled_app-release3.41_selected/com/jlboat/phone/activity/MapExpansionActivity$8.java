package com.jlboat.phone.activity;
 class MapExpansionActivity$8 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;
    final synthetic int val$type;

    MapExpansionActivity$8(com.jlboat.phone.activity.MapExpansionActivity p1, int p2)
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
        android.util.Log.i("MapExpansionActivity", "loadMap() Success");
        if (this.val$type == 0) {
            com.jlboat.phone.activity.MapExpansionActivity.access$302(this.this$0, 1);
        }
        return;
    }
}

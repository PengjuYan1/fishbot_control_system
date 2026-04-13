package com.jlboat.phone.activity;
 class MapExpansionActivity$22 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;

    MapExpansionActivity$22(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ClearMapResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ClearMapResponse p3)
    {
        android.util.Log.d("MapExpansionActivity", "rebuildMap onSuccess: ");
        com.jlboat.phone.activity.MapExpansionActivity.access$302(this.this$0, 1);
        return;
    }
}

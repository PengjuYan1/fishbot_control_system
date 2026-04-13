package com.jlboat.phone.activity;
 class MapActivity$46 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$46(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetPositionResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetPositionResponse p3)
    {
        android.util.Log.d("MapActivity", new StringBuilder().append("onSuccess: GetPositionResponse() Success \nx: ").append(p3.getPose().getX()).append("\ny: ").append(p3.getPose().getY()).append("\nz: ").append(p3.getPose().getZ()).toString());
        return;
    }
}

package com.jlboat.phone.adapter;
 class OdomAdapter$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.adapter.OdomAdapter this$0;

    OdomAdapter$2(com.jlboat.phone.adapter.OdomAdapter p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetConfigsResponse p4)
    {
        android.util.Log.d(com.jlboat.phone.adapter.OdomAdapter.access$700(), new StringBuilder().append("SetOrDelConfigsService onSuccess: ").append(p4.getStatus()).toString());
        com.jlboat.phone.adapter.OdomAdapter.access$802(this.this$0, ((long) p4.getStatus()));
        com.jlboat.phone.adapter.OdomAdapter.access$900(this.this$0).sendEmptyMessage(1);
        return;
    }
}

package com.jlboat.phone.adapter;
 class ConfigListAdapter$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.adapter.ConfigListAdapter this$0;

    ConfigListAdapter$2(com.jlboat.phone.adapter.ConfigListAdapter p1)
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
        android.util.Log.d("TAG", new StringBuilder().append("onSuccess: ").append(p4.getStatus()).toString());
        com.jlboat.phone.adapter.ConfigListAdapter.access$702(this.this$0, ((long) p4.getStatus()));
        com.jlboat.phone.adapter.ConfigListAdapter.access$800(this.this$0).sendEmptyMessage(1);
        return;
    }
}

package com.jlboat.phone.fragment.statusfragment;
 class LoraFragment$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.LoraFragment this$0;

    LoraFragment$4(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetConfigsResponse p3)
    {
        if (p3.getStatus() == 0) {
            com.jlboat.phone.fragment.statusfragment.LoraFragment.access$700(this.this$0, "ok");
        }
        this.this$0.getConfigs(9);
        return;
    }
}

package com.jlboat.phone.fragment.statusfragment;
 class InfraredFragment$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.InfraredFragment this$0;

    InfraredFragment$2(com.jlboat.phone.fragment.statusfragment.InfraredFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p3)
    {
        com.jlboat.phone.fragment.statusfragment.InfraredFragment.access$300(this.this$0).post(new com.jlboat.phone.fragment.statusfragment.InfraredFragment$2$1(this));
        return;
    }
}

package com.jlboat.phone.fragment.statusfragment;
 class InfraredFragment$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.InfraredFragment this$0;

    InfraredFragment$1(com.jlboat.phone.fragment.statusfragment.InfraredFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.RobotIrCode) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.RobotIrCode p3)
    {
        com.jlboat.phone.fragment.statusfragment.InfraredFragment.access$000(this.this$0).post(new com.jlboat.phone.fragment.statusfragment.InfraredFragment$1$1(this, p3));
        return;
    }
}

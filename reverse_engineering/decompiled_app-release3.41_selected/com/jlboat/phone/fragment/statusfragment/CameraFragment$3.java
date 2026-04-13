package com.jlboat.phone.fragment.statusfragment;
 class CameraFragment$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.CameraFragment this$0;

    CameraFragment$3(com.jlboat.phone.fragment.statusfragment.CameraFragment p1)
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
            com.jlboat.phone.fragment.statusfragment.CameraFragment.access$200(this.this$0, "ok");
        }
        com.jlboat.phone.fragment.statusfragment.CameraFragment.access$400(this.this$0).post(new com.jlboat.phone.fragment.statusfragment.CameraFragment$3$1(this));
        this.this$0.getConfigs(9);
        return;
    }
}

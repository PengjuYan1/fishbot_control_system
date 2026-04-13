package com.jlboat.phone.fragment.statusfragment;
 class Camera03Fragment$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.Camera03Fragment this$0;

    Camera03Fragment$2(com.jlboat.phone.fragment.statusfragment.Camera03Fragment p1)
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
            com.jlboat.phone.fragment.statusfragment.Camera03Fragment.access$000(this.this$0, "ok");
        }
        com.jlboat.phone.fragment.statusfragment.Camera03Fragment.access$200(this.this$0).post(new com.jlboat.phone.fragment.statusfragment.Camera03Fragment$2$1(this));
        this.this$0.getConfigs(9);
        return;
    }
}

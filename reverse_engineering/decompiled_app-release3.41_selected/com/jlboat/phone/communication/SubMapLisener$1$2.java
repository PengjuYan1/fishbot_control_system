package com.jlboat.phone.communication;
 class SubMapLisener$1$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.communication.SubMapLisener$1 this$1;
    final synthetic int val$index;

    SubMapLisener$1$2(com.jlboat.phone.communication.SubMapLisener$1 p1, int p2)
    {
        this.this$1 = p1;
        this.val$index = p2;
        return;
    }

    public void onNewMessage(cartographer_ros_msgs.SubmapQueryResponse p5)
    {
        if (p5.getStatus().getCode() == 0) {
            com.jlboat.phone.communication.SubMapLisener.access$200(this.this$1.this$0, 1, this.val$index, p5.getTextures());
        }
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((cartographer_ros_msgs.SubmapQueryResponse) p1));
        return;
    }
}

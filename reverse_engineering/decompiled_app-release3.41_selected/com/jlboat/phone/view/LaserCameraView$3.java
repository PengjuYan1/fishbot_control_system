package com.jlboat.phone.view;
 class LaserCameraView$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.view.LaserCameraView this$0;

    LaserCameraView$3(com.jlboat.phone.view.LaserCameraView p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.sensor_msgs.LaserScan) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.sensor_msgs.LaserScan p3)
    {
        if ((com.jlboat.phone.view.LaserCameraView.access$000(this.this$0) != null) && (!com.jlboat.phone.view.LaserCameraView.access$100(this.this$0))) {
            this.this$0.post(new com.jlboat.phone.view.LaserCameraView$3$1(this));
        }
        com.jlboat.phone.view.LaserCameraView.access$500(this.this$0, p3, com.jlboat.phone.view.LaserCameraView.access$200(this.this$0));
        return;
    }
}

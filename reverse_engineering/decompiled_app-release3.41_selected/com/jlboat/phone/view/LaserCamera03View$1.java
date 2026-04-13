package com.jlboat.phone.view;
 class LaserCamera03View$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.view.LaserCamera03View this$0;

    LaserCamera03View$1(com.jlboat.phone.view.LaserCamera03View p1)
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
        android.util.Log.d("LaserCamera03View", "onNewMessage: ");
        if ((com.jlboat.phone.view.LaserCamera03View.access$000(this.this$0) != null) && (!com.jlboat.phone.view.LaserCamera03View.access$100(this.this$0))) {
            this.this$0.post(new com.jlboat.phone.view.LaserCamera03View$1$1(this));
        }
        com.jlboat.phone.view.LaserCamera03View.access$300(this.this$0, p3, com.jlboat.phone.view.LaserCamera03View.access$200(this.this$0));
        return;
    }
}

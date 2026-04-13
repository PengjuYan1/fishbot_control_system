package com.jlboat.phone.activity;
 class PointBindPathActivity$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.PointBindPathActivity this$0;

    PointBindPathActivity$2(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int32) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int32 p3)
    {
        if (this.this$0.mapView != null) {
            this.this$0.mapView.setProhibition(new java.util.LinkedList());
            this.this$0.mapView.setPoints(new java.util.LinkedList());
            this.this$0.mapView.setGlobalPlans(new java.util.LinkedList());
        }
        com.jlboat.phone.activity.PointBindPathActivity.access$1500(this.this$0).getMapsService(new com.jlboat.phone.activity.PointBindPathActivity$2$1(this));
        return;
    }
}

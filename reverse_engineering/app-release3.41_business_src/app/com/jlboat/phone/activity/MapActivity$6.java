package com.jlboat.phone.activity;
 class MapActivity$6 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$6(com.jlboat.phone.activity.MapActivity p1)
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
        if (com.jlboat.phone.activity.MapActivity.access$900(this.this$0) != null) {
            com.jlboat.phone.activity.MapActivity.access$900(this.this$0).setProhibition(new java.util.LinkedList());
            com.jlboat.phone.activity.MapActivity.access$900(this.this$0).setPoints(new java.util.LinkedList());
            com.jlboat.phone.activity.MapActivity.access$900(this.this$0).setRegion(new java.util.LinkedList());
            com.jlboat.phone.activity.MapActivity.access$900(this.this$0).setGlobalPlans(new java.util.LinkedList());
            com.jlboat.phone.activity.MapActivity.access$900(this.this$0).setNgLines(new java.util.LinkedList());
        }
        com.jlboat.phone.activity.MapActivity.access$2100(this.this$0).getMapsService(new com.jlboat.phone.activity.MapActivity$6$1(this));
        com.jlboat.phone.activity.MapActivity.access$2100(this.this$0).getBuildPointsService(new com.jlboat.phone.activity.MapActivity$6$2(this));
        return;
    }
}

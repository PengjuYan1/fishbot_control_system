package com.jlboat.phone.activity;
 class MapExpansionActivity$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;

    MapExpansionActivity$4(com.jlboat.phone.activity.MapExpansionActivity p1)
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
        if (com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$0) != null) {
            com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$0).setProhibition(new java.util.LinkedList());
            com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$0).setPoints(new java.util.LinkedList());
            com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$0).setGlobalPlans(new java.util.LinkedList());
        }
        com.jlboat.phone.activity.MapExpansionActivity.access$1400(this.this$0).getMapsService(new com.jlboat.phone.activity.MapExpansionActivity$4$1(this));
        com.jlboat.phone.activity.MapExpansionActivity.access$1400(this.this$0).getBuildPointsService(new com.jlboat.phone.activity.MapExpansionActivity$4$2(this));
        return;
    }
}

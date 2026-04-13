package com.jlboat.phone.activity;
 class DiyPointPathActivity$8 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;

    DiyPointPathActivity$8(com.jlboat.phone.activity.DiyPointPathActivity p1)
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
        if (com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$0) != null) {
            com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$0).setProhibition(new java.util.LinkedList());
            com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$0).setPoints(new java.util.LinkedList());
            com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$0).setGlobalPlans(new java.util.LinkedList());
            com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$0).setNgLines(new java.util.LinkedList());
            this.this$0.runOnUiThread(new com.jlboat.phone.activity.DiyPointPathActivity$8$1(this));
        }
        com.jlboat.phone.activity.DiyPointPathActivity.access$1600(this.this$0).getMapsService(new com.jlboat.phone.activity.DiyPointPathActivity$8$2(this));
        return;
    }
}

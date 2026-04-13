package com.jlboat.phone.activity;
 class DiyPathActivity$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;

    DiyPathActivity$3(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int32) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int32 p4)
    {
        if (com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$0) != null) {
            com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$0).setProhibition(new java.util.LinkedList());
            com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$0).setPoints(new java.util.LinkedList());
            com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$0).setGlobalPlans(new java.util.LinkedList());
            com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$0).setSelectedGlobalPlans(-1);
        }
        com.jlboat.phone.activity.DiyPathActivity.access$2100(this.this$0).getMapsService(new com.jlboat.phone.activity.DiyPathActivity$3$1(this));
        return;
    }
}

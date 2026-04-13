package com.jlboat.phone.activity;
 class MultiMachineSchedulingActivity$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MultiMachineSchedulingActivity this$0;
    final synthetic int val$type;

    MultiMachineSchedulingActivity$4(com.jlboat.phone.activity.MultiMachineSchedulingActivity p1, int p2)
    {
        this.this$0 = p1;
        this.val$type = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetConfigsResponse p3)
    {
        if (this.val$type == 9) {
            this.this$0.getConfigs(9);
        }
        return;
    }
}

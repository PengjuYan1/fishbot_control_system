package com.jlboat.phone.activity;
 class MultiMachineSchedulingActivity$1$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MultiMachineSchedulingActivity$1 this$1;

    MultiMachineSchedulingActivity$1$1(com.jlboat.phone.activity.MultiMachineSchedulingActivity$1 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetConfigsResponse p1)
    {
        return;
    }
}

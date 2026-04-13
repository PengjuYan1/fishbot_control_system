package com.jlboat.phone.activity;
 class MultiMachineSchedulingActivity$3$2 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MultiMachineSchedulingActivity$3 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.Config val$config;

    MultiMachineSchedulingActivity$3$2(com.jlboat.phone.activity.MultiMachineSchedulingActivity$3 p1, com.jlboat.phone.message.map_msgs.Config p2)
    {
        this.this$1 = p1;
        this.val$config = p2;
        return;
    }

    public void run()
    {
        com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$602(this.this$1.this$0, (Double.parseDouble(this.val$config.getConfigValue()) / 4607182418800017408));
        com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$700(this.this$1.this$0).setText(this.val$config.getConfigValue());
        return;
    }
}

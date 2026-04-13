package com.jlboat.phone.activity;
 class MultiMachineSchedulingActivity$3$3 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MultiMachineSchedulingActivity$3 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.Config val$config;

    MultiMachineSchedulingActivity$3$3(com.jlboat.phone.activity.MultiMachineSchedulingActivity$3 p1, com.jlboat.phone.message.map_msgs.Config p2)
    {
        this.this$1 = p1;
        this.val$config = p2;
        return;
    }

    public void run()
    {
        com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$802(this.this$1.this$0, ((int) Double.parseDouble(this.val$config.getConfigValue())));
        android.util.Log.d("MultiMachineSchedulingActivity", new StringBuilder().append("priority_level:").append(com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$800(this.this$1.this$0)).toString());
        com.jlboat.phone.activity.MultiMachineSchedulingActivity.access$900(this.this$1.this$0).setText(this.val$config.getConfigValue().replaceAll("\\.0+", ""));
        return;
    }
}

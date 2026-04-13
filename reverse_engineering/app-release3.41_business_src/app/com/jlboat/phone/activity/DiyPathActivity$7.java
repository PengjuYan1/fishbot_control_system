package com.jlboat.phone.activity;
 class DiyPathActivity$7 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;
    final synthetic com.boat.support.slam.entity.floors.GlobalPlans val$globalPlans;

    DiyPathActivity$7(com.jlboat.phone.activity.DiyPathActivity p1, com.boat.support.slam.entity.floors.GlobalPlans p2)
    {
        this.this$0 = p1;
        this.val$globalPlans = p2;
        return;
    }

    public void onClick(android.view.View p4)
    {
        com.jlboat.phone.activity.DiyPathActivity.access$2600(this.this$0).dismiss();
        com.boat.jrosbridge.message.std_msgs.Int64 v0_3 = new com.boat.jrosbridge.message.std_msgs.Int64();
        v0_3.setData(this.val$globalPlans.getGlobalplanId());
        com.jlboat.phone.activity.DiyPathActivity.access$2700(this.this$0).publish(v0_3);
        com.jlboat.phone.activity.DiyPathActivity.access$1300(this.this$0).setVisibility(0);
        this.this$0.bt_add_start.setVisibility(8);
        return;
    }
}

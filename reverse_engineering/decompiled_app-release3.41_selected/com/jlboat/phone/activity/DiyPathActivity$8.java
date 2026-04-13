package com.jlboat.phone.activity;
 class DiyPathActivity$8 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;
    final synthetic com.boat.support.slam.entity.floors.GlobalPlans val$globalPlans;

    DiyPathActivity$8(com.jlboat.phone.activity.DiyPathActivity p1, com.boat.support.slam.entity.floors.GlobalPlans p2)
    {
        this.this$0 = p1;
        this.val$globalPlans = p2;
        return;
    }

    public void onClick(android.view.View p3)
    {
        com.jlboat.phone.activity.DiyPathActivity.access$2600(this.this$0).dismiss();
        com.jlboat.phone.activity.DiyPathActivity.access$2800(this.this$0, this.val$globalPlans);
        return;
    }
}

package com.jlboat.phone.activity;
 class DiyPathActivity$10 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;
    final synthetic com.boat.support.slam.entity.floors.GlobalPlans val$globalPlans;
    final synthetic int val$postion;

    DiyPathActivity$10(com.jlboat.phone.activity.DiyPathActivity p1, int p2, com.boat.support.slam.entity.floors.GlobalPlans p3)
    {
        this.this$0 = p1;
        this.val$postion = p2;
        this.val$globalPlans = p3;
        return;
    }

    public void onClick(android.view.View p11)
    {
        com.jlboat.phone.activity.DiyPathActivity.access$2600(this.this$0).dismiss();
        com.jlboat.phone.view.MyPopupWindow v0_2 = this.this$0;
        com.jlboat.phone.view.MyPopupWindow v9 = new com.jlboat.phone.view.MyPopupWindow;
        v9(this.this$0, this.this$0.getResString(2131493085), new StringBuilder().append(this.this$0.getResString(2131493083)).append(((com.boat.support.slam.entity.floors.GlobalPlans) com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0).get(this.val$postion)).getGlobalplanName()).append(this.this$0.getResString(2131493081)).toString(), this.this$0.getResString(2131493080), 1, new com.jlboat.phone.activity.DiyPathActivity$10$1(this), new com.jlboat.phone.activity.DiyPathActivity$10$2(this));
        com.jlboat.phone.activity.DiyPathActivity.access$2902(v0_2, v9);
        com.jlboat.phone.activity.DiyPathActivity.access$2900(this.this$0).showAtLocation(com.jlboat.phone.activity.DiyPathActivity.access$3000(this.this$0), 17, 0, 0);
        return;
    }
}

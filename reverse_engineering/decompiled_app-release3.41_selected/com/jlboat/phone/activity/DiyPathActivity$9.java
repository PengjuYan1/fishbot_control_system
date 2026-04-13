package com.jlboat.phone.activity;
 class DiyPathActivity$9 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;
    final synthetic int val$postion;

    DiyPathActivity$9(com.jlboat.phone.activity.DiyPathActivity p1, int p2)
    {
        this.this$0 = p1;
        this.val$postion = p2;
        return;
    }

    public void onClick(android.view.View p5)
    {
        com.jlboat.phone.activity.DiyPathActivity.access$2600(this.this$0).dismiss();
        android.content.Intent v0_3 = new android.content.Intent(this.this$0, com.jlboat.phone.activity.PointBindPathActivity);
        v0_3.putExtra("data", ((com.boat.support.slam.entity.floors.GlobalPlans) com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0).get(this.val$postion)).getGlobalplanId());
        this.this$0.startActivity(v0_3);
        return;
    }
}
